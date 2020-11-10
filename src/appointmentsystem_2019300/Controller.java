package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    LoginScreen loginScreen;
    RegistrationScreenCustomer registrationScreenCustomer;
    RegistrationScreenBarber registrationScreenBarber;
    Model model;
    
    public Controller(){
        //this.registrationScreenCustomer = new RegistrationScreenCustomer(this);
        this.registrationScreenBarber = new RegistrationScreenBarber(this);
        this.loginScreen = new LoginScreen(this);
        this.model = new Model();  
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("login")){
            
            String un = loginScreen.getUName();
            String up = loginScreen.getUPassword();
            
            User user = new User(un, up);
            
            boolean result = model.login(user);
            
            if(result){
                System.out.println("you are in");
                
            }
            else{
                System.out.println("you are out");
            
            }    
        }
        if(e.getActionCommand().equals("newUser")){
            
        }
            
            
            
            
            
            
        
        
        
        
    }
    
   
}
