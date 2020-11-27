/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package appointmentsystem_2019300;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Francisco Leite
 */
public class BarberFirstLocationScreen extends JFrame {
    
    BarberFirstLocationController barberFirstLocationController;
    private JTextField location;
    private   JCheckBox mon;
    private   JCheckBox tue ;
    private   JCheckBox wed ;
    private   JCheckBox thu ;
    private JCheckBox fri;
    private  JCheckBox sat;
    private JCheckBox sun;
    
    public BarberFirstLocationScreen(BarberFirstLocationController barberFirstLocationController){
        this.barberFirstLocationController = barberFirstLocationController;
        frameSetter();
        showBarberFirstLocationScreen();
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
        location = new JTextField (30);
        ipLeft.add(locLabel);
        ipLeft.add(location);
        
        
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
        
        mon = new JCheckBox("Mon");
        tue = new JCheckBox("Tue");
        wed = new JCheckBox("Wed");
        thu = new JCheckBox("Thu");
        fri = new JCheckBox("Fri");
        sat = new JCheckBox("Sat");
        sun = new JCheckBox("Sun");
        
        
        top2.add(mon);
        top2.add(tue);
        top2.add(wed);
        top2.add(thu);
        top2.add(fri);
        top2.add(sat);
        top2.add(sun);
        
        JPanel npan2 = new JPanel();
        BorderLayout np2Layout = new BorderLayout();
        npan2.setLayout(np2Layout);
        npan1.add(npan2);
        
        JPanel top3 = new JPanel();
        npan2.add(top3, BorderLayout.PAGE_START);
        
//        JLabel time = new JLabel("Choose the times you will be available at this location:");
//        top3.add(time);
        
        JPanel npan3 = new JPanel();
        
        npan2.add(npan3);
    
//        JCheckBox[] a = new JCheckBox[4];
//        int hora = 8;
//        for(int i = 0; i<4; i++){
//            a[i] = new JCheckBox("0"+(hora+i)+":00");    
// ctrl + /  >> comment        
//        }
        
//        JCheckBox time8am = new JCheckBox("08:00AM");
//        JCheckBox time9am = new JCheckBox("09:00AM");
//        JCheckBox time10am = new JCheckBox("10:00AM");
//        JCheckBox time11am = new JCheckBox("11:00AM");
//        JCheckBox time12pm = new JCheckBox("12:00PM");
//        JCheckBox time1pm = new JCheckBox("01:00PM");
//        JCheckBox time2pm = new JCheckBox("02:00PM");
//        JCheckBox time3pm = new JCheckBox("03:00PM");
//        JCheckBox time4pm = new JCheckBox("04:00PM");
//        JCheckBox time5pm = new JCheckBox("05:00PM");
//        JCheckBox time6pm = new JCheckBox("06:00PM");
//        JCheckBox time7pm = new JCheckBox("07:00PM");
//        JCheckBox time8pm = new JCheckBox("08:00PM");
//        JCheckBox time9pm = new JCheckBox("09:00PM");
//        JCheckBox time10pm = new JCheckBox("10:00PM");
//        JCheckBox time11pm = new JCheckBox("11:00PM");
//        JCheckBox time00am = new JCheckBox("00:00AM");
//        JCheckBox time1am = new JCheckBox("01:00AM");
//        JCheckBox time2am = new JCheckBox("02:00AM");
//        JCheckBox time3am = new JCheckBox("03:00AM");
//        JCheckBox time4am = new JCheckBox("04:00AM");
//        JCheckBox time5am = new JCheckBox("05:00AM");
//        JCheckBox time6am = new JCheckBox("06:00AM");
//        JCheckBox time7am = new JCheckBox("07:00AM");
        
//        npan3.add(time8am);
//        npan3.add(time9am);
//        npan3.add(time10am);
//        npan3.add(time11am);
//        npan3.add(time12pm);
//        npan3.add(time1pm);
//        npan3.add(time2pm);
//        npan3.add(time3pm);
//        npan3.add(time4pm);
//        npan3.add(time5pm);
//        npan3.add(time6pm);
//        npan3.add(time7pm);
//        npan3.add(time8pm);
//        npan3.add(time9pm);
//        npan3.add(time10pm);
//        npan3.add(time11pm);
//        npan3.add(time00am);
//        npan3.add(time1am);
//        npan3.add(time2am);
//        npan3.add(time3am);
//        npan3.add(time4am);
//        npan3.add(time5am);
//        npan3.add(time6am);
//        npan3.add(time7am);
//
//        String [] mon = {"Mon","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"};
//        JList monl = new JList(mon); //data has type Object[]
//        monl.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//
//        JScrollPane listScroller = new JScrollPane(monl);
//        listScroller.setPreferredSize(new Dimension(50,210));
//        npan3.add(listScroller);
//
//        String [] tue = {"Tue","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"};
//        JList tuel = new JList(tue); //data has type Object[]
//        tuel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//
//        JScrollPane tueScroller = new JScrollPane(tuel);
//        tueScroller.setPreferredSize(new Dimension(50,210));
//        npan3.add(tueScroller);
//
//        String [] wed = {"Wed","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"};
//        JList wedl = new JList(wed); //data has type Object[]
//        wedl.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//
//        JScrollPane wedScroller = new JScrollPane(wedl);
//        wedScroller.setPreferredSize(new Dimension(50,210));
//        npan3.add(wedScroller);
        
        
        
        
        
        
        
        
        
        
        
        JPanel bottomButtons = new JPanel();
        JButton backButton = new JButton ("Back");
        backButton.addActionListener(barberFirstLocationController);
        backButton.setActionCommand("back");
        bottomButtons.add(backButton);
        mainPanel2.add(bottomButtons, BorderLayout.PAGE_END);
        JButton confLocation = new JButton("Confirm Location");
        confLocation.addActionListener(barberFirstLocationController);
        confLocation.setActionCommand("confLocation");
        bottomButtons.add(confLocation);
        
    }
    private void validation(){
        this.validate();
        this.repaint();
    }
    
    public String getBarberLocation(){
        return location.getText();
    }
    
    public boolean checkMon(){
        return mon.isSelected();
    }
    public boolean checkTue(){
        return tue.isSelected();
    }
    public boolean checkWed(){
        return wed.isSelected();
    }
    public boolean checkThu(){
        return thu.isSelected();
    }
    public boolean checkFri(){
        return fri.isSelected();
    }
    public boolean checkSat(){
        return sat.isSelected();
    }
    public boolean checkSun(){
     
        return sun.isSelected();
        
    }
    
    
    
    
}
