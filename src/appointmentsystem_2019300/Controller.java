package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    View view;
    Model model;
    
    public Controller(){
        
        this.view = new View(this);
        this.model = new Model();  
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        
        
    }
    
   
}
