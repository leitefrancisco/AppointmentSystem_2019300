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
public class BarberLocationEditModel {
    int locationID;
    String location;
    boolean worksMon;
    boolean worksTue;
    boolean worksWed;
    boolean worksThu;
    boolean worksFri;
    boolean worksSat;
    boolean worksSun;
    
    public BarberLocationEditModel(){}
    
    public BarberLocationEditModel(
            String location,
            boolean worksMon,
            boolean worksTue,
            boolean worksWed,
            boolean worksThu,
            boolean worksFri,
            boolean worksSat,
            boolean worksSun,
            int locationID
    ){
        this.location = location.trim();
        this.worksMon = worksMon;
        this.worksTue = worksTue;
        this.worksWed = worksWed;
        this.worksThu = worksThu;
        this.worksFri = worksFri;
        this.worksSat = worksSat;
        this.worksSun = worksSun;
        this.locationID = locationID;
    }
    
    public int getLocationID() {
        return locationID;
    }
    
    public String getLocation() {
        return location;
    }
    
    public boolean isWorksMon() {
        return worksMon;
    }
    
    public boolean isWorksTue() {
        return worksTue;
    }
    
    public boolean isWorksWed() {
        return worksWed;
    }
    
    public boolean isWorksThu() {
        return worksThu;
    }
    
    public boolean isWorksFri() {
        return worksFri;
    }
    
    public boolean isWorksSat() {
        return worksSat;
    }
    
    public boolean isWorksSun() {
        return worksSun;
    }
    
    //gets the location to be eddited
    public void loadFromDb(int locationID){
        try{
            Database db = new Database();
            String query = "SELECT barberID, l.locationID, location, mon, tue, wed, thu, fri, sat, sun"
                    + " FROM t_location_barber lb"
                    + " inner join t_location l"
                    + " on lb.locationID = l.locationID"
                    + " where barberID = " + User.getCurrentUser().getUserID() + " and l.locationID = " + locationID;
            
            
            ResultSet rs = db.executeQuery(query);
            
            if(rs.next())
            {
                this.locationID = rs.getInt(2);
                this.location = rs.getString(3);
                this.worksMon = rs.getBoolean(4);
                this.worksTue = rs.getBoolean(5);
                this.worksWed = rs.getBoolean(6);
                this.worksThu = rs.getBoolean(7);
                this.worksFri = rs.getBoolean(8);
                this.worksSat = rs.getBoolean(9);
                this.worksSun = rs.getBoolean(10);
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
        
    }
    //the id by default is zero, if the location typed is already in the data base  it will get the id of the location
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
    //if the location is new , create a new location in the database
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
        try{
            User u = User.getCurrentUser();
            int locationId = getLocationId(); //in case of the location already exists
            if(locationId == 0){
                locationId = createLocation();
            }
            
            // relation between the barber and location
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
    //at least one day needs to be checked  and location can't be empty
    public boolean isValid() {
        if(worksMon == false && worksTue == false && worksWed == false && worksThu == false && worksFri == false && worksSat == false && worksSun == false || location.isEmpty()){
            return false;
        }
        else{
            return true;
        }
        
        
    }
    //saves the location
    void saveLocation() throws Exception {
        //case new location
        if(locationID == 0)
        {
            insertLocation();
        }else{
            try {
                //case location already exists
                updateLocation();
            }
            catch (SQLException se) {
                System.out.println("SQL Exception:");
                
                while (se != null) {
                    System.out.println("State  : " + se.getSQLState());
                    System.out.println("Message: " + se.getMessage());
                    System.out.println("Error  : " + se.getErrorCode());
                    
                    se = se.getNextException();
                }
                
            }  
        }
        
        
    }
    
    private void updateLocation() throws SQLException, Exception {
        int oldID = locationID;
        
        BarberLocationEditModel modelInDb = new BarberLocationEditModel();
        
        modelInDb.loadFromDb(oldID);
        boolean isSameLocation = modelInDb.getLocation().equals(this.getLocation());
        
        
        int newLocationId = 0;
        
        if(!isSameLocation){
            
            newLocationId = this.getLocationId(); 
            if(newLocationId == 0){
                newLocationId = createLocation();
            }
            
            
        }else{
            newLocationId = this.locationID;
        }
        if(this.locationAlreadyTaken(newLocationId)){
           throw new Exception("Location taken");
        }else{
            
            //relation barber_location
            Database db = new Database();
            String updateQuery = "UPDATE t_location_barber "
                    + " SET locationID = " + newLocationId + ","
                    + " mon = "+ worksMon + ","
                    + " tue = "+ worksTue + ","
                    + " wed = "+ worksWed + ","
                    + " thu = "+ worksThu + ","
                    + " fri = "+ worksFri + ","
                    + " sat = "+ worksSat + ","
                    + " sun = "+ worksSun
                    + " WHERE barberID = " + User.getCurrentUser().getUserID()
                    + " and locationID = " + oldID;
            db.execute(updateQuery);
            db.close();
            
        }
    }
    //if the barber already have the location it will give an error message
    private boolean locationAlreadyTaken(int newLocationId) throws SQLException {
        Database db = new Database();
        String query = "SELECT count(*) "
                + " from t_location_barber "
                + " where locationId=" + newLocationId + ""
                + " and barberId=" + User.getCurrentUser().getUserID();
        boolean isTaken = false;
        ResultSet rs = db.executeQuery(query);
        if(rs.next()){
            isTaken = rs.getInt(1)>0;
        }
        db.close();
        return isTaken;
    }
    
    
    
    
    
    
    
    
    
}
