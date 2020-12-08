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
public class BarberAdminController implements ActionListener {
    
    BarberAdminScreen view;
    
    public BarberAdminController(){
        this.view = new BarberAdminScreen(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("logout")){
            LogoutController.logout(view);
            
        }
        else if(e.getActionCommand().equals("complaint")){
            view.dispose();
            new BarberComplaintController();
        }
        
        else if (e.getActionCommand().equals("editLocation")){
            view.dispose();
            new BarberLocationController();
        }
        
        
        
        
        
    }
    
    
    
}
