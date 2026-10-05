import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio5 {
    public static void main(String[] args) {

        try {
            
        FileInputStream entrada = new FileInputStream("./images.jpg");
        FileOutputStream salida = new FileOutputStream("./copia.jpg");

        int data;
        int contador = 0;
        while ((data = entrada.read()) != -1) {
            salida.write(data);
            contador++;
        }

        System.out.println("Se han copiado " + contador + " bytes.");

        long final1 = System.currentTimeMillis();
        System.out.println(final1 + " ms");
        
        entrada.close();
        salida.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

        
    }
}
