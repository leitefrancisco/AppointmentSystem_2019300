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
public class CustomerAdminModel {
    
    public void showAppointments(){
        
        
        
    }

    public Appointment[] getCurrentAppointments() {
        ArrayList<Appointment> apps = new  ArrayList<>();
        
        try{
            Database db = new Database();
            String query = "SELECT appointmentID, appDayTime, Concat( first_name , ' ' , last_name) as barber, location, status " 
                        + " FROM t_appointment a"
                        + " inner join t_user b"
                        + " on a.barberID = b.userID"
                        + " inner join t_location l"
                        + " on a.locationID = l.locationID"
                        + " where customerID="+ User.getCurrentUser().getUserID() + " and status in (0, 1) ";//and appDayTime >= now()"

            ResultSet rs = db.executeQuery(query);
            
            while(rs.next())
            {
                Appointment app = new Appointment(rs.getInt(1), rs.getDate(2), rs.getString(4), rs.getString(3), rs.getInt(5));
                apps.add(app);
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
        return apps.toArray(new Appointment[apps.size()]);
    }

    boolean cancelApp(int appId) {
        String query = "update t_appointment " 
            + " set status = 2"
            + " where appointmentID = " + appId;
        
        try{
            Database db = new Database();
        
            db.execute(query);
            db.close();
            return true;
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
        return false;
    }
    
    
    
}
