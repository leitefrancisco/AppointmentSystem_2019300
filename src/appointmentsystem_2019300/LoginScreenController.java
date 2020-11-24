package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginScreenController implements ActionListener {
    
    
    
    LoginScreen loginScreen;
   
    
    
    public LoginScreenController(){
        
       
        this.loginScreen = new LoginScreen(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("login")){
            LoginScreenModel model = new LoginScreenModel(loginScreen.getUName(),  loginScreen.getUPassword());
            
            User user = model.login();
            
            if(user != null){
                char type = user.getUserType();
                if (type == 'c'){
                    loginScreen.dispose();
                    new CustomerAdminScreenController();
                }
                else{
                    
                    
                    BarberAdminScreenModel bmodel = new BarberAdminScreenModel(user);
                    
                    if(!bmodel.checkBarberhasLocation()){
                        
                        loginScreen.dispose();
                        new BarberFirstLocationController();
                        JOptionPane.showMessageDialog(null, "Hi, to start you need to add at least one location to work! You can edit and add more locations after in \"Manage Locations\"");
                    }else{
                        loginScreen.dispose();
                        new BarberAdminScreenController();
                        
                    }
                    
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
