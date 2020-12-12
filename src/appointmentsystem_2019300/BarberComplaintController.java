package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarberComplaintController implements ActionListener {
    BarberComplaintScreen view;
    //Constructor of the Controller 
    public BarberComplaintController(){
        this.view = new BarberComplaintScreen(this);
        showComplaint();
    }
    //method to get information from the method of the model that gets the complaints of the data base
    private void showComplaint(){
        
        BarberComplaintModel model = new BarberComplaintModel();
        
        int amt = model.getAmtOfComplaints(User.getCurrentUser().getUserID());
        
        if(amt>0){
            String [][] complaints = model.getComplaints(User.getCurrentUser().getUserID());
            view.DisplayData(complaints);
        }
    }
    //Instructions for each button in the view.
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("back")){
            view.dispose();
            new BarberAdminController();
        }
        else if(e.getActionCommand().equals("logout")){
            LogoutController.logout(view);
        } 
    }
    
    
    
    
    
    
    
    
    
}
