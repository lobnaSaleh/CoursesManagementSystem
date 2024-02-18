package finalproject;

import java.sql.*;

public class Instructor extends regestration{
//    static Connection c;
//    static Statement ss;
//    static String query;
    // start of add grades method
    public void AddGrades( int grade , int student_id,int course_id) throws SQLException {
       sec s1 = new sec();
        try {
            
            c = s1.connect();
            ss=c.createStatement();
            query="insert into Student_courses (grades) values ('"+grade+"') where student_id='"+student_id+"' and course_id='"+course_id+"'";
            ss.execute(query);
            System.out.println("Done");
        } 
        catch (SQLException ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        } 
        finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    // end of add grades method
    
    //start of  teach method
    public void teach( int instructor_id,int course_id)throws SQLException{
       sec s1 = new sec();
        try {
            
            c = s1.connect();
            ss=c.createStatement();
            query="insert into instructor_course values ('"+instructor_id+"','"+course_id+"')";
            ss.execute(query);
            System.out.println("Done");
        } 
        catch (SQLException ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        } 
        finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    // end of teach method
}