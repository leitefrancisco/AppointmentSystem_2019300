
package appointmentsystem_2019300;

import java.sql.SQLException;


public class CustomerComplaintModel {
    User user;
    //writes a new complaint in the database with the ids of the customer and the barber.
    public boolean writeComplaint(int barberID, int customerID, String complaint, String customerName, String userEmail){
        
        try {
            Database db = new Database();
            
            String query = "INSERT INTO t_complaint (barberID, customerID, complaintText, customerFullName, customerEmail) "
                    +"VALUES ("+barberID + "," + customerID + ",'"+ complaint +"','"+ customerName +"', '" + userEmail+ "')";
            
            
            db.execute(query);
            
            db.close();
            return true;
            
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
        return false;
        
    } 
}
