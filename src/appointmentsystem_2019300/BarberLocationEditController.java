/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco Leite
 */
public class BarberLocationEditController implements ActionListener{
    
    BarberLocationEditScreen view;
    int locationID;
    String onBack;
    public BarberLocationEditController(String onBack, int locationID){
        this.view = new BarberLocationEditScreen(this);
        this.onBack = onBack;
        this.locationID = locationID;
        if(this.locationID>0){ // edit
            showExistingData();
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("confLocation")){
            BarberLocationEditModel model = new BarberLocationEditModel(
                    view.getBarberLocation(),
                    view.checkMon(),
                    view.checkTue(),
                    view.checkWed(),
                    view.checkThu(),
                    view.checkFri(),
                    view.checkSat(),
                    view.checkSun(),
                    this.locationID
            );
            
            if(model.isValid()==false){
                JOptionPane.showMessageDialog(view, "Location can't be empty and you need to choose at least one day to work");
            }else{
                try {
                    model.saveLocation();
                    view.dispose();
                    new BarberAdminController();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, "Error: " + ex.getMessage());
                }
                
            }
        }
        else if(e.getActionCommand().equals("back")){
            if(onBack.equals("login")){
                User.logoff();
                new LoginController();
            }
            else if(onBack.equals("locations")){
                new BarberLocationController();
            }
            view.dispose();
        }
        else if(e.getActionCommand().equals("logout")){
            LogoutController.logout(view);
        }
        
    }
    
    private void showExistingData() {
        BarberLocationEditModel model = new BarberLocationEditModel();
        model.loadFromDb(this.locationID);
        this.view.showExistingData(model);
    }
    
}
