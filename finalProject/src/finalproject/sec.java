package finalproject;
import java.sql.*;
public class sec {
    private final String user = "coursesManagment";
    private final String password = "root";
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem";
    
    public Connection connect()  throws SQLException
    {
         return DriverManager.getConnection(url, user, password);
    }
}
