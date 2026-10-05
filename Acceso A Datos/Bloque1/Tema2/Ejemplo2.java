import java.io.FileReader;
import java.io.LineNumberReader;

public class Ejemplo2 {
    public static void main(String[] args) {

        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\temp\\pruebas\\pruebas2.txt"));

            String line = lineNumberReader.readLine();
            while (line != null) {
                System.out.println("Contenido de la línea número: " + lineNumberReader.getLineNumber());
                System.out.println(line);
                line = lineNumberReader.readLine();
            }
            lineNumberReader.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
