import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("----- FORMULARIO DE MATRICULACIÓN -----");
            System.out.println("1. Guardar");
            System.out.println("2. Imprimir");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {

                // Pedimos todos los datos
                System.out.print("Nombre y Apellidos: ");
                String nombre = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Fecha de Nacimiento: ");
                String fecha = sc.nextLine();

                System.out.print("Género (Masculino / Femenino): ");
                String genero = sc.nextLine();

                System.out.print("Titulación de Acceso (FP Grado Medio / FP Grado Superior / Bachillerato): ");
                String titulacion = sc.nextLine();

                System.out.print("Observaciones: ");
                String observaciones = sc.nextLine();

                // Juntamos todos los datos en un String
                String formulario =
                        "----- Formulario de Matriculación -----\n" +
                        "Nombre y Apellidos: " + nombre + "\n" +
                        "Email: " + email + "\n" +
                        "Fecha de Nacimiento: " + fecha + "\n" +
                        "Género: " + genero + "\n" +
                        "Titulación de Acceso: " + titulacion + "\n" +
                        "Observaciones: " + observaciones + "\n" +
                        "----------------------------------------\n";

                // Escribimos el String en el fichero
                FileWriter escritor = new FileWriter("matricula.txt");

                escritor.write(formulario);

                escritor.close();

                System.out.println("Los datos se han guardado correctamente.");

            } else if (opcion == 2) {

                // Abrimos el fichero para leerlo
                FileReader lector = new FileReader("matricula.txt");

                int caracter;

                System.out.println("\n----- DATOS DE MATRÍCULA -----");

                // Leemos carácter a carácter
                while ((caracter = lector.read()) != -1) {

                    System.out.print((char) caracter);
                }

                lector.close();

            } else {

                System.out.println("Opción no válida.");

            }

        } catch (Exception e) {

            System.out.println("Ha ocurrido un error: " + e.getMessage());

        }

        sc.close();

    }
}
