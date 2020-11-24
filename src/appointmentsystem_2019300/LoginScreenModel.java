package appointmentsystem_2019300;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginScreenModel {
    String email;
    String password;
    
    public LoginScreenModel(String email, String password){
        this.email = email; 
        this.password = password;
    }
    
    public boolean login00(){
        
        boolean validLogin = false;
        
        try {
            Database db = new Database();
           
            String query = "select * FROM t_user WHERE email = '" + email + "' AND password = '"+ password +"';";
            ResultSet rs = db.executeQuery(query);
            // Loop through the result set
            if (rs.next()) {
                validLogin = true; 
            }
            
            
           db.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");
            
            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                
                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return validLogin;
    }
    
     public User login(){
        User user  = null;
      
        
        try {
            Database db = new Database();
           
            String query = "select * FROM t_user WHERE email = '" + email + "' AND password = '"+ password +"';";
            ResultSet rs = db.executeQuery(query);
            
            if (rs.next()) {
                user = new User (rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("user_type").charAt(0),
                        rs.getInt("userID"));
                        
            }
            
            
           db.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");
            
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                
                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return user;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
