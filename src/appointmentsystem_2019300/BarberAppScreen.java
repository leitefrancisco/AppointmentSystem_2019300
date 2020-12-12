package appointmentsystem_2019300;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


class BarberAppScreen extends Window {
    BarberAppController controller;
    JTable complaintTable;
    JPanel mainPanel3;
    //constructor for the Screen
    public BarberAppScreen(BarberAppController barberAppController){
        this.controller = barberAppController;
        showComplaintsBarberScreen();
        validation();
    }
    //view properties
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
        
        
        
        mainPanel3 = new JPanel();
        BorderLayout mp3Layout = new BorderLayout();
        
        mainPanel3.setLayout(mp3Layout);
        mainPanel2.add(mainPanel3);
        
        JPanel bottomButtons = new JPanel();
        
        JButton backButton = new JButton ("Back");
        
        backButton.addActionListener(controller);
        backButton.setActionCommand("back");
        bottomButtons.add(backButton);
        mainPanel3.add(bottomButtons, BorderLayout.PAGE_END);
 
        
    }
   
    private void validation(){
        this.validate();
        this.repaint();
    }
    //Creates the table and adds to the panel of the view
    public void DisplayData(String [][] data){
        
        String [] columns = {"Custmer Name","Customer Email","Appointment Date","Time","Status"};
        JTable complaintsTable= new JTable(data, columns);
        JScrollPane sp = new JScrollPane(complaintsTable);
        mainPanel3.add(sp);        
    }
}