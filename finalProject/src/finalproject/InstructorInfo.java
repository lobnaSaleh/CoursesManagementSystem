package finalproject;
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class InstructorInfo extends regestration{
    
   

    private int instructorid;
    private String instructorname;
    private int instructorage;
    private String instructorusername;
    private String instructorpassword;
    

    public InstructorInfo() {

    }

    public void insertInstructor(int instructorid, String instructorname, int instructorage, String instructorusername, String instructorpassword) throws ClassNotFoundException {
        this.instructorid = instructorid;
        this.instructorname = instructorname;
        this.instructorage = instructorage;
        this.instructorusername = instructorusername;
        this.instructorpassword = instructorpassword;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   String user = "coursesManagment";
     String pass = "root";
     String url = "jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem";
    Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem",user,pass);
            
    
    String query = "INSERT INTO instructor  (ID, name , age , User_name , Password ) VALUES(" + instructorid + ",'" + instructorname + "'," + instructorage + ",'" + instructorusername + "','" + instructorpassword + "')";
              PreparedStatement pst = conn.prepareStatement(query);
            pst.execute();

            System.out.println("Done");

        } catch (SQLException ex) {

            System.out.println("Error");
            System.out.println(ex.getMessage());

        }

    }

    public void update(int instructorid, String instructorname, int instructorage, String instructorusername, String instructorpassword) throws ClassNotFoundException {
       this.instructorid = instructorid;
        this.instructorname = instructorname;
        this.instructorage = instructorage;
        this.instructorusername = instructorusername;
        this.instructorpassword = instructorpassword;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   String user = "coursesManagment";
     String pass = "root";
     String url = "jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem";
    Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem",user,pass);
            String query = "UPDATE instructor SET  ID=" + instructorid + ", name ='" + instructorname + "', age =" + instructorage + " ,User_name='" + instructorusername + "' ,Password ='" + instructorpassword+ "' WHERE ID=" + instructorid + "";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.executeUpdate();
            System.out.println("Done");

        } catch (SQLException ex) {

            System.out.println("Error");
            System.out.println(ex.getMessage());

        }

    }
    
  public void delete(int instructorid, String instructorname, int instructorage, String instructorusername, String instructorpassword) throws ClassNotFoundException {
        this.instructorid = instructorid;
        this.instructorname = instructorname;
        this.instructorage = instructorage;
        this.instructorusername = instructorusername;
        this.instructorpassword = instructorpassword;


        try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   String user = "coursesManagment";
     String pass = "root";
     String url = "jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem";
    Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=coursesManagmentSystem",user,pass);
           String query = "DELETE FROM instructor WHERE  ID=" + instructorid+ "";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.execute();
            System.out.println("Done");

        } catch (SQLException ex) {

            System.out.println("Error");
            System.out.println(ex.getMessage());

        }

    }  
    
  

}


 
    
    
    
    
    
    
    
    
    

