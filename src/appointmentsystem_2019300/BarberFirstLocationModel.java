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
public class BarberFirstLocationModel {
    String location;
    boolean worksMon;
    boolean worksTue;
    boolean worksWed;
    boolean worksThu;
    boolean worksFri;
    boolean worksSat;
    boolean worksSun;
    public BarberFirstLocationModel(String location, boolean worksMon,
            boolean worksTue,
            boolean worksWed,
            boolean worksThu,
            boolean worksFri,
            boolean worksSat,
            boolean worksSun){
        this.location = location;
        this.worksMon = worksMon;
        this.worksTue = worksTue;
        this.worksWed = worksWed;
        this.worksThu = worksThu;
        this.worksFri = worksFri;
        this.worksSat = worksSat;
        this.worksSun = worksSun;
        
    }
    
    
    private int getLocationId() throws SQLException{
        Database db = new Database();
        String query = "SELECT locationID from t_location where location='" + location + "';";
        int locationId = 0;
        ResultSet rs = db.executeQuery(query);
        if(rs.next()){
            locationId = rs.getInt(1);
        }
        db.close();
        return locationId;
    }
    private int createLocation() throws SQLException{
        Database db = new Database();
        String query = "INSERT INTO t_location (location) VALUES ('" +  location    +"');" ;
        db.execute(query); // create
        //reade created 
        ResultSet rs = db.executeQuery("select locationID from t_location where location='" + location + "';");
        int locationId = 0;
        if(rs.next())
           locationId = rs.getInt(1);
        db.close();
        return locationId;
    }
    
    public boolean insertLocation(){
        
        // Sandyford
        try{
            User u = User.getCurrentUser();  
            int locationId = getLocationId(); // para o caso da localizacao ja existir
            if(locationId == 0){
                locationId = createLocation();
            }
             
            // relacao entre localizao e barbeiro
            Database db = new Database();
            String query = "INSERT into t_location_barber(barberId, locationId, mon, tue, wed, thu, fri, sat, sun) "
                    + "values(" + u.getUserID() + "," + locationId + ", " + worksMon 
                    + ", " + worksTue + ", " + worksWed + ", " + worksThu + ", " + worksFri
                     + ", " + worksSat + ", " + worksSun+");";
            db.execute(query);
            db.close();
            return true;
        }
        catch (SQLException se) {
            System.out.println("SQL Exception:");
            
            
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
        
        
    }
//
//    public boolean isValid() {
//        
//        if(worksMon == false)
//        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
    
    
    
    
    
    
    
    
}
