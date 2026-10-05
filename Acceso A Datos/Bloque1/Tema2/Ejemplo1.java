import java.io.FileReader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Ejemplo1 {
    public static void main(String[] args) {

        try {
            StreamTokenizer streamTokenizer = new StreamTokenizer(new FileReader("./datos.txt"));

            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println("Palabra: " + streamTokenizer.sval); // token de tipo palabra
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println("Numero " + streamTokenizer.nval); // token de tipo número
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println(); // fin de línea   
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
