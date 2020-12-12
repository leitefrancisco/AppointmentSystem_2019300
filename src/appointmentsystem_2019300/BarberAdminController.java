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
public class BarberAdminController implements ActionListener {
    
    BarberAdminScreen view;
     //constructor of the controller contains the view   and the methods that gather inofrmation from the data base
    public BarberAdminController(){
        this.view = new BarberAdminScreen(this);
        showPenApps();
        showConfApps();
    }
    
    // shows pending appointments
    public void showPenApps(){
        Appointment[] appointments = new BarberAdminModel().getCurrentAppointments();
        
        this.view.showPenApps(appointments);
    }
    
    //show the confirmed appointments
    public void showConfApps(){
        Appointment[] appointments = new BarberAdminModel().getCurrentAppointments();
        
        this.view.showConfApps(appointments);
    }
    
    //instructions for each button in the current screen
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
        
        else if (e.getActionCommand().equals("allApps")){
            view.dispose();
            new BarberAppController();
        }
        //confirms the status of the appointment to "confirimed in the data base
        else if(e.getActionCommand().startsWith("confirmApp:")){
            int a = JOptionPane.showConfirmDialog(null,"Accept Appointment?","=]",JOptionPane.YES_NO_OPTION);
            if (a == 0)
            {
                int appId = Integer.parseInt(e.getActionCommand().split(":")[1]);
                if(new BarberAdminModel().confirmApp(appId)){
                    view.dispose();
                    this.view = new BarberAdminScreen(this);
                    showPenApps();
                    showConfApps();
                }
            }
        }
        //refuse pendings or cancel already accepted appoitments
        else if(e.getActionCommand().startsWith("cancelApp:")){
            int a = JOptionPane.showConfirmDialog(null,"Refuse / Cancel Appointment?","=[",JOptionPane.YES_NO_OPTION);
            if (a == 0)
            {
                int appId = Integer.parseInt(e.getActionCommand().split(":")[1]);
                if(new BarberAdminModel().cancelApp(appId)){
                    JOptionPane.showMessageDialog(view, "Appointment Canceled / not Accepted");
                    view.dispose();
                    this.view = new BarberAdminScreen(this);
                    showPenApps();
                    showConfApps();
                }
            }
        }
        
        else if(e.getActionCommand().startsWith("complete:")){
            int a = JOptionPane.showConfirmDialog(null,"Set as completed?","=]",JOptionPane.YES_NO_OPTION);
            if (a == 0)
            {
                int appId = Integer.parseInt(e.getActionCommand().split(":")[1]);
                if(new BarberAdminModel().completeApp(appId)){
                    JOptionPane.showMessageDialog(view, "Appointment Completed!");
                    view.dispose();
                    this.view = new BarberAdminScreen(this);
                    showPenApps();
                    showConfApps();
                }
            }
        }   
    }   
}
