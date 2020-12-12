package appointmentsystem_2019300;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Francisco Leite
 */
public class CustomerNewAppointmentScreen extends Window{
    private JFormattedTextField dateField;
    CustomerNewAppointmentController controller;
    JList<String> freeSlotsJList;
    JComboBox barberComboBox;
    DefaultListModel slotsModel;
    JComboBox locationComboBox;
     
    //Constructor for the view  
    public CustomerNewAppointmentScreen (CustomerNewAppointmentController controller){
        this.controller = controller;
        showCustomerNewAppointmentScreen();
        validation();
    }
    
    public void showCustomerNewAppointmentScreen(){
        
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
        
        JLabel admpanel = new JLabel("Book Your Appointment");
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
        
        JPanel mainPanel4 = new JPanel();
        mainPanel3.add(mainPanel4);
        
        JLabel selectBarber = new JLabel("Select Barber:");
        mainPanel4.add(selectBarber);
        
        ComboBoxItem[] barbers = controller.getBarbers();
        
    
        barberComboBox = new JComboBox(barbers);
        barberComboBox.setSelectedIndex(0);
        mainPanel4.add(barberComboBox);
       
    
        locationComboBox = new JComboBox();
        mainPanel4.add(locationComboBox);
        locationComboBox.addItemListener(controller.AddItemListenerLocations());
        locationComboBox.setEnabled(false);
        
        barberComboBox.addItemListener(controller.AddItemListenerBarbers(locationComboBox));   
        //https://kodejava.org/how-do-i-use-jformattedtextfield-to-format-user-input/
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        DateFormatter df = new DateFormatter(format);
        
        dateField = new JFormattedTextField(df);
        dateField.setPreferredSize(new Dimension(100, 20));
        dateField.setValue(new Date());
        
        mainPanel4.add(dateField);
        JButton dateB = new JButton ("View Available Time Slots");
        dateB.addActionListener(controller);
        dateB.setActionCommand("datab");
        mainPanel4.add(dateB);
        
        slotsModel = new DefaultListModel<String>();
        freeSlotsJList = new JList(slotsModel); 
        freeSlotsJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        JScrollPane listScroller = new JScrollPane(freeSlotsJList);
        listScroller.setPreferredSize(new Dimension(150, 80));
        mainPanel4.add(listScroller);
        
        JButton confApp = new JButton ("Book Appointment");
        confApp.addActionListener(controller);
        confApp.setActionCommand("confirm");
        mainPanel4.add(confApp);
    }
    
    private void validation(){
        this.validate();
        this.repaint();
    }

    Date getDate() throws ParseException {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        DateFormatter df = new DateFormatter(format);
        String strDate = dateField.getText();
        return format.parse(strDate);
    }

    void showFreeSlots(String[] freeSlots) {
        slotsModel.clear();
        for(int i=0; i< freeSlots.length; i++){
            slotsModel.addElement(freeSlots[i]);
        }
    }

    int getBarberId() {
        return ((ComboBoxItem)barberComboBox.getSelectedItem()).getId();
    }

    int getLocationId() {
        return ((ComboBoxItem)locationComboBox.getSelectedItem()).getId();
    }
    
    String getSelectedTimeAndDate() throws ParseException{
        
        String time = freeSlotsJList.getSelectedValue();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       return format.format(getDate()) + " " + time ;
     
    }
    
    
    
    
    
    
}
