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
class BarberAppController implements ActionListener {
        BarberAppScreen view;
        
    public BarberAppController() {
        view = new BarberAppScreen (this);
        showApps();
    }
    
    private void showApps(){
        
        BarberAppModel model = new BarberAppModel();
        
        int amt = model.getAmtOfApps(User.getCurrentUser().getUserID());
        
        if(amt>0){
            String [][] complaints = model.getApps(User.getCurrentUser().getUserID());
            view.DisplayData(complaints);
        }
        else{
            
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {

    if(e.getActionCommand().equals("back")){
            view.dispose();
            new BarberAdminController();
        }
        else if(e.getActionCommand().equals("logout")){
            LogoutController.logout(view);
            
        }
    
    
    
    
    }
    
}
