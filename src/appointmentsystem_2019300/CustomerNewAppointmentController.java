package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco Leite
 */
public class CustomerNewAppointmentController implements ActionListener{
    
    CustomerNewAppointmentScreen view;
    
    public CustomerNewAppointmentController (){
        this.view = new CustomerNewAppointmentScreen(this);
    }
    
    
    public static ComboBoxItem[] getBarbers(){
        CustomerNewAppointmentModel model = new CustomerNewAppointmentModel();
        User [] barbers = model.getBarbers();
        ComboBoxItem [] items = new ComboBoxItem [barbers.length];
        for(int i = 0; i<barbers.length; i++){
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
            view.dispose();
            new CustomerAdminController();
        }
        else if(e.getActionCommand().equals("logout")){
            LogoutController.logout(view);
            
        }
        else if (e.getActionCommand().equals("datab")){
            if(view.getBarberId()!= -1){
                
                
                try {
                    Date selectedDate = view.getDate();
                    CustomerNewAppointmentModel model = new CustomerNewAppointmentModel();
                    int barberId = view.getBarberId();
                    int locationId = view.getLocationId();
                    String[] freeSlots = model.getFreeSlots(selectedDate, barberId, locationId);
                    view.showFreeSlots(freeSlots);
                    
                } catch (ParseException ex) {
                    Logger.getLogger(CustomerNewAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
        
        
        else if(e.getActionCommand().equals("confirm")){
            
            int a = JOptionPane.showConfirmDialog(null,"Book this appointment?","=[",JOptionPane.YES_NO_OPTION);
            if (a == 0)
            {
                CustomerNewAppointmentModel model = new CustomerNewAppointmentModel();
                try {
                    model.writeAppointment(view.getSelectedTimeAndDate(),
                            view.getBarberId(),
                            User.getCurrentUser().getUserID(),
                            view.getLocationId() );
                    JOptionPane.showMessageDialog(view, "Booked! wait for the Barber to Accept your appoint,\n check the status at Welcome Screen");
                    view.dispose();
                    new CustomerAdminController();
                } catch (ParseException ex) {
                    Logger.getLogger(CustomerNewAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
                }}
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
                }
                
            }
        };
        return il;
    }
    
   
}

