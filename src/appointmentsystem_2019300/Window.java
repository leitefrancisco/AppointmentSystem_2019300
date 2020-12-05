/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem_2019300;

import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Francisco Leite
 */
public class Window extends JFrame {

    public Window() throws HeadlessException {
        closeOnX();
    }
    private void closeOnX(){
       this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing (WindowEvent e)
            {
                //caixa de dialogo retorna um inteiro
                int a = JOptionPane.showConfirmDialog(null,"Are you sure you wanna exit?","=[",JOptionPane.YES_NO_OPTION);
                 
                //sim = 0, nao = 1
                if (a == 0)
                {
                    System.exit(0);
                }
                 
            }
        });
   } 
}
