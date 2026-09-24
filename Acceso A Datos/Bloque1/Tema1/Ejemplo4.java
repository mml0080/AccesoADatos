import java.io.FileReader;
import java.io.FileWriter;

//Ejemplo: uso de FileReader y FileWriter

public class Ejemplo4 {

    public static void main(String[] args) {

        String path = "./TEMA01/Ejemplos/texto.txt";
        String pathEscritura = "./TEMA01/Ejemplos/textow.txt";

        try {
            FileReader fr = new FileReader(path);
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
            fr.close();
            System.out.println("\nLectura completada.");
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        try {
            FileWriter fw = new FileWriter(pathEscritura);
            fw.write("Esto es un ejemplo de escriturá");
            fw.close();
            System.out.println("Fichero escrito correctamente.");
        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}