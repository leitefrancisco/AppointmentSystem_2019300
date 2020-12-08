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

    public boolean isValid() {
        if(worksMon == false && worksTue == false && worksWed == false && worksThu == false && worksFri == false && worksSat == false && worksSun == false || location.isEmpty()){
            return false;
        }
        else{
            return true;
        }
        
        
    }

    void saveLocation() {
        if(locationID == 0)
        {
            insertLocation();
        }else{
            updateLocation();
        }
        
    }

    private void updateLocation() {
        int antigaID = locationID;
        
        // carregar a location da bd. select location from location where location = locationId
        // ver se o nome da location que vem da bd é diferente do que vem do model
        //           o do model é o que vem da UI
        // se forem diferentes entao é uma localizacao diferente
        //       --> ver se é uma nova ( mesmo processo do Insert)
        //       --> ver se é existente
        // se for existente o locationID vai o que vem da existente
        // se for nova, tem que se inserir uma nove t_location
        //      usa createLocation que insere na t_location e devolve o ID inserido
        
        
        // agora temos o ID da location nova ou editada e fazem o update de locationId na table location_barber
        
        // /!\ se houver alteracao da location, guardar a locationID antiga numa variavel auxiliar para user no where to update
        
        
        
        /*
        Sandyford => Tabuate  // 1 => ?
        
        Tabuate nao existe na bd
        antigaID = locationID;  // antiga => 1
        locationID = createLocation(); // 12
        
        
        // main target
        update t_location_barber
        set locationId = locationID,  // 12
        mon = this.worksMon,
        tue=this.worksTue,
        ...
        where barberId = user.getUSerID() and locationID=antigaID  //1
        
        
        
        
        */
    }
    
    
    
    
    
    
    
    
    
}
