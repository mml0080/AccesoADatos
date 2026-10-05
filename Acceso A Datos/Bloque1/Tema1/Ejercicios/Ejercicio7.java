import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("¿Desde qué asiento quieres consultar?: ");
            int posi = sc.nextInt();

            System.out.print("¿Cuántos asientos quieres consultar?: ");
            int cantidad = sc.nextInt();

            RandomAccessFile file = new RandomAccessFile("./asientos.txt", "r");

            file.seek(posi - 1);

            byte[] asientos = new byte[cantidad];

            int leidos = file.read(asientos, 0, cantidad);

            if (leidos == -1) {

                System.out.println("Error: no se han podido leer los asientos.");

            } else {

                System.out.println("\n--- ASIENTOS ---");

                for (int i = 0; i < leidos; i++) {

                    char estado = (char) asientos[i];

                    System.out.println((posi + i) + " " + estado);

                }
            }

            file.close();

        } catch (Exception e) {

            System.out.println("Error de lectura: " + e.getMessage());
        }

        sc.close();

    }
}
