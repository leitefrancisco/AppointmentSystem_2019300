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
public class CustomerNewAppointmentController implements ActionListener{
    
    CustomerNewAppointmentScreen customerNewAppointmentScreen;
    
    public CustomerNewAppointmentController (){
        this.customerNewAppointmentScreen = new CustomerNewAppointmentScreen(this); 
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
