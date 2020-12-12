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
class BarberLocationController implements ActionListener {
    BarberLocationScreen  view;
    //constructor of the controller contains the view.
    public BarberLocationController() {
        this.view = new BarberLocationScreen(this);
        showLocations();
    }
    //gets the location from the database using the model they can be applied to the method show locations in the view
    void showLocations(){
        BarberLocation[] locations = new BarberLocationModel().getBarberLocations();
        view.showLocations(locations);
    }
    
    //Instructions for each button in the view
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //gets the id by spliting the name of the button therefore making possible to edit the correct location
        if(e.getActionCommand().startsWith("edit:")){
            int locationId = Integer.parseInt(e.getActionCommand().split(":")[1]);
            view.dispose();
            new BarberLocationEditController("locations", locationId);
        }
        
        
        else if(e.getActionCommand().startsWith("delete:")){
            
            int locationId = Integer.parseInt(e.getActionCommand().split(":")[1]);
            int a = JOptionPane.showConfirmDialog(null,"Delete this location?","=]",JOptionPane.YES_NO_OPTION);
            if (a == 0)
            {
                BarberLocationModel model = new BarberLocationModel();
                if(model.deleteRelation(locationId)){
                    JOptionPane.showMessageDialog(null, "Place deleted");
                    view.dispose();
                    this.view = new BarberLocationScreen(this);
                    showLocations();
                    
                }
                else{
                   JOptionPane.showMessageDialog(null, "Impossible to delete location, contact your system admin"); 
                }
            }
            
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
