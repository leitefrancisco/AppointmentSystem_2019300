package appointmentsystem_2019300;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CustomerAdminController implements ActionListener {
    
    CustomerAdminScreen view;
    //constructor for the customer admin controller with the customer admin view
    CustomerAdminController(){
        this.view = new CustomerAdminScreen(this);
        showCurrentAppointments();
    }
    //gets the current appointments of the costumer using the model and ads it in the view . with the controller constructor
    public void showCurrentAppointments(){
        
        Appointment[] appointments = new CustomerAdminModel().getCurrentAppointments();
        this.view.showCurrentAppointments(appointments);
    }
    //instructions for each button in the view
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
        //used to cancel the appointment acording with the id of its label
        else if(e.getActionCommand().startsWith("cancelApp:")){  
            int a = JOptionPane.showConfirmDialog(null,"Refuse / Cancel Appointment?","=[",JOptionPane.YES_NO_OPTION);
            if (a == 0)
            {
                int appId = Integer.parseInt(e.getActionCommand().split(":")[1]);
                if(new CustomerAdminModel().cancelApp(appId)){
                    JOptionPane.showMessageDialog(view, "Appointment Canceled, you can create book another one at any time!");
                    view.dispose();
                    this.view = new CustomerAdminScreen(this);
                    showCurrentAppointments();
                }
            }
        }
    }
}
