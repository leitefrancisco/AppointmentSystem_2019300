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
    
    private String un;
    private String firstName;
    private String lastName;
    private String email;
    private String pw;
    
    public User(String un, String pw){
        this.un = un;
        this.pw = pw;
    }

    public String getUn() {
        return un;
    }

    public String getPw() {
        return pw;
    }
    
}
