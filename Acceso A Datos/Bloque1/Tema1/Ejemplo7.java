import java.io.RandomAccessFile;

public class Ejemplo7 {
    public static void main(String[] args) {

        try {
            
            RandomAccessFile file = new RandomAccessFile("./texto.txt", "r");
            file.seek(5); // saltamos directamente a la posición 5, sin leer lo anterior

            byte[] arrayBytes = new byte[5]; //declaras array de bytes de 5 posiciones
            file.read(arrayBytes, 0, 5);  // leemos 5 bytes de golpe, desde ahí


            System.out.println("Bytes leídos: " + arrayBytes.length);
            System.out.println("Puntero DESPUÉS del read: " + file.getFilePointer());

            System.out.println("\nArray DESPUÉS de leer (ya relleno con datos del fichero):");
            for (int i = 0; i < arrayBytes.length; i++) {

                System.out.println("  arrayBytes[" + i + "] = " + arrayBytes[i] + " -> '" + (char) arrayBytes[i] + "'");

            }
            
            file.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
