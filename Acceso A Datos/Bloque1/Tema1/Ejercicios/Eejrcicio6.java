import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.util.Scanner;

public class Eejrcicio6 {
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);

    try {

        System.out.println("Que entrada quieres comprar: ");
        int posi = sc.nextInt();
        
        RandomAccessFile file = new RandomAccessFile("./cine.txt", "rw");
        file.seek(posi);

        int letra = file.read();
        System.out.println(posi + " " + letra);
    
        if (letra == 'L') {
           System.out.println("Esa butaca está libre, se puede reservar");
        } 
        
        else System.out.println("Esa butaca ya está ocupada");

    } catch (Exception e) {
        // TODO: handle exception
    }
  

    }
}
