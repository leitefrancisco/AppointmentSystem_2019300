/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Francisco Leite
 */
class CustomerComplaintController implements ActionListener {
    
    CustomerComplaintScreen customerComplaintScreen;
    
    public CustomerComplaintController() {
        this.customerComplaintScreen = new CustomerComplaintScreen(this);
    }
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("back"))
        {
           customerComplaintScreen.dispose();
           new CustomerAdminController();
        }
        else if (e.getActionCommand().equals("logout")){
            if(LogoutController.logout()==0){
            customerComplaintScreen.dispose();
            }
        }
        
        
    }
    
}
