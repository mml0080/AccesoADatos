import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    private static final String URL      = "jdbc:mysql://localhost:3306/tienda";
    private static final String USUARIO  = "root";
    private static final String PASSWORD = "Med@c";

    public static void main(String[] args) {

        String sql = "SELECT id_cliente, nombre, ciudad FROM cliente";

        try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id_cliente") + " - "
                        + rs.getString("nombre") + " (" + rs.getString("ciudad") + ")");
            }

        } catch (SQLException e) {
            System.out.println("Error SQL " + e.getErrorCode() + ": " + e.getMessage());
        }
    }
}