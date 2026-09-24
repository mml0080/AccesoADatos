import java.io.File;

// Ejemplo: Mover carpeta con renameTo

public class Ejemplo2 {

    public static void main(String[] args) {
       
        File ficheroOrigen = new File(".\\TEMA01\\Ejemplos\\crearFichero.txt");
        String nombreCarpeta = "Backup";
        File carpeta = new File(".\\TEMA01\\Ejemplos", nombreCarpeta);
        carpeta.mkdirs();

        File ficheroDestino = new File(".\\TEMA01\\Ejemplos\\Backup\\fichero_movido.txt");
        if (ficheroOrigen.renameTo(ficheroDestino))
            System.out.println("El fichero se movió correctamente");
        else
            System.out.println("El fichero no pudo moverse");
    }
}