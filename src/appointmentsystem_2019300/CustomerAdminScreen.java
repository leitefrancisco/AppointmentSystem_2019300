/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CustomerAdminScreen extends Window{
    CustomerAdminController controller;
     JPanel mainLeft;
     JPanel mainPanel3;
    public CustomerAdminScreen(CustomerAdminController controller){
        this.controller = controller;
        showCostumerAdminScreen();
        validation();
    }
    
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
//        GridLayout mp3Layout = new GridLayout(1,2);
//        mainPanel3.setLayout(mp3Layout);
        mainPanel2.add(jsp);
        
//        mainLeft = new JPanel();
         
//        mainPanel3.add(mainLeft);
        
//        JPanel mainRight = new JPanel();
//        mainRight.setBackground(Color.blue);
//        mainPanel3.add(mainRight);
        
    }
    private void validation(){
        this.validate();
        this.repaint();
    }

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
            JLabel lbl = new JLabel(app.getDate().toString() + " " + app.getLocation() + " " + app.getBarber()+" "+ status);
            mainPanel3.add(lbl);
            JButton btn = new JButton("Cancel");
            btn.addActionListener(controller);
            btn.setActionCommand("cancelApp:"+app.getAppoitmentId()); // cancelApp:1
            mainPanel3.add(btn, gBcon);
            
        }
        
    }
    
}
