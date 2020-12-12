package appointmentsystem_2019300;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CustomerAdminScreen extends Window{
    CustomerAdminController controller;
     JPanel mainLeft;
     JPanel mainPanel3;
     //Constructor for the view 
    public CustomerAdminScreen(CustomerAdminController controller){
        this.controller = controller;
        showCostumerAdminScreen();
        validation();
    }
    //Properties of the view
    public void showCostumerAdminScreen(){
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.blue);
        BorderLayout mpLayout = new BorderLayout();
        mainPanel.setLayout(mpLayout);
        this.add(mainPanel);
        
        JPanel screenName = new JPanel();
        GridLayout snLayout = new GridLayout(1,2);
        screenName.setLayout(snLayout);
        mainPanel.add(screenName, BorderLayout.PAGE_START);
        
        JPanel tLeft = new JPanel();
        JPanel tRight = new JPanel();
        screenName.add(tLeft);
        screenName.add(tRight);
        
        JLabel admpanel = new JLabel("Welcome!");
        tLeft.add(admpanel);
        JButton logOut = new JButton("Log Out");
        logOut.addActionListener(controller);
        logOut.setActionCommand("logout");
        tRight.add(logOut);
        screenName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        
        
        JPanel mainPanel2 = new JPanel();
        BorderLayout mp2Layout = new BorderLayout();
        mainPanel2.setLayout(mp2Layout);
        mainPanel.add(mainPanel2, BorderLayout.CENTER);

        JPanel topPanelButtons = new JPanel();
        mainPanel2.add(topPanelButtons, BorderLayout.PAGE_START);
        topPanelButtons.add(new JLabel("Your Appointments"));
        
        JButton makeNewAppointment = new JButton("Make a New Appointment");
        makeNewAppointment.addActionListener(controller);
        makeNewAppointment.setActionCommand("makeNewAppointment");
        
        JButton makeComplaints = new JButton("Make a Complaint");
        makeComplaints.addActionListener(controller);
        makeComplaints.setActionCommand("makeComplaint");
        
        
        
        topPanelButtons.add(makeNewAppointment);
        topPanelButtons.add(makeComplaints);
        
        
        mainPanel3 = new JPanel();
        JScrollPane jsp = new JScrollPane(mainPanel3);
        jsp.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        mainPanel2.add(jsp);
  
    }
    
    private void validation(){
        this.validate();
        this.repaint();
    }
    //show the current appoitments gotten by the controller and the model
    void showCurrentAppointments(Appointment[] appointments) {
        
        mainPanel3.setLayout(new GridBagLayout());
        GridBagConstraints gBcon = new GridBagConstraints();
        gBcon.gridwidth = GridBagConstraints.REMAINDER; 
        
        mainPanel3.removeAll();
        
        for(int i =0 ; i< appointments.length; i++){
            
            Appointment app = appointments[i];
            String status = null;
            
            if(app.getStatus() == 0){
                status = "Pending";
            }
            else if (app.getStatus()==1){
                status = "Confirmed";
            }
            
            JLabel lbl = new JLabel(app.getFormattedDate() + "- in " + app.getLocation() + " with Barber " + app.getBarber()+" ------------ "+ status+ " ------------ ");
            mainPanel3.add(lbl);
            JButton btn = new JButton("Cancel");
            btn.addActionListener(controller);
            btn.setActionCommand("cancelApp:"+app.getAppoitmentId());
            mainPanel3.add(btn, gBcon);
            
        }
        
    } 
}
