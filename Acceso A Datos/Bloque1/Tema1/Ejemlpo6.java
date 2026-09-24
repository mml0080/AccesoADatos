import java.io.RandomAccessFile;

public class Ejemlpo6 {
    public static void main(String[] args) {
        
        try {
            
            RandomAccessFile file = new RandomAccessFile("./texto.txt", "rw");
            file.seek(5);
            long filePointer = file.getFilePointer();
             System.out.println("Puntero ANTES de leer: " + file.getFilePointer()); // te dirá 5
            int unByte = file.read();
            System.out.println("Puntero DESPUES de leer: " + file.getFilePointer()); // te dirá 6
            System.out.println((char) unByte);
            file.write('X'); //Escribirá la letra F
            System.out.println("Puntero DESPUES de escribir: " + file.getFilePointer()); // te dirá 7
            file.close();
        
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error");
        }
    }
}
