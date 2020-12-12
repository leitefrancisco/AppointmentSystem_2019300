package appointmentsystem_2019300;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Class to create the connection with the data base
public class Database {
    
    String dbServer = "jdbc:mysql://apontejaj.com:3306/Francisco_2019300?useSSL=false";
    String dbUser = "Francisco_2019300";
    String dpPassword = "2019300";
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    //Execute queries
    public ResultSet executeQuery(String query) throws SQLException{
        // Get a connection to the database
        conn = DriverManager.getConnection(dbServer, dbUser, dpPassword);
        // Get a statement from the connection
        stmt = conn.createStatement();
        //Execute the query
        rs = stmt.executeQuery(query);
        
        return rs;
    }
    //execute comands to update or insert data into tables for example
    public boolean execute(String query) throws SQLException{
        // Get a connection to the database
        conn = DriverManager.getConnection(dbServer, dbUser, dpPassword);
        // Get a statement from the connection
        stmt = conn.createStatement();
        //Execute the query
        boolean result = stmt.execute(query);
        
        return result;
    }
    //Close the result set, statement and the connection
    public void close() throws SQLException{
        
            
        if(stmt != null){
            stmt.close();
        }
        if(conn != null){
            conn.close();
        }
        if(rs != null){
            rs.close();
        }
    }
}
