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

/*
class to create a user object, has its attributes and is used several times in
the application
*/
public class User {
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConf;
    private char userType;
    private int userID;
    private static User currentUser;
    
    public User (int id, String firstName, String lastName){
        this.userID = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
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
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    
    //static method to get the user that was setted as the current user at the login
    public static User getCurrentUser(){
        return currentUser;
    }
    //get the information from the login and set the user as the current user of the application
    public static void setCurrentUser(User value){
        currentUser = value;
    }
    //set the current user as null in order to perform a proper logoff
    public static void logoff(){
        currentUser = null;
    }
}
