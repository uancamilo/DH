import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;

        try {

            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS ANIMALES ; " +
                    "CREATE TABLE ANIMALES (ID INT PRIMARY KEY, " +
                    "NOMBRE VARCHAR(100) NOT NULL, " +
                    "TIPO VARCHAR(100) NOT NULL)");
            statement.execute("INSERT INTO ANIMALES VALUES (1,'IGUANA','iguana'), (2,'PERRO','perro'), (3,'CABALLO','caballo'), (4,'JIRAFA','jirafa'), (5,'ELEFANTE','elefante')");

            ResultSet rs = statement.executeQuery("SELECT * FROM ANIMALES");

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString(2) + "Tipo " + rs.getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static Connection getConnection() throws Exception{
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:~/c4clase11",
                    "sa", "sa");
        }
}