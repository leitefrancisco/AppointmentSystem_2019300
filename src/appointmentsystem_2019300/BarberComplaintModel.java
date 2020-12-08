/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem_2019300;

import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Francisco Leite
 */
public class BarberComplaintModel {
    
    public String [][] getComplaints(int barberID){
        int amt = getAmtOfComplaints(barberID);
        if(amt >0){
        
        
        
        String [][] complaints = new String [amt+1][3];
        
        try{
           Database db = new Database();
           String query = "SELECT customerFullName, customerEmail, complaintText FROM t_complaint where barberID = "+barberID;
            ResultSet rs = db.executeQuery(query);
           
          int row = 0;
            while (rs.next()) {
                complaints [row][0]= rs.getString(1);
                complaints [row][1]= rs.getString(2);
                complaints [row][2]= rs.getString(3);
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
    
    public int getAmtOfComplaints(int barberID){
        int comAmt = 0;
        
        try{
           Database db = new Database();
           String query = "SELECT count(*) FROM t_complaint where barberID = "+barberID;
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
    
    
    
    
    
    
    
    

    
       
//    public String[][] callingDB(){
//        String [][] data = new String [20][3];
//        try {
//            String dbServer = "jdbc:mysql://apontejaj.com:3306/testing_gui?useSSL=false";
//            String dbUser = "cctstudent";
//            String dpPassword = "cctstudent";
//            String query = "select * FROM user;";
//            // Get a connection to the database
//            Connection conn = DriverManager.getConnection(dbServer, dbUser, dpPassword);
//            // Get a statement from the connection
//            Statement stmt = conn.createStatement();
//            // Execute the query
//            // stmt.execute("INSERT INTO user(first_name, student_number) " + "VALUES ('Francisco', 2019300);");
//            ResultSet rs = stmt.executeQuery(query);
//            // Loop through the result set
//            int row = 0;
//            while (rs.next()) {
//                data [row][0]= rs.getString("id");
//                data [row][1]= rs.getString("first_name");
//                data [row][2]= rs.getString("student_number");
//                row ++;
//                //System.out.println(rs.getString("id") + rs.getString("first_name") + "\t" + rs.getString("student_number"));
//            }
//            // Close the result set, statement and the connection
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (SQLException se) {
//            System.out.println("SQL Exception:");
//            // Loop through the SQL Exceptions
//            while (se != null) {
//                System.out.println("State  : " + se.getSQLState());
//                System.out.println("Message: " + se.getMessage());
//                System.out.println("Error  : " + se.getErrorCode());
//                se = se.getNextException();
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }       
//        return data;
//    }
}
