package appointmentsystem_2019300;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Model {
    
    public boolean login(User user){
        
        boolean validLogin = false;
        
        try {
            String dbServer = "jdbc:mysql://apontejaj.com:3306/Francisco_2019300?useSSL=false";
            String dbUser = "Francisco_2019300";
            String dpPassword = "2019300";
            String query = "select * FROM user WHERE username = '" +user.getUn()+ "' AND password = '"+user.getPw()+"'";

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dpPassword);
            
            // Get a statement from the connection
            Statement stmt = conn.createStatement();
            //Execute the query
            ResultSet rs = stmt.executeQuery(query);
            
            // Loop through the result set
            if (rs.next()) {
                validLogin = true;
                
            }
            
            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
            
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
