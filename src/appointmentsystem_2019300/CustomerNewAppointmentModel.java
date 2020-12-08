/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package appointmentsystem_2019300;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Francisco Leite
 */
public class CustomerNewAppointmentModel {
    
    public User[] getBarbers() {
        ArrayList<User> barbers = new  ArrayList<>();
        
        try{
            Database db = new Database();
            String query = "SELECT * FROM t_user WHERE user_type = 'b';";
            ResultSet rs = db.executeQuery(query);
            
            while(rs.next())
            {
                barbers.add(new User(rs.getInt("userID"), rs.getString("first_name"), rs.getString("last_name")));
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
        return barbers.toArray(new User[barbers.size()]);
    }
    

    ComboBoxItem[] getLocations(int barberId) {
        ArrayList<ComboBoxItem> locations = new  ArrayList<>();
        
        try{
            Database db = new Database();
            String query = "select l.locationID , location from t_location l " +
                    "inner join t_location_barber lb on l.locationID = lb.locationID " +
                    "where lb.barberID = " + barberId;
            ResultSet rs = db.executeQuery(query);
            
            while(rs.next())
            {
                locations.add(new ComboBoxItem(rs.getInt(1), rs.getString(2)));
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
        return locations.toArray(new ComboBoxItem[locations.size()]);
        
    }
    
    public String[] getPossibleSlots(){
        ArrayList<String> slots = new ArrayList<>();
        
        for(int i=8; i<19;  i++){
            if(i<10){
                slots.add("0"+i+":00");
                slots.add("0"+i+":30");
            }else{
                slots.add(i+":00");
                slots.add(i+":30");
            }
        }
        
        return slots.toArray(new String[slots.size()]);
    }
    
    String[] getTakenSlots(Date date, int barberId, int locationId){
        ArrayList<String> slots = new ArrayList<>();
        
         try{
            Database db = new Database();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            String sqlTakenSlots = "select DATE_FORMAT(appDayTime, '%H:%i') as slot from t_appointment " +
                                    "where barberId="+barberId+" and locationId=" + locationId + " " +
                                 " and DATE_FORMAT(appDayTime, '%Y-%m-%d') = '" + format.format(date) + "'";
            
             ResultSet rs = db.executeQuery(sqlTakenSlots);
            
            while(rs.next())
            {
                slots.add(rs.getString("slot"));
            }
            // ISO 
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
         return slots.toArray(new String[slots.size()]);
    }
    
    public String[] getFreeSlots(Date date, int barberId, int locationId) {
        ArrayList<String> freeSlots = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // Sunday 1…Saturday 7
        String[] weekDays ={"sun","mon","tue","wed","thu","fri","sat"};
        String selectedWeekDay = weekDays[day - 1];
        try{
            Database db = new Database();
            
            /*
            
            select mon
            from t_location_barber lb
            where barberId = 3 and locationId = 5
            */
            String sqlBarberInLocationInDay = ""
                    + "SELECT count(*)  from t_location_barber lb "
                    + "where barberId = "+ barberId + " "
                    + "and locationId = " + locationId  + " "
                    + "and " + selectedWeekDay + "=1";
            ResultSet rs = db.executeQuery(sqlBarberInLocationInDay);
            boolean isInLocation = false;
            if(rs.next())
            {
                // so vai estar ser for 1
                isInLocation = rs.getInt(1) > 0;
            }
            if(!isInLocation){
                freeSlots.add("Not in location for that day");
            }
            
            if(isInLocation){
                String[] possibleSlots = getPossibleSlots();
                String[] takenSlots = getTakenSlots(date, barberId, locationId);
               
                for(int poss = 0; poss<possibleSlots.length; poss++){
                    boolean found = false;
                    for(int tak = 0; tak<takenSlots.length; tak ++){
                        if(possibleSlots[poss].equals(takenSlots[tak])){
                            found = true;
                        }
                    }
                    if(found == false){
                        freeSlots.add(possibleSlots[poss]);
                    }
                }
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
        return freeSlots.toArray(new String[freeSlots.size()]);
    }

    public boolean writeAppointment(String date, int barberId, int customerID, int locationID) {
        try{
            Database db = new Database();
            
            String query = "insert into t_appointment "
                    + "(appdayTime, barberID, customerID, locationID) "
                    + "VALUES('"+ date + "'," 
                    + barberId +" ,"
                    +customerID+" ,"
                    + locationID +")"; 
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
            
        } catch (Exception e) {
            System.out.println(e);
        }
 
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
