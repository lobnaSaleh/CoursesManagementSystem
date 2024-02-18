package finalproject;

import java.sql.*;
import java.util.ArrayList;

public class Course {
    private int id;
    private String name;
    private int price;
    private String startDate;
    private String endDate;
    private String branch;
    private int hours;
    private int halls;
    static Connection c;
    static Statement ss;
    static String query;
    
    public Course()
    {
        
    }
    
    // Start of insert method
    public void insertValues( int id , String name ,int price, String startDate, String endDate , String branch, int hours, int halls) throws SQLException{
        this.id=id; 
        this.name=name;
        this.price=price;
        this.startDate=startDate;
        this.endDate=endDate;
        this.branch=branch;
        this.hours=hours;
        this.halls=halls;
        sec s1 = new sec();
        try {
            c = s1.connect();
            ss=c.createStatement();
            query="insert into courses values ('"+id+"','"+name+"','"+price+"','"+startDate+"','"+endDate+"','"+branch+"','"+hours+"','"+halls+"')";
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
    // end of insert method
    
    // start of clear method
    public void clear()throws SQLException{
         sec s1 = new sec();
        try {
            c = s1.connect();
            ss=c.createStatement();
            query="""
                  delete from instructor_course
                  delete from Student_courses
                  delete from courses""";
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
    //end of clear method
    
    //start of Delete method
    public void delete(int ID)throws SQLException{
              sec s1 = new sec();
        try {
            c = s1.connect();
            ss=c.createStatement();
            query="Delete from instructor_course where course_id = '"+ID+"'" + "Delete from Student_courses where course_id = '"+ID+"'"+"Delete from courses where ID ='"+ID+"'";                         
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
    // end of delete method
    
    // start of show Student method
    public ArrayList <Data> showStudents(int course_id)throws SQLException{
        
        sec s1 = new sec();
        ArrayList<Data> list = new ArrayList<Data>();
        ResultSet r;
        try {
            c = s1.connect();
            ss=c.createStatement();
            query="select name from student inner join Student_courses on student.ID= student_id where course_id='"+course_id+"'";
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
    // end of show Student method
    
    // start of show instructor method
    public ArrayList <Data> showInstructor(int course_id)throws SQLException{
        sec s1 = new sec();
        ArrayList<Data> list = new ArrayList<Data>();
        ResultSet r;
        try {
            c = s1.connect();
            ss=c.createStatement();
            query="select name from instructor inner join instructor_course on instructor.ID= instructor_id where course_id='"+course_id+"'";
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
    // end of show instructor method
}
