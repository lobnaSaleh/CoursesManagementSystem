package finalproject;

import java.sql.*;
import java.util.ArrayList;

public class Student extends regestration {
//    static Connection c;
//    static Statement ss;
//    static String query;
//    
    public Student(){
        
    }
    
    // start of see courses method
     public ArrayList <Data> seeCourses(int student_id)throws SQLException{
        
        sec s1 = new sec();
        ArrayList<Data> list = new ArrayList<>();
        ResultSet r;
        try {
            c = s1.connect();
            ss=c.createStatement();
            query="select name from courses inner join Student_courses on courses.ID=course_id where student_id='"+student_id+"'";
            r=ss.executeQuery(query);
            Data d;
            while(r.next()){
                d=new Data(r.getString("name"));
                list.add(d);
            }
            System.out.println("Done");
        }catch (SQLException ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return list;
    }
    //end of see courses method
     
    // start of see grades method
     public ArrayList <Grade> showGrades(int student_id)throws SQLException{
                 
        sec s1 = new sec();
        ArrayList<Grade> list = new ArrayList<>();
        ResultSet r;
        try {
            c = s1.connect();
            ss=c.createStatement();
            query="select grades from Student_courses where student_id='"+student_id+"'";
            r=ss.executeQuery(query);
            Grade d;
            while(r.next()){
                d=new Grade(r.getInt("grades"));
                list.add(d);
            }
            System.out.println("Done");
        }catch (SQLException ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return list;
     }
    //end of see grades method
     
     //start of enroll method
     public void enroll(int student_id, int course_id)throws SQLException{
           sec s1 = new sec();
        try {
            c = s1.connect();
            ss=c.createStatement();
            query="insert into Student_courses (student_id , course_id) values ('"+student_id+"','"+course_id+"')";
            ss.execute(query);
            System.out.println("Done");
        }catch (SQLException ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }finally {
            try {
                c.close();
                ss.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
         
     }
     //end of enroll method
}
