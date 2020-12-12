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
public class BarberLocationScreen extends Window {
    
    BarberLocationController controller;
    JPanel mainPanel4;
    //Constructor of the view
    public BarberLocationScreen(BarberLocationController controller){
        this.controller = controller;
        showBarberLocationsScreen();
        validation();
    }
    
    //view properties
    public void showBarberLocationsScreen(){
        
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
        
        JLabel admpanel = new JLabel("Locations");
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
        
        JButton addNewLocation = new JButton("Add New Location.");
        addNewLocation.addActionListener(controller);
        addNewLocation.setActionCommand("addNew");
        topPanelButtons.add(addNewLocation);
    
                
        
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
        
        mainPanel4 = new JPanel();
        JScrollPane jsp = new JScrollPane(mainPanel4);
        mainPanel3.add(jsp);
        
    }
    
    private void validation(){
        this.validate();
        this.repaint();
    }

    //takes the information from the method in the model and is used by the controller to get information about the locations from the database
    void showLocations(BarberLocation[] locations) {
        mainPanel4.setLayout(new GridBagLayout());
        GridBagConstraints gBcon = new GridBagConstraints();
        gBcon.gridwidth = GridBagConstraints.REMAINDER;
        for(int i=0; i< locations.length; i++){
            BarberLocation loc = locations[i];
            
            mainPanel4.add(new JLabel(loc.getLocation()));
            JButton btn = new JButton("Edit");
            btn.addActionListener(controller);
            btn.setActionCommand("edit:"+loc.getLocationId());
            mainPanel4.add(btn);
            
            JButton btn2 = new JButton("Delete");
            btn2.addActionListener(controller);
            btn2.setActionCommand("delete:"+loc.getLocationId());
            mainPanel4.add(btn2, gBcon);
        }
    }
    
}
