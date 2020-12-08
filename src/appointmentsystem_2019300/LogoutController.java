/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package appointmentsystem_2019300;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Francisco Leite
 */
public class LogoutController implements ActionListener{
    
    
    
    
    public static int logout(Window window){
        int a = JOptionPane.showConfirmDialog(null,"Are you sure you wanna exit?","=[",JOptionPane.YES_NO_OPTION);
        
        //sim = 0, nao = 1
        if (a == 0)
        {
            window.dispose();
            User.Logoff();
            new LoginController();
        }
        
        return a;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
