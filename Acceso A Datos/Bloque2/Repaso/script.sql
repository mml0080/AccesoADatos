-- ==========================================
-- 1. Crear la base de datos
-- ==========================================
CREATE DATABASE IF NOT EXISTS gimnasio;
USE gimnasio;

-- ==========================================
-- 2. Crear las tablas
-- ==========================================
-- Nota: Es importante crear primero las tablas que no tienen claves foráneas (monitor y socio)

CREATE TABLE monitor (
    id_monitor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    telefono VARCHAR(9)
);

CREATE TABLE socio (
    id_socio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    ciudad VARCHAR(40),
    email VARCHAR(80)
);

CREATE TABLE actividad (
    id_actividad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    precio DECIMAL(6,2) NOT NULL,
    plazas INT,
    id_monitor INT NOT NULL,
    FOREIGN KEY (id_monitor) REFERENCES monitor(id_monitor)
);

CREATE TABLE inscripcion (
    id_inscripcion INT AUTO_INCREMENT PRIMARY KEY,
    id_socio INT NOT NULL,
    id_actividad INT NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY (id_socio) REFERENCES socio(id_socio),
    FOREIGN KEY (id_actividad) REFERENCES actividad(id_actividad)
);

-- ==========================================
-- 3. Modificar la estructura
-- ==========================================
-- 3.1 Añade una columna telefono
ALTER TABLE socio ADD COLUMN telefono VARCHAR(9);

-- 3.2 Cambia el tipo de telefono a VARCHAR(15)
ALTER TABLE socio MODIFY COLUMN telefono VARCHAR(15);

-- 3.3 Elimina la columna telefono
ALTER TABLE socio DROP COLUMN telefono;

-- ==========================================
-- 4. Insertar datos
-- ==========================================
-- 4.1 Inserta tu fila en socio (Usando tus datos: Martín Moreno López)
INSERT INTO socio (id_socio, nombre, ciudad, email) 
VALUES (1, 'Martín Moreno López', 'Malaga', 'martin.moreno@email.com');

-- 4.2 Comprueba con un SELECT
SELECT * FROM socio;

-- 4.3 Aquí deberías ejecutar el script proporcionado por tu profesor:
-- SOURCE ruta/al/archivo/datos_gimnasio.sql; (o hacerlo desde la interfaz gráfica de Workbench)

-- 4.4 Comprueba que se han insertado los datos
SELECT * FROM monitor;
SELECT * FROM socio;
SELECT * FROM actividad;
SELECT * FROM inscripcion;

-- ==========================================
-- 5. Consultas sencillas
-- ==========================================
-- 5.1 Todos los datos de todos los socios
SELECT * FROM socio;

-- 5.2 Nombre y email de los socios de Málaga
SELECT nombre, email FROM socio WHERE ciudad = 'Malaga';

-- 5.3 Nombre y precio de las actividades de menos de 20 €, ordenadas por precio
SELECT nombre, precio FROM actividad WHERE precio < 20 ORDER BY precio ASC;

-- 5.4 Nombre de los socios cuyo nombre empieza por «A»
SELECT nombre FROM socio WHERE nombre LIKE 'A%';

-- 5.5 Nombre de los socios que no tienen email
SELECT nombre FROM socio WHERE email IS NULL OR email = '';

-- 5.6 Las ciudades de los socios, sin repetir ninguna
SELECT DISTINCT ciudad FROM socio;

-- 5.7 Las actividades con precio entre 15 y 20 € (BETWEEN)
SELECT * FROM actividad WHERE precio BETWEEN 15 AND 20;

-- 5.8 Las actividades que cuesten menos de 20 € y tengan 10 plazas o más
SELECT * FROM actividad WHERE precio < 20 AND plazas >= 10;

-- ==========================================
-- 6. Modificar datos
-- ==========================================
-- Desactivar el modo seguro para evitar el error 1175 (opcional si se filtra por PK)
SET SQL_SAFE_UPDATES = 0;

-- 6.1 Carla Gil (socio 3) se ha mudado a Córdoba
UPDATE socio SET ciudad = 'Cordoba' WHERE id_socio = 3;

-- 6.2 Sube un 10 % el precio de Yoga (actividad 1)
UPDATE actividad SET precio = precio * 1.10 WHERE id_actividad = 1;

-- 6.3 Quita una plaza a Boxeo (actividad 4)
UPDATE actividad SET plazas = plazas - 1 WHERE id_actividad = 4;

-- Comprobación:
SELECT * FROM actividad WHERE id_actividad IN (1, 4);

-- ==========================================
-- 7. Consultas con JOIN
-- ==========================================
-- 7.1 Nombre del socio, nombre de la actividad y fecha de todas las inscripciones
SELECT s.nombre AS socio, a.nombre AS actividad, i.fecha 
FROM inscripcion i
JOIN socio s ON i.id_socio = s.id_socio
JOIN actividad a ON i.id_actividad = a.id_actividad;

-- 7.2 Las actividades a las que estás apuntado tú (socio 1)
SELECT a.nombre 
FROM inscripcion i
JOIN actividad a ON i.id_actividad = a.id_actividad
WHERE i.id_socio = 1;

-- 7.3 Cuántos inscritos tiene cada actividad
SELECT a.nombre, COUNT(i.id_inscripcion) AS inscritos
FROM actividad a
LEFT JOIN inscripcion i ON a.id_actividad = i.id_actividad
GROUP BY a.id_actividad, a.nombre;

-- 7.4 Los socios que no están apuntados a ninguna actividad
SELECT s.nombre 
FROM socio s
LEFT JOIN inscripcion i ON s.id_socio = i.id_socio
WHERE i.id_inscripcion IS NULL;

-- 7.5 El nombre de cada actividad con el nombre de su monitor
SELECT a.nombre AS actividad, m.nombre AS monitor
FROM actividad a
JOIN monitor m ON a.id_monitor = m.id_monitor;

-- 7.6 Cuántas actividades imparte cada monitor, incluidos los que no imparten ninguna
SELECT m.nombre, COUNT(a.id_actividad) AS actividades_impartidas
FROM monitor m
LEFT JOIN actividad a ON m.id_monitor = a.id_monitor
GROUP BY m.id_monitor, m.nombre;

-- ==========================================
-- 8. Borrar datos
-- ==========================================
-- 8.1 Borra la inscripción número 8
DELETE FROM inscripcion WHERE id_inscripcion = 8;

-- 8.2 Intenta borrar al socio 1 (tú). 
-- Instrucción: DELETE FROM socio WHERE id_socio = 1;
-- EXPLICACIÓN: Da el error 1451 (Cannot delete or update a parent row) porque el socio 1 tiene registros asociados 
-- en la tabla hija `inscripcion`. Por la integridad referencial (Foreign Key), no se puede borrar un socio 
-- si existen inscripciones que dependen de él.

-- 8.3 Borra al socio 6 (Alberto Vega).
DELETE FROM socio WHERE id_socio = 6;
-- EXPLICACIÓN DE POR QUÉ FUNCIONA: Este borrado sí funciona porque Alberto Vega (socio 6) no tiene 
-- ninguna inscripción asociada en la tabla `inscripcion`. Al no haber registros dependientes, la base de datos permite eliminarlo.

-- 8.4 Intenta borrar al monitor 1 y luego borra al 3.
-- Intento: DELETE FROM monitor WHERE id_monitor = 1; (Dará error 1451)
-- Borrado: 
DELETE FROM monitor WHERE id_monitor = 3;
-- EXPLICACIÓN DE LA DIFERENCIA: Ocurre exactamente lo mismo que con los socios. El monitor 1 (Laura Vidal) 
-- tiene actividades asignadas a su cargo (es clave foránea en la tabla `actividad`), por lo que no se puede borrar. 
-- El monitor 3 (Marta Rey) no tiene ninguna actividad asignada, por lo que su borrado se ejecuta sin problemas.