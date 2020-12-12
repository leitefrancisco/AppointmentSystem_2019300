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
import java.util.Date;

/**
 *
 * @author Francisco Leite
 */
class BarberAppModel {
    
    //if the barber has at least one appointment it will return an array to be shown in the view
    public String [][] getApps(int barberID){
        int amt = getAmtOfApps(barberID);
        if(amt >0){
            
            String [][] complaints = new String [amt][5];
            
            try{
                Database db = new Database();
                String query = "select concat(uc.first_name, ' ', uc.last_name) as customer_name,"
                        + " uc.email, l.location, a.appDayTime, status "
                        + "from t_appointment a "
                        + "inner join t_user uc "
                        + "on a.customerID = uc.userID "
                        + "inner join t_location l "
                        + "on a.locationID = l.locationID "
                        + "where a.barberID = "+barberID;
                ResultSet rs = db.executeQuery(query);
                
                int row = 0;
                while (rs.next()) {
                    
                    complaints [row][0]= rs.getString(1);
                    complaints [row][1]= rs.getString(2);
                    complaints [row][2]= rs.getString(3);
                    
                    Date appDateTime = rs.getTimestamp(4);
                    DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    complaints [row][3]= format.format(appDateTime);
                    
                    int status = rs.getInt(5);
                    switch(status){
                        case 0:
                            complaints [row][4]= "PENDING";
                        case 1:
                            complaints [row][4]= "CONFIRMED";
                            break;
                        case 2:
                            complaints [row][4]= "CANCELED";
                            break;
                        case 3:
                            complaints [row][4]= "COMPLETED";
                            break;   
                    }
                    row ++;
                }
                db.close();
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
            return complaints;
        }
        else{
            return null;
        }
    }
    //checks how many appointments the barber has in the database
    public int getAmtOfApps(int barberID){
        int comAmt = 0;
        
        try{
            Database db = new Database();
            String query = "SELECT count(*) FROM t_appointment where barberID = "+ barberID;
            ResultSet rs = db.executeQuery(query);
            
            if(rs.next()){
                comAmt = rs.getInt(1);
                
            }
            db.close();
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
        return comAmt;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
