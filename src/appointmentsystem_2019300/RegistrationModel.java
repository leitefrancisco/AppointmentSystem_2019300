/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package appointmentsystem_2019300;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




/**
 *
 * @author Francisco Leite
 */
public class RegistrationModel {
    
    
    User user;
    
    public RegistrationModel(String firstName, String lastName, String email, String password, String passConf, char userType){
        this.user = new User(firstName, lastName, email, password, passConf, userType);
    }
    
    public boolean writeUser(){
        
        if(this.validateRegister() == false){
            return false;
        }
        
        try {
            Database db = new Database();
            
            String query = "INSERT INTO t_user (first_name, last_name, email, password, user_type) VALUES ('" + user.getFirstName() + "','" +  user.getLastName() + "','"+  user.getEmail() +"','" + user.getPassword() +"','" + user.getUserType() + "')";
            
            //Execute the query
            db.execute(query);
            
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
            return false;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public boolean validateRegister (){
        if (!user.getPassword().equals(user.getPasswordConf()) || user.getPassword().isEmpty()){
            return false;
        }
        else{
            return true;
        }
        
    }
    
    boolean emailExists(String email) {
        try {
            Database db = new Database();
            
            String query = "SELECT COUNT(email) from t_user WHERE email = '"+email+"'";
            
            ResultSet rs = db.executeQuery(query);
            if(rs.next()){
                if (rs.getInt(1)>0){
                    return true;
                }
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
            return false;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return false;
        
    }
    
    
    
}
