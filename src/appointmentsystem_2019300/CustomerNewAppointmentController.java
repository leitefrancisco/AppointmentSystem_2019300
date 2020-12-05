/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Francisco Leite
 */
public class CustomerNewAppointmentController implements ActionListener{
    
    CustomerNewAppointmentScreen customerNewAppointmentScreen;
    
    public CustomerNewAppointmentController (){
        this.customerNewAppointmentScreen = new CustomerNewAppointmentScreen(this);
    }
    
    
    public ComboBoxItem[] getBarbers(){
        CustomerNewAppointmentModel model = new CustomerNewAppointmentModel();
        User [] barbers = model.getBarbers();
        ComboBoxItem [] items = new ComboBoxItem [barbers.length];
        for(int i =0; i<barbers.length; i++){
            items[i] = new ComboBoxItem (barbers[i].getUserID(), barbers[i].getFullName());
        }
        
        return items;
    }
    
    public ComboBoxItem[] getLocationsByBarber(int barberId){
        CustomerNewAppointmentModel model = new CustomerNewAppointmentModel();
        
        ComboBoxItem [] locations = model.getLocations(barberId);
        
        
        return locations;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("back")){
            customerNewAppointmentScreen.dispose();
            new CustomerAdminController();
        }
        else if(e.getActionCommand().equals("logout")){
            if(LogoutController.logout()==0){
                customerNewAppointmentScreen.dispose();
            }
        }
        else if (e.getActionCommand().equals("datab")){
            try {
                Date selectedDate = customerNewAppointmentScreen.getDate();
                CustomerNewAppointmentModel model = new CustomerNewAppointmentModel();
                int barberId = customerNewAppointmentScreen.getBarberId();
                int locationId = customerNewAppointmentScreen.getLocationId();
                String[] freeSlots = model.getFreeSlots(selectedDate, barberId, locationId);
                customerNewAppointmentScreen.showFreeSlots(freeSlots);
                
            } catch (ParseException ex) {
                Logger.getLogger(CustomerNewAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        }
        
        
        
    }
    
    ItemListener AddItemListenerBarbers(JComboBox locationComboBox) {
        
        ItemListener il = new ItemListener (){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    locationComboBox.removeAllItems();
                    
                    ComboBoxItem barber = (ComboBoxItem)e.getItem();
                    
                    ComboBoxItem[] locations = getLocationsByBarber(barber.getId());
                    for(int i =0; i<locations.length;i++){
                        locationComboBox.addItem(locations[i]);
                    }
                    locationComboBox.setEnabled(true);
                    
                }
                
            }
        };
        return il;
    }
    
    ItemListener AddItemListenerLocations() {
        ItemListener il = new ItemListener (){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    ComboBoxItem b = (ComboBoxItem) e.getItem();
                    System.out.println(b);
                }
                
            }
        };
        return il;
    }
    
   
}

