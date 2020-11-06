package appointmentsystem_2019300;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame {
    
    Controller controller;
    private JTextField uName;
    private JTextField uPassword;
    
    public View(Controller controller){
        
        this.controller =  controller;
        frameSetter();
        loginScreen();
        
        validation();
    }
    
    private void frameSetter(){
        this.setVisible(true);
        this.setSize(800,500);
        this.setTitle("Barbershop");
        
    }
    
    
    private void validation(){
        this.validate();
        this.repaint();
    }
    
    private void loginScreen(){
        BorderLayout frameLayout = new BorderLayout();
        this.setLayout(frameLayout);
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        this.add(topPanel, BorderLayout.PAGE_START);
        
        JLabel barberShop = new JLabel("Barber Shop") ;
        topPanel.add(barberShop);
        
        JPanel mainCenterPanel = new JPanel();
        GridLayout mainCenterPanelLayout = new GridLayout(1,2);
        mainCenterPanel.setLayout(mainCenterPanelLayout);
        
        this.add(mainCenterPanel);
        
        
        
        
        JPanel loginPanel = new JPanel();
        BorderLayout lpLayout = new BorderLayout();
        loginPanel.setLayout(lpLayout);
        

        mainCenterPanel.add(loginPanel);
        
        JPanel centerLogin = new JPanel();
        GridLayout clLayout = new GridLayout (3,1);
        centerLogin.setLayout(clLayout);
        loginPanel.add(centerLogin);
        
        JPanel item1 = new JPanel();
        BorderLayout item1Layout = new BorderLayout();
        item1.setLayout(item1Layout);
        centerLogin.add(item1);
        
        
        JPanel bLoginPanel = new JPanel();
        

        item1.add(bLoginPanel, BorderLayout.PAGE_END);
        JLabel logLabel = new JLabel("Login!");
        bLoginPanel.add(logLabel);
        
    
        
        
        
        
        
        
        JPanel item2 = new JPanel();
        GridLayout item2Layout = new GridLayout(3,1);
        item2.setLayout(item2Layout);
        
        
        
        
        JPanel uNamePanel = new JPanel();
        JLabel uNameLabel = new JLabel ("User Name:");
        uName = new JTextField(15);
        uNamePanel.add(uNameLabel);
        uNamePanel.add(uName);
        item2.add(uNamePanel);
        
        JPanel uPasswordPanel = new JPanel();
        JLabel uPasswordLabel = new JLabel ("Password:");
        uPassword = new JTextField(15);
        uPasswordPanel.add(uPasswordLabel);
        uPasswordPanel.add(uPassword);
        item2.add(uPasswordPanel);
        
        JPanel lButtonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(controller);
        lButtonPanel.add(loginButton);
        item2.add(lButtonPanel);
        
        
        centerLogin.add(item2);
        
        
        
        
        

        JPanel newUserPanel = new JPanel();
        
        
        
        mainCenterPanel.add(newUserPanel);
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
}
