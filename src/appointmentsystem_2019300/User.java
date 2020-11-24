/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package appointmentsystem_2019300;

/**
 *
 * @author Francisco Leite
 */
public class User {
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConf;
    private char userType;
    private int userID;

   
    
     public User(String email, String password){
        this.password = password;
        this.email = email;      
    }
    
    public User(String firstName, String lastName, String email, String password, char userType){
        this(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
       
        
    }
    public User(String firstName, String lastName, String email, String password,char userType, int userID){
        this(firstName, lastName, email, password, userType);
                this.userID = userID;
    }
    
    public User(String firstName, String lastName, String email, String password, String passwordConf,char userType){
        this(firstName, lastName, email, password, userType);
        this.passwordConf = passwordConf;
        
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getPasswordConf() {
        return passwordConf;
    }

    public char getUserType() {
        return userType;
    }
     public int getUserID() {
        return userID;
    }
}
