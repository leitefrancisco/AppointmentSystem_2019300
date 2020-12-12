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
public class CustomerAdminController implements ActionListener {
    
    CustomerAdminScreen view;
    
    CustomerAdminController(){
        this.view = new CustomerAdminScreen(this);
        showCurrentAppointments();
    }
    
    public void showCurrentAppointments(){
        Appointment[] appointments = new CustomerAdminModel().getCurrentAppointments();
        
        this.view.showCurrentAppointments(appointments);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("logout")){
            LogoutController.logout(view);
        }
        else if (e.getActionCommand().equals("makeNewAppointment")){
            view.dispose();
            new CustomerNewAppointmentController();
        }
        else if(e.getActionCommand().equals("makeComplaint")){
            view.dispose();
            new CustomerComplaintController();
        }
        else if(e.getActionCommand().startsWith("cancelApp:")){  // cancelApp:12
            int a = JOptionPane.showConfirmDialog(null,"Refuse / Cancel Appointment?","=[",JOptionPane.YES_NO_OPTION);
            
            
            if (a == 0)
            {
                int appId = Integer.parseInt(e.getActionCommand().split(":")[1]);
                if(new CustomerAdminModel().cancelApp(appId)){
                    JOptionPane.showMessageDialog(view, "Appointment Canceled, you can create book another one at any time!");
                    view.dispose();
                    this.view = new CustomerAdminScreen(this);
                    showCurrentAppointments();
                }else{
                    // message :(
                }
            }
        }
        
    }
    
    
    
    
    
    
}
