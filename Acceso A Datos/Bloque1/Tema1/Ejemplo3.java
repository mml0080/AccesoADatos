import java.io.File;

//Ejemplo: crear una carpeta en caso de que no exista

public class Ejemplo3 {

    public static void main(String[] args) {
        
        String nombreCarpeta = "NuevaCarpeta";
        File carpeta = new File(".\\TEMA01\\Ejemplos", nombreCarpeta);

        if (carpeta.exists())
            System.out.println("La carpeta " + carpeta.getName() + " ya existe");
        else {
            carpeta.mkdirs();
            System.out.println("La carpeta " + carpeta.getName() + " se ha creado");
            System.out.println("Ruta absoluta " + carpeta.getAbsolutePath());
            System.out.println("Ruta relativa " + carpeta.getPath());
            System.out.println("Carpeta padre " + carpeta.getParent());
        }
    }
}