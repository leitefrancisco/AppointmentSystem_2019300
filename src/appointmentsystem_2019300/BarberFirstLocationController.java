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
public class BarberFirstLocationController implements ActionListener{
    
    BarberFirstLocationScreen barberFirstLocationScreen;
    
    public BarberFirstLocationController(){
        this.barberFirstLocationScreen = new BarberFirstLocationScreen(this);
    }
    
  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getActionCommand().equals("confLocation")){
            BarberFirstLocationModel model = new BarberFirstLocationModel(
                    barberFirstLocationScreen.getBarberLocation(),
                    barberFirstLocationScreen.checkMon(),
                    barberFirstLocationScreen.checkTue(),
                    barberFirstLocationScreen.checkWed(),
                    barberFirstLocationScreen.checkThu(),
                    barberFirstLocationScreen.checkFri(), 
                    barberFirstLocationScreen.checkSat(),
                    barberFirstLocationScreen.checkSun());
            
            if(model.isValid()==false){
                JOptionPane.showMessageDialog(barberFirstLocationScreen, "Location can't be empty and you need to choose at least one day to work");
            }else{
                model.insertLocation();    
                barberFirstLocationScreen.dispose();
                new BarberAdminController();
            }    
        }
        if(e.getActionCommand().equals("back")){
            User.Logoff();
            barberFirstLocationScreen.dispose();
        }
    }
    
}
