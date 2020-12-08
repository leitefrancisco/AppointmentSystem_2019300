package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginController implements ActionListener {
    
    
    LoginScreen loginScreen;
    
    
    
    public LoginController(){
        
        
        this.loginScreen = new LoginScreen(this);
     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("login")){
            LoginModel model = new LoginModel(loginScreen.getUName(),  loginScreen.getUPassword());
            
            User.setCurrentUser(model.login());
            
            if(User.getCurrentUser() != null){
                char type = User.getCurrentUser().getUserType();
                if (type == 'c'){
                    loginScreen.dispose();
                    new CustomerAdminController();
                }
                else{
                    
                    
                    BarberAdminModel bmodel = new BarberAdminModel();
                    
                    if(!bmodel.checkBarberhasLocation()){
                        
                        loginScreen.dispose();
                        
                        new BarberLocationEditController("login", 0);
                        
                        JOptionPane.showMessageDialog(null, "Hi, to start you need to add at least one location to work! You can edit and add more locations after in \"Manage Locations\"");
                    }else{
                        loginScreen.dispose();
                        new BarberAdminController();
                    }
                    
                }
                
            }
            else{
                JOptionPane.showMessageDialog(loginScreen, "Something went wrong, check your information or create a new account!");
            }
        }
        
        
        if(e.getActionCommand().equals("newUser")){
            
            loginScreen.dispose();
            
            new RegistrationController();
            
        }
        
        
    }
    
    
}
