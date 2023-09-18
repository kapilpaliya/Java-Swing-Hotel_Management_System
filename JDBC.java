
// Add Package And Classes.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBC {
    // Variable Declaration.
    private static final String URL = "jdbc:mysql://localhost:3306/hotel";
    private static final String NAME = "root";
    private static final String PASSWORD = "kapil";

    // Create Static Method To Provide MySQL Connection.
    public static Connection setConnection() throws SQLException{
        return DriverManager.getConnection(URL,NAME,PASSWORD);
    }
}
