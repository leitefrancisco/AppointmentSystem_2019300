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
public class BarberFirstLocationController implements ActionListener{
    
    BarberFirstLocationScreen barberfirstLocationScreen;
    
    public BarberFirstLocationController(){
        this.barberfirstLocationScreen = new BarberFirstLocationScreen(this);
    }
    
  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getActionCommand().equals("confLocation")){
            BarberFirstLocationModel model = new BarberFirstLocationModel(
                    barberfirstLocationScreen.getBarberLocation(),
                    barberfirstLocationScreen.checkMon(),
                    barberfirstLocationScreen.checkTue(),
                    barberfirstLocationScreen.checkWed(),
                    barberfirstLocationScreen.checkThu(),
                    barberfirstLocationScreen.checkFri(), 
                    barberfirstLocationScreen.checkSat(),
                    barberfirstLocationScreen.checkSun());
            
//            if(model.isValid()==false){
////                showErrorMessage();
//            }else{
//                model.insertLocation();    
//            }
            
            
        }
    }
    
}
