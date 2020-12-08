/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Francisco Leite
 */
public class BarberComplaintController implements ActionListener {
    BarberComplaintScreen view;
    
    public BarberComplaintController(){
        this.view = new BarberComplaintScreen(this);
        showComplaint();
    }
    
    
    
    
    
    
    

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
    
    private void showComplaint(){
        
        BarberComplaintModel model = new BarberComplaintModel();
        
        int amt = model.getAmtOfComplaints(User.getCurrentUser().getUserID());
        
        if(amt>0){
            String [][] complaints = model.getComplaints(User.getCurrentUser().getUserID());
            view.DisplayData(complaints);
        }
        else{
            
        }
        
        
    }
    
    
    
    
    
    
    
}
