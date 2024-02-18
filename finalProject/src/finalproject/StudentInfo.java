package finalproject;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;

public class StudentInfo extends regestration {

    private int id;
    private String name;
    private int age;
    private String username;
    private String password;
    

    public StudentInfo() {

    }

    public void insert(int id, String name, int age, String username, String password) throws ClassNotFoundException {
        this.id = id;
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;

        try {
            
            /*
            
            
            
     private final String user = "coursesManagment";
    private final String password = "root";
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem";
    
    public Connection connect()  throws SQLException
    {
         return DriverManager.getConnection(url, user, password);
    }
}

            */
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   String user = "coursesManagment";
     String pass = "root";
     String url = "jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem";
    Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem",user,pass);
          
    String query = "INSERT INTO student  (ID, name , age , User_name , Password ) VALUES(" + id + ",'" + name + "'," + age + ",'" + username + "','" + password + "')";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.execute();

            System.out.println("Done");

        } catch (SQLException ex) {

            System.out.println("Error");
            System.out.println(ex.getMessage());

        }

    }

    public void update(int id, String name, int age, String username, String password) throws ClassNotFoundException {
        this.id = id;
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;

        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   String user = "coursesManagment";
     String pass = "root";
     String url = "jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem";
    Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem",user,pass);

            String query = "UPDATE student SET  ID=" + id + ", name ='" + name + "', age =" + age + " ,User_name='" + username + "' ,Password ='" + password + "' WHERE ID=" + id + "";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.executeUpdate();
            System.out.println("Done");

        } catch (SQLException ex) {

            System.out.println("Error");
            System.out.println(ex.getMessage());

        }

    }
    
  public void delete(int id, String name, int age, String username, String password) throws ClassNotFoundException {
        this.id = id;
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;

        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   String user = "coursesManagment";
     String pass = "root";
     String url = "jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem";
    Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem",user,pass);
           String query = "DELETE FROM student WHERE  ID=" + id + "";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.execute();
            System.out.println("Done");

        } catch (SQLException ex) {

            System.out.println("Error");
            System.out.println(ex.getMessage());

        }

    }  
    
  

}




