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
public class BarberAdminScreenController implements ActionListener {
    
    BarberAdminScreen view;
    
    public BarberAdminScreenController(){
        this.view = new BarberAdminScreen(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("exitToLogin")){ 
            view.dispose();
            new LoginScreenController();
        }
        
        
        
        
        
    }
    
    
    
}
