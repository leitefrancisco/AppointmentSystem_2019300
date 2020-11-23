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
    
    public boolean login(){
        
        boolean validLogin = false;
        
        try {
            Database db = new Database();
           
            String query = "select * FROM t_user WHERE email = '" + email + "' AND password = '"+ password +"'";
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
    
    
    
    
    
    
    
    
    
    
    
}
