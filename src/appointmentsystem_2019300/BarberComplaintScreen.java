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
public class BarberComplaintScreen extends JFrame{
    BarberComplaintController barberComplaintController; 
    public BarberComplaintScreen(BarberComplaintController barberComplaintController){
        this.barberComplaintController = barberComplaintController;
        frameSetter();
        showComplaintsBarberScreen();
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
    
    public void showComplaintsBarberScreen(){
        
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
        
        JLabel admpanel = new JLabel("Customers Complaints");
        tLeft.add(admpanel);
        JButton logout = new JButton("Log Out");
        
        tRight.add(logout);
        screenName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JPanel mainPanel2 = new JPanel();
        BorderLayout mp2Layout = new BorderLayout();
        mainPanel2.setLayout(mp2Layout);
        mainPanel.add(mainPanel2, BorderLayout.CENTER);
        
        JPanel topPanelButtons = new JPanel();
        mainPanel2.add(topPanelButtons, BorderLayout.PAGE_START);
        
        
        
        JPanel mainPanel3 = new JPanel();
        BorderLayout mp3Layout = new BorderLayout();
        
        mainPanel3.setLayout(mp3Layout);
        mainPanel2.add(mainPanel3);
        
        JPanel bottomButtons = new JPanel();
        
        JButton backButton = new JButton ("Back");
        
        backButton.addActionListener(barberComplaintController);
        backButton.setActionCommand("back");
        bottomButtons.add(backButton);
        
        mainPanel3.add(bottomButtons, BorderLayout.PAGE_END);
        
        
        JPanel mainPanel4 = new JPanel();
        mainPanel3.add(mainPanel4);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    private void validation(){
        this.validate();
        this.repaint();
    }
    
    
}
