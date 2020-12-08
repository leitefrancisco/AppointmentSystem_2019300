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
class CustomerComplaintController implements ActionListener {
    
    CustomerComplaintScreen view;
    
    public CustomerComplaintController() {
        this.view = new CustomerComplaintScreen(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("back"))
        {
           view.dispose();
           new CustomerAdminController();
        }
        else if (e.getActionCommand().equals("logout")){
            LogoutController.logout(view);
        }
        else if(e.getActionCommand().equals("submit")){

            CustomerComplaintModel model = new CustomerComplaintModel();
            
            if(model.writeComplaint(view.getBarberID(),User.getCurrentUser().getUserID(),
                    view.getComplaint(),User.getCurrentUser().getFullName(), 
                    User.getCurrentUser().getEmail())){
                JOptionPane.showMessageDialog(view, "Complaint Registered, the barber will contact you via email");
                view.dispose();
                new CustomerAdminController();
            }
            else{
                JOptionPane.showMessageDialog(view, "something went wrong, that's on us ... Try again later.");
            }
            
        }
        
        
    }
    
}
