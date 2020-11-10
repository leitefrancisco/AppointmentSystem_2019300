package appointmentsystem_2019300;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistrationScreenCustomer extends JFrame {
    
    Controller controller;
    JTextField firstNameCustomer;
    JTextField lastNameCustomer;
    JTextField emailCustomer;
    JPasswordField passwordCustomer;
    JPasswordField confPasswordCustomer;
    
    
    
    public RegistrationScreenCustomer(Controller controller){
        
        this.controller =  controller;
        frameSetter();
        showRegistrationScreenCustomer();
        validation();
    }
    
    private void frameSetter(){
        this.setVisible(true);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Barbershop");
        this.setVisible(true);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Barbershop");
        BorderLayout frameLayout = new BorderLayout();
        this.setLayout(frameLayout);
        //head
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(topPanel, BorderLayout.PAGE_START);
        JLabel barberShop = new JLabel("Barber Shop") ;
        topPanel.add(barberShop);
    }
    
    private void validation(){
        this.validate();
        this.repaint();
    }
    
    private void showRegistrationScreenCustomer(){
        
        firstNameCustomer = new JTextField(15);
        lastNameCustomer = new JTextField(15);
        emailCustomer = new JTextField(20);
        passwordCustomer = new JPasswordField(20);
        confPasswordCustomer = new JPasswordField(20);
        
        JLabel nameLabel = new JLabel ("Name:");
        JLabel lastNameLabel = new JLabel ("Last Name:");
        JLabel emailLabel = new JLabel ("Email:");
        JLabel passwordLabel = new JLabel ("Password:");
        JLabel confPasswordLabel = new JLabel ("Confirm Password:");
        
        JPanel mainPanel = new JPanel();
        BorderLayout mPLayout = new BorderLayout();
        mainPanel.setLayout(mPLayout);
        this.add(mainPanel);
        
        JPanel titleReg = new JPanel();
        mainPanel.add(titleReg, BorderLayout.NORTH);
        titleReg.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        titleReg.add(new JLabel("Customer Registration"));
        
        JPanel fieldsPanel = new JPanel();
        GridLayout fPLayout = new GridLayout(2,1);
        fieldsPanel.setLayout(fPLayout);
        mainPanel.add(fieldsPanel);
        
        JPanel spacePanel = new JPanel();
        GridLayout sPLayout = new GridLayout(2,1);
        spacePanel.setLayout(sPLayout);
        fieldsPanel.add(spacePanel);
        
        JPanel spacePanel2 = new JPanel();
        spacePanel.add(spacePanel2);
        
        JPanel formPanel = new JPanel ();
        GridLayout formPLayout = new GridLayout (3,1);
        formPanel.setLayout(formPLayout);
        spacePanel.add(formPanel);
        
        formPanel.add(nameLabel);
        formPanel.add(firstNameCustomer);
        formPanel.add(passwordLabel);
        formPanel.add(passwordCustomer);
        formPanel.add(lastNameLabel);
        formPanel.add(lastNameCustomer);
        formPanel.add(confPasswordLabel);
        formPanel.add(confPasswordCustomer);
        formPanel.add(emailLabel);
        formPanel.add(emailCustomer);
        
        JPanel bottomPanel = new JPanel();
        BorderLayout bpLayout = new BorderLayout();
        bottomPanel.setLayout(bpLayout);
        fieldsPanel.add(bottomPanel);
        
        JPanel bottomButtonsPanel = new JPanel();
        bottomPanel.add(bottomButtonsPanel, BorderLayout.SOUTH);
        JButton backButton = new JButton ("Back");
        JButton ConfirmRegButton = new JButton ("Confirm Registration");
        
        
        bottomButtonsPanel.add(backButton);
        bottomButtonsPanel.add(ConfirmRegButton);
 
    }
    
    
    
    
}
