package finalproject;
import java.sql.*;
import java.util.*;
     
public class regestration {
    private String Regester_Type;
    private int ID;
    private String Name;
    private int Age;
    private String UserName;
    private String Password;
    private String u_name;
    
    regestration () {
        
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }
    
    public void setName (String Name) {
        this.Name = Name;
    }
    public String getName () {
        return Name;
    }
    
    public void setAge (int Age) {
        this.Age = Age;
    }
    public int getAge() {
        return Age;
    }
    
    public void setUserName( String userName ) {
        this.UserName = userName;
    }
    public String getUserName(){
        return UserName;
    }
    
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public String getPassword() {
        return Password;
    }
    public void setType(String Regester_Type) {
        this.Regester_Type = Regester_Type;
    }
    
    
    static Connection c;
    static Statement ss;
    static String query;
    static ResultSet r;
    
    public void ADD() {
        sec c1 = new sec();
         if("student".equals(this.Regester_Type)) { 
             try {
                 c = c1.connect();
                 ss = c.createStatement();
                 query = "insert into student values ('"+getID()+"', '"+getName()+"', '"+getAge()+"','"+getUserName()+"', '"+getPassword()+"')";
                 ss.execute(query);
             }catch (SQLException ee){
                 System.out.println(ee.getMessage());
             }
             finally {
                 try {
                     c.close();
                     ss.close();
                 }
                 catch(SQLException ee) {
                     System.out.println(ee.getMessage());
                 }
             }
         } else if("instructor".equals(Regester_Type)) {
             try {
                 c = c1.connect();
                 ss = c.createStatement();
                 query = "insert into instructor values ('"+getID()+"', '"+getName()+"', '"+getAge()+"','"+getUserName()+"', '"+getPassword()+"')";
                 ss.execute(query);
             }catch (SQLException ee){
                 System.out.println(ee.getMessage());
             }
             finally {
                 try {
                     c.close();
                     ss.close();
                 }
                 catch(SQLException ee) {
                     System.out.println(ee.getMessage());
                 }
             }
         } else if("Admin".equals(Regester_Type)) {
             try {
                 c = c1.connect();
                 ss = c.createStatement();
                 query = "insert into Admin values ('"+getID()+"', '"+getName()+"', '"+getAge()+"','"+getUserName()+"', '"+getPassword()+"')";
                 ss.execute(query);
             }catch (SQLException ee){
                 System.out.println(ee.getMessage());
             }
             finally {
                 try {
                     c.close();
                     ss.close();
                 }
                 catch(SQLException ee) {
                     System.out.println(ee.getMessage());
                 }
             }
         }  
    }
    
    public void UPDATE( String Regester_Type, String coulmn_name, String Coulmn_value, String condition_name, String condition_value)  {
        sec c1 = new sec();
        if("student".equals(Regester_Type)) {
             try {
                 c = c1.connect();
                 ss = c.createStatement();
                 query = "update student set "+coulmn_name+"='"+Coulmn_value+"' where "+condition_name+" = '"+condition_value+"' ";
                 ss.execute(query);
             }catch (SQLException ee){
                 System.out.println(ee.getMessage());
             }
             finally {
                 try {
                     c.close();
                     ss.close();
                 }
                 catch(SQLException ee) {
                     System.out.println(ee.getMessage());
                 }
             }
         }else if("instructor".equals(Regester_Type)) {
             try {
                 c = c1.connect();
                 ss = c.createStatement();
                 query = "update instructor set "+coulmn_name+"='"+Coulmn_value+"' where "+condition_name+" = '"+condition_value+"' ";
                 ss.execute(query);
             }catch (SQLException ee){
                 System.out.println(ee.getMessage());
             }
             finally {
                 try {
                     c.close();
                     ss.close();
                 }
                 catch(SQLException ee) {
                     System.out.println(ee.getMessage());
                 }
             }
         }else if("Admin".equals(Regester_Type)){
             try {
                 c = c1.connect();
                 ss = c.createStatement();
                 query = "update Admin set "+coulmn_name+"='"+Coulmn_value+"' where "+condition_name+" = '"+condition_value+"' ";
                 ss.execute(query);
             }catch (SQLException ee){
                 System.out.println(ee.getMessage());
             }
             finally {
                 try {
                     c.close();
                     ss.close();
                 }
                 catch(SQLException ee) {
                     System.out.println(ee.getMessage());
                 }
             }
         }
    }
        
    public boolean check_login () {
        sec c1 = new sec();
        if("student".equals(this.Regester_Type)) { 
            try {
                c = c1.connect();
                ss = c.createStatement();
                query = "select * from student";
                r = ss.executeQuery(query);
                while(r.next()) {
                    if(getUserName().equals(r.getString("User_name")) && getPassword().equals(r.getString("Password"))) {
                        return true;
                    }
                }
                 }catch (SQLException ee){
                     System.out.println(ee.getMessage());
                 }
                 finally {
                     try {
                         c.close();
                         ss.close();
                     }
                     catch(SQLException ee) {
                         System.out.println(ee.getMessage());
                     }
                 }
        }else if("instructor".equals(this.Regester_Type)) { 
            try {
                c = c1.connect();
                ss = c.createStatement();
                query = "select * from instructor";
                r = ss.executeQuery(query);
                while(r.next()) {
                    if(getUserName().equals(r.getString("User_name")) && getPassword().equals(r.getString("Password"))) {
                        return true;
                    }
                }
                 }catch (SQLException ee){
                     System.out.println(ee.getMessage());
                 }
                 finally {
                     try {
                         c.close();
                         ss.close();
                     }
                     catch(SQLException ee) {
                         System.out.println(ee.getMessage());
                     }
                 }
        }else if("Admin".equals(this.Regester_Type)) { 
            try {
                c = c1.connect();
                ss = c.createStatement();
                query = "select * from Admin";
                r = ss.executeQuery(query);
                while(r.next()) {
                    if(getUserName().equals(r.getString("User_name")) && getPassword().equals(r.getString("Password"))) {
                        return true;
                    }
                }
                 }catch (SQLException ee){
                     System.out.println(ee.getMessage());
                 }
                 finally {
                     try {
                         c.close();
                         ss.close();
                     }
                     catch(SQLException ee) {
                         System.out.println(ee.getMessage());
                     }
                 }
        }
        return false;
        
    }
////    public String checkUserName (String User_Chicking) {
////        try {
////                
////                     c = c1.connect();
////                     ss = c.createStatement();
////                     query = "select * from student";
////                     query = "select * from student";
////                     r = ss.executeQuery(query);
////                     r.next();
////                     u_name = r.getString("User_name");
////                     if(User_Chicking.equals(u_name)) {
////                         System.out.println("Registration Seuccessfully");
////                     }else {
////                         checkUserName(User_Chicking);
////                     }
////                 
////             }catch (SQLException ee){
////                 System.out.println(ee.getMessage());
////             }
////             finally {
////                 try {
////                     c.close();
////                     ss.close();
////                 }
////                 catch(SQLException ee) {
////                     System.out.println(ee.getMessage());
////                 }
////             }
////        return u_name;
////    }
}

