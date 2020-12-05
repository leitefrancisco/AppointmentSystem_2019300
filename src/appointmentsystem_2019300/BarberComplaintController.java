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
public class BarberComplaintController implements ActionListener {
    BarberComplaintScreen barberComplaintScreen;
    
    public BarberComplaintController(){
        this.barberComplaintScreen = new BarberComplaintScreen(this);
    }
    
    
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getActionCommand().equals("back")){
            barberComplaintScreen.dispose();
            new BarberAdminController();
        }
        else if(e.getActionCommand().equals("logout")){
            if(LogoutController.logout()==0){
            barberComplaintScreen.dispose();
            }
        }
        
        
        
        
        
    }
    
    
    
}
