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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Francisco Leite
 */
public class CustomerComplaintScreen extends Window{
    
    CustomerComplaintController controller;
    JTextField complaint;
    JComboBox barberCB;
    
    //constructor for the view
    public CustomerComplaintScreen (CustomerComplaintController customerComplaintController){
        this.controller = customerComplaintController;
        showCustomerComplaintScreen();
        validation();   
    }
    //properties of the view
    public void showCustomerComplaintScreen(){
        
        JPanel mainPanel = new JPanel();
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
        
        JLabel admpanel = new JLabel("Make Your Complaint");
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
        
        
        
        JPanel mainPanel3 = new JPanel();
        BorderLayout mp3Layout = new BorderLayout();
        mainPanel3.setBackground(Color.black);
        mainPanel3.setLayout(mp3Layout);
        mainPanel2.add(mainPanel3);
        
        JPanel bottomButtons = new JPanel();
        JButton backButton = new JButton ("Back");
        backButton.addActionListener(controller);
        backButton.setActionCommand("back");
        bottomButtons.add(backButton);
        mainPanel3.add(bottomButtons, BorderLayout.PAGE_END);
        
        JPanel mainPanel4 = new JPanel ();
        
        mainPanel3.add(mainPanel4);
        
        JLabel selectBarber = new JLabel("Select Barber:");
        mainPanel4.add(selectBarber);
        
        ComboBoxItem [] barbers = CustomerNewAppointmentController.getBarbers();
        barberCB = new JComboBox(barbers);
        mainPanel4.add(barberCB);
       
        
        complaint = new JTextField(50);
        mainPanel4.add(complaint);
        
        JButton submit = new JButton ("submit");
        submit.addActionListener(controller);
        
        mainPanel4.add(submit);
    }
    
    private void validation(){
        this.validate();
        this.repaint();
    }
    //return the barber ir from the combobox barbers that contains the name and the id of the barbers from the method getBarbers
    int getBarberID() {
        return ((ComboBoxItem)barberCB.getSelectedItem()).getId();//cast of the selected item to get the actual id of the barber instead of its location in the memory
    }   
    //return the complaint in the text field
    String getComplaint() {
        return complaint.getText();
    }
    int getBarberId() {
        return ((ComboBoxItem)barberCB.getSelectedItem()).getId();
    }
}
