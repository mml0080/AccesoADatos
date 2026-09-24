import java.io.File;

//Ejemplo: Crea un fichero vacío en la ruta indicada si no existe

public class Ejemplo1 {

    public static void main(String[] args) {
        try {
            File fichero = new File(".\\TEMA01\\Ejemplos\\crearFichero.txt");
            if (fichero.createNewFile()) {
                System.out.println("Fichero creado: " + fichero.getName());
            } else {
                System.out.println("El fichero ya existe.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
