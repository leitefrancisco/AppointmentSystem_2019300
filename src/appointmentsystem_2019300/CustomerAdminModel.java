package appointmentsystem_2019300;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerAdminModel {
    //return an array with all the appoints of the current curstomer (current user)
    public Appointment[] getCurrentAppointments() {
        ArrayList<Appointment> apps = new  ArrayList<>();
        
        try{
            Database db = new Database();
            String query = "SELECT appointmentID, appDayTime, Concat( b.first_name , ' ' , b.last_name) as barber, location, status, Concat(c.first_name,' ',c.last_name) as customer " 
                        + " FROM t_appointment a"
                        + " inner join t_user b"
                        + " on a.barberID = b.userID"
                        + " inner join t_location l"
                        + " on a.locationID = l.locationID"
                        + " inner join t_user c"
                        + " on a.customerID = c.userID"
                        + " where customerID = "+ User.getCurrentUser().getUserID() + " and status in (0, 1) and appDayTime >= now()";

            ResultSet rs = db.executeQuery(query);
            
            while(rs.next())
            {
                Appointment app = new Appointment(rs.getInt(1), rs.getTimestamp(2), rs.getString(4), rs.getString(3), rs.getInt(5), rs.getString(6));
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
    //changes the status of the appoint in the database to "canceled"
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
