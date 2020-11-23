package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreenController implements ActionListener {

    
//    LoginScreenModel loginScreenModel;
    LoginScreen loginScreen;
    
 
    
    public LoginScreenController(){
        
//        this.loginScreenModel = new LoginScreenModel();
        this.loginScreen = new LoginScreen(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("login")){
            LoginScreenModel model = new LoginScreenModel(loginScreen.getUName(),  loginScreen.getUPassword());
            boolean result = model.login();
            
            if(result){
                System.out.println("you are in");
                
            }
            else{
                System.out.println("you are out");
            }
        }

        
        if(e.getActionCommand().equals("newUser")){
            
            loginScreen.dispose();
            
            new RegistrationScreenController();
            
           
            
        }
        
        
    }
    
    
}
