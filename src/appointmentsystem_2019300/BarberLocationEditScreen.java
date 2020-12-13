package appointmentsystem_2019300;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Francisco Leite
 */
public class BarberLocationEditScreen extends Window {
    
    BarberLocationEditController controller;
    private JTextField locationTextField;
    private JCheckBox monChkBox;
    private JCheckBox tueChkBox;
    private JCheckBox wedChkBox;
    private JCheckBox thuChkBox;
    private JCheckBox friChkBox;
    private JCheckBox satChkBox;
    private JCheckBox sunChkBox;
    //Constructor of the view witht a controller
    public BarberLocationEditScreen(BarberLocationEditController barberFirstLocationController){
        this.controller = barberFirstLocationController;
        showBarberFirstLocationScreen();
        validation();
    }
    //properties of the view
    public void showBarberFirstLocationScreen(){
        
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
        
        JPanel infoPanel = new JPanel ();
        GridLayout ipLayout = new GridLayout (1,2);
        infoPanel.setLayout(ipLayout);
        mainPanel2.add(infoPanel, BorderLayout.CENTER);
        
        JPanel ipLeft = new JPanel();
        ipLeft.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        infoPanel.add(ipLeft);
        JLabel locLabel = new JLabel("Please insert one location you are going to be working:");
        locationTextField = new JTextField (30);
        ipLeft.add(locLabel);
        ipLeft.add(locationTextField);
        
        
        JPanel ipRight = new JPanel();
        BorderLayout irLayout = new BorderLayout();
        ipRight.setLayout(irLayout);
        ipRight.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        infoPanel.add(ipRight, BorderLayout.PAGE_START);
        
        JPanel top1 = new JPanel();
        ipRight.add(top1, BorderLayout.PAGE_START);
        JLabel days = new JLabel("Please select the days you will be available:");
        top1.add(days);
        
        JPanel npan1 = new JPanel();
        BorderLayout npLayout = new BorderLayout();
        npan1.setLayout(npLayout);
        ipRight.add(npan1);
        
        
        JPanel top2 = new JPanel();
        npan1.add(top2, BorderLayout.PAGE_START);
        
        monChkBox = new JCheckBox("Mon");
        tueChkBox = new JCheckBox("Tue");
        wedChkBox = new JCheckBox("Wed");
        thuChkBox = new JCheckBox("Thu");
        friChkBox = new JCheckBox("Fri");
        satChkBox = new JCheckBox("Sat");
        sunChkBox = new JCheckBox("Sun");
        
        
        top2.add(monChkBox);
        top2.add(tueChkBox);
        top2.add(wedChkBox);
        top2.add(thuChkBox);
        top2.add(friChkBox);
        top2.add(satChkBox);
        top2.add(sunChkBox);
        
        JPanel npan2 = new JPanel();
        BorderLayout np2Layout = new BorderLayout();
        npan2.setLayout(np2Layout);
        npan1.add(npan2);
        
        JPanel top3 = new JPanel();
        npan2.add(top3, BorderLayout.PAGE_START);
        
        
        JPanel npan3 = new JPanel();
        
        npan2.add(npan3);
 
        JPanel bottomButtons = new JPanel();
        JButton backButton = new JButton ("Back");
        backButton.addActionListener(controller);
        backButton.setActionCommand("back");
        bottomButtons.add(backButton);
        mainPanel2.add(bottomButtons, BorderLayout.PAGE_END);
        JButton confLocation = new JButton("Confirm Location");
        confLocation.addActionListener(controller);
        confLocation.setActionCommand("confLocation");
        bottomButtons.add(confLocation);
        
    }
    private void validation(){
        this.validate();
        this.repaint();
    }
    
    public String getBarberLocation(){
        return locationTextField.getText();
    }
    
    public boolean checkMon(){
        return monChkBox.isSelected();
    }
    
    public boolean checkTue(){
        return tueChkBox.isSelected();
    }
    
    public boolean checkWed(){
        return wedChkBox.isSelected();
    }
    
    public boolean checkThu(){
        return thuChkBox.isSelected();
    }
    
    public boolean checkFri(){
        return friChkBox.isSelected();
    }
    
    public boolean checkSat(){
        return satChkBox.isSelected();
    }
    
    public boolean checkSun(){     
        return sunChkBox.isSelected();
        
    }

    void showExistingData(BarberLocationEditModel model) {
        locationTextField.setText(model.getLocation());
        monChkBox.setSelected(model.isWorksMon());
        tueChkBox.setSelected(model.isWorksTue());
        wedChkBox.setSelected(model.isWorksWed());
        thuChkBox.setSelected(model.isWorksThu());
        friChkBox.setSelected(model.isWorksFri());
        satChkBox.setSelected(model.isWorksSat());
        sunChkBox.setSelected(model.isWorksSun());
    }
}
