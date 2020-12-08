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
class BarberLocationController implements ActionListener {
    BarberLocationScreen  view;
    public BarberLocationController() {
        this.view = new BarberLocationScreen(this);
        showLocations();
    }
    
    void showLocations(){
        BarberLocation[] locations = new BarberLocationModel().getBarberLocations();
        view.showLocations(locations);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
                
         if(e.getActionCommand().startsWith("edit:")){  // cancelApp:12
            // cancel appo
            int locationId = Integer.parseInt(e.getActionCommand().split(":")[1]);
            // show form to edit location id
            view.dispose();
            new BarberLocationEditController("locations", locationId);
        }
         else if(e.getActionCommand().equals("addNew")){
             view.dispose();
             new BarberLocationEditController("locations", 0);
             
         }
         else if(e.getActionCommand().equals("back")){
             view.dispose();
             new BarberAdminController();
         }
         else if(e.getActionCommand().equals("logout")){
             LogoutController.logout(view);
             
         }
    }

    
    
}
