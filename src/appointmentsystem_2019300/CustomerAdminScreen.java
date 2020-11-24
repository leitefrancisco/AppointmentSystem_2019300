/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem_2019300;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Francisco Leite
 */
public class CustomerAdminScreen extends JFrame {
    CustomerAdminScreenController controller;
    
    public CustomerAdminScreen(CustomerAdminScreenController controller){
        this.controller = controller;
        frameSetter();
        showCostumerAdminScreen();
        validation();
    }
    
    private void frameSetter(){
        
        this.setVisible(true);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Barbershop");
        this.setVisible(true);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Barbershop");
        BorderLayout frameLayout = new BorderLayout();
        this.setLayout(frameLayout);
        //head
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(topPanel, BorderLayout.PAGE_START);
        JLabel barberShop = new JLabel("Barber Shop") ;
        topPanel.add(barberShop);
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
        logOut.setActionCommand("exitToLogin");
        tRight.add(logOut);
        screenName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        
        
        JPanel mainPanel2 = new JPanel();
        BorderLayout mp2Layout = new BorderLayout();
        mainPanel2.setLayout(mp2Layout);
        mainPanel.add(mainPanel2, BorderLayout.CENTER);

        JPanel topPanelButtons = new JPanel();
        mainPanel2.add(topPanelButtons, BorderLayout.PAGE_START);
        
        JButton makeNewAppointment = new JButton("Make a New Appointment");
        JButton manageAppointments = new JButton("Manage Appointments");
        JButton makeComplaints = new JButton("Make a Complaint");
        JButton editPersonalData = new JButton("Edit Personal Info/Password");
        
        
        topPanelButtons.add(makeNewAppointment);
        topPanelButtons.add(manageAppointments);
        topPanelButtons.add(makeComplaints);
        topPanelButtons.add(editPersonalData);
        
        JPanel mainPanel3 = new JPanel();
        GridLayout mp3Layout = new GridLayout(1,2);
        mainPanel3.setLayout(mp3Layout);
        mainPanel2.add(mainPanel3);
        
        JPanel mainLeft = new JPanel();
        mainLeft.setBackground(Color.red);
        mainPanel3.add(mainLeft);
        
        JPanel mainRight = new JPanel();
        mainRight.setBackground(Color.blue);
        mainPanel3.add(mainRight);
        
        
        
        
        
        
        
     
        
        
        
        
        
        
 
        
        
    }
    private void validation(){
        this.validate();
        this.repaint();
    }
    
}
