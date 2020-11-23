package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
                int type = model.userType();
                if (type == 1){
                    new CustomerAdminScreenController();
                    
                }
                else{
                    loginScreen.dispose();
                    new BarberAdminScreenController();
                }
                
                
                
                
            }
            else{
                JOptionPane.showMessageDialog(loginScreen, "Something went wrong, check your information or create a new account!");
            }
        }
        
        
        if(e.getActionCommand().equals("newUser")){
            
            loginScreen.dispose();
            
            new RegistrationScreenController();
            
            
            
        }
        
        
    }
    
    
}
