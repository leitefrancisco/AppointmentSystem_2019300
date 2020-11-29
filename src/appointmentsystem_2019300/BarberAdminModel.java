/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem_2019300;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Francisco Leite
 */
class BarberAdminModel {
    
    User user;
    public BarberAdminModel(){
        this.user = User.getCurrentUser();
    }
    
    public boolean checkBarberhasLocation(){
        boolean hasLocation =false;
        try{
            Database db = new Database();
            String query = "SELECT COUNT(*) as c FROM t_location_barber WHERE barberID = "+ User.getCurrentUser().getUserID() + ";";
            ResultSet rs = db.executeQuery(query);
            if(rs.next())
            {
                hasLocation = rs.getInt("c")>0;
            }
            
            db.close();
        }
         catch (SQLException se) {
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
      return hasLocation; 
    }
    
}
