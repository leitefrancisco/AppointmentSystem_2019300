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
/**
 *
 * @author Francisco Leite
 */
public class BarberAdminScreen extends Window{
    
    BarberAdminController controller;
    JPanel mainLeft;
    JPanel mainRight;
    
    public BarberAdminScreen(BarberAdminController barberAdminScreenController){
        this.controller = barberAdminScreenController;
        showBarberAdminScreen();
        validation();
    }
    //Properties of the Screen
    public void showBarberAdminScreen(){
        
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
        
        JLabel admpanel = new JLabel("Admin Panel");
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
        topPanelButtons.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainPanel2.add(topPanelButtons, BorderLayout.PAGE_START);
        
        JButton mngAppointments = new JButton("See All Appointments");
        mngAppointments.addActionListener(controller);
        mngAppointments.setActionCommand("allApps");
        JButton locations = new JButton("Add/Remove/Edit Locations");
        locations.addActionListener(controller);
        locations.setActionCommand("editLocation");
        
        JButton customerComplaints = new JButton("Customer Complaints");
        customerComplaints.addActionListener(controller);
        customerComplaints.setActionCommand("complaint");
        
        topPanelButtons.add(mngAppointments);
        topPanelButtons.add(locations);
        topPanelButtons.add(customerComplaints);
        
        JPanel aux = new JPanel();
        BorderLayout auxL = new BorderLayout();
        aux.setLayout(auxL);
        mainPanel2.add(aux);
        
        JPanel aux2 = new JPanel();
        GridLayout aux2L = new GridLayout(1,2);
        aux2.setLayout(aux2L);
        JPanel aux2Left = new JPanel ();
        aux2Left.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel aux2Right = new JPanel ();
        aux2Right.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        aux2.add(aux2Left);
        aux2.add(aux2Right);
        aux2Left.add(new JLabel ("Pending Appointments"));
        aux2Right.add(new JLabel ("Confirmed Appointments"));
        aux.add(aux2, BorderLayout.PAGE_START);
        
        
        JPanel mainPanel3 = new JPanel();
        GridLayout mp3Layout = new GridLayout(1,2);
        mainPanel3.setLayout(mp3Layout);
        aux.add(mainPanel3);
        
        
        mainLeft = new JPanel();
        JScrollPane jsL = new JScrollPane(mainLeft);
        jsL.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainPanel3.add(jsL);
        
        mainRight = new JPanel();
        JScrollPane jsR = new JScrollPane(mainRight);
        jsR.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainPanel3.add(jsR);
        
        
        
    }
    private void validation(){
        this.validate();
        this.repaint();
    }
    /*
    method to be used in the constructor of the controller to activate the model to get current information on appointments
    uses for loop to generate labels and buttons for each pending appoitment.
    */
    void showPenApps(Appointment[] appointments) {
        
        mainLeft.setLayout(new GridBagLayout());
        GridBagConstraints gBcon = new GridBagConstraints();
        gBcon.gridwidth = GridBagConstraints.REMAINDER;
        
        mainLeft.removeAll();
        for(int i =0 ; i< appointments.length; i++){
            
            Appointment app = appointments[i];
            if(app.getStatus() == 0){
                JLabel lbl = new JLabel(app.getFormattedDate().toString() + " " + app.getLocation() + " " + app.getCustomer());
                mainLeft.add(lbl);
                JButton confirmBtn = new JButton("Confirm");
                confirmBtn.addActionListener(controller);
                confirmBtn.setActionCommand("confirmApp:"+app.getAppoitmentId());
                mainLeft.add(confirmBtn);
                
                JButton btn = new JButton("Don't Accept");
                btn.addActionListener(controller);
                btn.setActionCommand("cancelApp:"+app.getAppoitmentId());
                mainLeft.add(btn,gBcon );
            }
            
        }
    }
    /*
    method to be used in the constructor of the controller to activate the model to get current information on appointments
    uses for loop to generate labels and buttons for each confirmed appoitment.
    */
    void showConfApps(Appointment[] appointments) {
        
        mainRight.setLayout(new GridBagLayout());
        GridBagConstraints gBcon = new GridBagConstraints();
        gBcon.gridwidth = GridBagConstraints.REMAINDER;
        
        mainRight.removeAll();
        for(int i =0 ; i< appointments.length; i++){
            Appointment app = appointments[i];
            
            
            if(app.getStatus() == 1){
                JLabel lbl = new JLabel(app.getFormattedDate() + " " + app.getLocation() + " " + app.getCustomer());
                mainRight.add(lbl);
                
                JButton btn = new JButton("Cancel");
                btn.addActionListener(controller);
                btn.setActionCommand("cancelApp:"+app.getAppoitmentId());
                mainRight.add(btn);
                
                JButton complete = new JButton("Set as Completed");
                complete.addActionListener(controller);
                complete.setActionCommand("complete:"+app.getAppoitmentId());
                mainRight.add(complete,gBcon );
            }
        }
        
    }
    
    
}
