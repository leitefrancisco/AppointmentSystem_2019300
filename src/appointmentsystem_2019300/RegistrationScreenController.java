/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco Leite
 */
public class RegistrationScreenController implements ActionListener {
    
    //RegistrationScreenModel registrationScreenModel;
    RegistrationScreen view;
    
    
    
    public RegistrationScreenController (){
        this.view = new RegistrationScreen(this);
        // this.registrationScreenModel = new RegistrationScreenModel();
    }
    
    // View -> [buton] -> controller.action
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confReg")){
            /*
            
            View  []
            
            --------- Controller
            
            Model
            
            
           
            String firstName;
            String lastName;
            String email;
            String password;
            String passConf;
            */
   
            RegistrationScreenModel model = new RegistrationScreenModel(
                    this.view.getFirstName(),
                    this.view.getLastName(),
                    this.view.getEmail(),
                    this.view.getPassword(),
                    this.view.getPasswordConfirmation(),
                    this.view.getUserType()
            );
            
            if(model.writeUser()){
                JOptionPane.showMessageDialog(view, "Welcome, you were registered!");
            }
            else{
                JOptionPane.showMessageDialog(view, "Sorry something went wrong, check your data and try again!");
            }
        }
        else if(e.getActionCommand().equals("back")){
            view.dispose();
            new LoginScreenController();
        }
        
        
    }
    
    
    
}
