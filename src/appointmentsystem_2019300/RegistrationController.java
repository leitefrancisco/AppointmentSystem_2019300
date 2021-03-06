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
public class RegistrationController implements ActionListener {
    
    RegistrationScreen view;
    
    public RegistrationController (){
        this.view = new RegistrationScreen(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confReg")){
            
            RegistrationModel model = new RegistrationModel(
                    this.view.getFirstName().trim(),
                    this.view.getLastName().trim(),
                    this.view.getEmail().trim(),
                    this.view.getPassword().trim(),
                    this.view.getPasswordConfirmation().trim(),
                    this.view.getUserType()
                    
            );
            
            //Validatiions for the reistration 
            if(!view.getPassword().trim().equals(view.getPasswordConfirmation().trim())){
                JOptionPane.showMessageDialog(view, "Password and Password Confirmation needs to be the same!");
            }
            else if(view.getFirstName().trim().isEmpty()||view.getLastName().trim().isEmpty()||
                    view.getEmail().trim().isEmpty()||view.getPassword().trim().isEmpty()||
                    view.getPasswordConfirmation().trim().isEmpty()){
                JOptionPane.showMessageDialog(view, "All fields needs to be filled");
            }
            else if(!view.getEmail().trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
                JOptionPane.showMessageDialog(view, "Not a Valid Email ");
            }
            else if(model.emailExists(this.view.getEmail().trim())){
                JOptionPane.showMessageDialog(view, "Email already exists! ");
            }
            
            
            else {
                
                String type = String.valueOf(view.getUserType());
                if (type.equals("c")){
                    type = "COSTUMER";
                }
                else{
                    type = "BARBER";
                }
                int a = JOptionPane.showConfirmDialog(null,"confirm Registration as a "+type+"?","=[",JOptionPane.YES_NO_OPTION);
                if (a == 0)
                {
                    if(model.writeUser()){
                        
                        JOptionPane.showMessageDialog(view, "Welcome, you were registered!");
                        view.dispose();
                        new LoginController();
                    }
                }
            }
        }
        
        else if(e.getActionCommand().equals("back")){
            view.dispose();
            new LoginController();
            
        }
    }
    
    
    
}
