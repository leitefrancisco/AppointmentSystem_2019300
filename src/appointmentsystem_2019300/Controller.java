package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    //RegistrationScreenCustomer registrationScreenCustomer;
    
    Model model;
    LoginScreen loginScreen;
    RegistrationScreen registrationScreenBarber;
    BarberAdminScreen barberAdminScreen;
    BarberLocationsScreen barberLocationsScreen;
    BarberAppointmentScreen appointmentScreenBarber;
    BarberComplaintsScreen complaintsBarberScreen;
    CustomerAdminScreen customerAdminScreen;
    
    public Controller(){
        //this.registrationScreenCustomer = new RegistrationScreenCustomer(this);
//        this.model = new Model();
//        this.loginScreen = new LoginScreen(this);
//        this.registrationScreenBarber = new RegistrationScreenBarber(this);
//        this.barberAdminScreen = new BarberAdminScreen(this);
//        this.barberLocationsScreen = new BarberLocationsScreen(this);
//        this.appointmentScreenBarber = new AppointmentScreenBarber(this);
//        this.complaintsBarberScreen = new ComplaintsBarberScreen(this);
        this.customerAdminScreen = new CustomerAdminScreen(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("login")){
            
            String un = loginScreen.getUName();
            String up = loginScreen.getUPassword();
            
            User user = new User(un, up);
            
            boolean result = model.login(user);
            
            if(result){
                System.out.println("you are in");
                
            }
            else{
                System.out.println("you are out");
            }
        }
        if(e.getActionCommand().equals("newUser")){
            
        }
        
        
    }
    
    
}
