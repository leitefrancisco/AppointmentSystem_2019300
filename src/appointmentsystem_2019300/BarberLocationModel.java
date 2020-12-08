/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem_2019300;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Francisco Leite
 */
class BarberLocationModel {

    public BarberLocationModel() {
    }

    BarberLocation[] getBarberLocations() {
          ArrayList<BarberLocation> list = new  ArrayList<>();
        
        try{
            Database db = new Database();
            String query = "SELECT barberID, lb.locationID, location, mon, tue, wed, thu, fri, sat, sun FROM t_location_barber lb"
                        + " inner join t_location l"
                        + " on lb.locationID = l.locationID" 
                        + " where barberID = " + User.getCurrentUser().getUserID();
            ResultSet rs = db.executeQuery(query);
            
            while(rs.next())
            {
                list.add(new BarberLocation(rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getString(3), 
                        rs.getBoolean(4),  
                        rs.getBoolean(5),
                        rs.getBoolean(6),
                        rs.getBoolean(7),
                        rs.getBoolean(8),
                        rs.getBoolean(9),
                        rs.getBoolean(10)));
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
        return list.toArray(new BarberLocation[list.size()]);
    }
    
}
