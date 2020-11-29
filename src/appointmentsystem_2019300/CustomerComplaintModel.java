
package appointmentsystem_2019300;

import java.sql.SQLException;


public class CustomerComplaintModel {
    User user;
    
    public void writeComplaint(){
        
        try {
            Database db = new Database();
            
            String query = "INSERT INTO t_complain VALUES (              )";
            
            
            db.execute(query);
            
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
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
