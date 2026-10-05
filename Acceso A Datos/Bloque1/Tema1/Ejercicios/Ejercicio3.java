import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        
        String nombreArchivo = "datos.txt";

        try {
            FileWriter escritor = new FileWriter(nombreArchivo);

            escritor.write("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            escritor.close();

            System.out.println("Se ha creado el archivo con el abecedario.");

            Scanner teclado = new Scanner(System.in);

            System.out.print("Introduce la posición que quieres modificar (0-25): ");
            int posicion = teclado.nextInt();
            System.out.print("Introduce el carácter que quieres escribir: ");
            String entrada = teclado.next();

            char caracter = entrada.charAt(0);

            // 4. Usar RandomAccessFile para modificar la posición
            try (RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw")) {

                // Nos posicionamos en la posición indicada
                archivo.seek(posicion);

                // Sobrescribimos el carácter
                archivo.write(caracter);

            }

            System.out.println("Archivo modificado correctamente.");

            teclado.close();

        } catch (IOException e) {
            // Errores de lectura/escritura o si el archivo no existe
            System.out.println("Error al trabajar con el archivo: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            // Posición o carácter inválido
            System.out.println("Error: " + e.getMessage());
        }

    }
}
