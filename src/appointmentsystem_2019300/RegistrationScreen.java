
package appointmentsystem_2019300;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegistrationScreen extends Window {
   
    JTextField firstName;
    JTextField lastName;
    JTextField email;
    JPasswordField password;
    JPasswordField confPassword;
    RegistrationController registrationScreenController;
    ButtonGroup cOrb;
    JRadioButton CustomerButton;
    JRadioButton BarberButton;
    //Constructor for the Registration Screen
    public RegistrationScreen(RegistrationController registrationScreenController){
        
        this.registrationScreenController =  registrationScreenController;
        showRegistrationScreen();
        validation();
    }
    
    private void validation(){
        this.validate();
        this.repaint();
    }
    //Properties of the view
    private void showRegistrationScreen(){
        
        firstName = new JTextField(15);
        lastName = new JTextField(15);
        email = new JTextField(20);
        password = new JPasswordField(20);
        confPassword = new JPasswordField(20);
        
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
        titleReg.add(new JLabel("Registration"));
        
        JPanel fieldsPanel = new JPanel();
        GridLayout fPLayout = new GridLayout(2,1);
        fieldsPanel.setLayout(fPLayout);
        mainPanel.add(fieldsPanel);
        
        JPanel spacePanel = new JPanel();
        GridLayout sPLayout = new GridLayout(2,1);
        spacePanel.setLayout(sPLayout);
        fieldsPanel.add(spacePanel);
        
        
        JPanel customerOrBarber = new JPanel();
        spacePanel.add(customerOrBarber);
//        customerOrBarber.setBackground(Color.red);
        JLabel cOb = new JLabel("Are you a customer or a barber?");
        customerOrBarber.add(cOb);
        
        String [] cB = {"Customer","Barber"};
        
        CustomerButton = new JRadioButton(cB[0]);
        CustomerButton.setSelected(true);
        BarberButton = new JRadioButton(cB[1]);
        
        cOrb = new ButtonGroup();
        cOrb.add(CustomerButton);
        cOrb.add(BarberButton);
        
        customerOrBarber.add(CustomerButton);
        customerOrBarber.add(BarberButton);
        
        
        
        
        JPanel formPanel = new JPanel ();
        GridLayout formPLayout = new GridLayout (3,1);
        formPanel.setLayout(formPLayout);
        spacePanel.add(formPanel);
        
        formPanel.add(nameLabel);
        formPanel.add(firstName);
        formPanel.add(lastNameLabel);
        formPanel.add(lastName);
        formPanel.add(passwordLabel);
        formPanel.add(password);
        
        formPanel.add(confPasswordLabel);
        formPanel.add(confPassword);
        formPanel.add(emailLabel);
        formPanel.add(email);
        
        JPanel bottomPanel = new JPanel();
        BorderLayout bpLayout = new BorderLayout();
        bottomPanel.setLayout(bpLayout);
        fieldsPanel.add(bottomPanel);
        
        JPanel bottomButtonsPanel = new JPanel();
        bottomPanel.add(bottomButtonsPanel, BorderLayout.SOUTH);
        JButton backButton = new JButton ("Back");
        backButton.addActionListener(registrationScreenController);
        backButton.setActionCommand("back");
        
        JButton ConfirmRegButton = new JButton ("Confirm Registration");
        ConfirmRegButton.addActionListener(registrationScreenController);
        ConfirmRegButton.setActionCommand("confReg");
     
        
        bottomButtonsPanel.add(backButton);
        
        bottomButtonsPanel.add(ConfirmRegButton);
        
    }   
    //returns the content of the jtextfield
    public String getFirstName(){
        return firstName.getText();
    }
    //returns the content of the jtextfield   
    public String getLastName(){
        return lastName.getText();
    }
    //returns the content of the jtextfield
    public String getEmail(){
        return email.getText();
    }
    //returns the content of the jtextfield
    public String getPassword(){
        
        return  String.valueOf(password.getPassword());
    }
    //returns the content of the jtextfield
    public String getPasswordConfirmation(){
        return String.valueOf(confPassword.getPassword());
    }
    //returns the type of user (customer or barber ) based on the selected radio button 
    public char getUserType(){
       if(BarberButton.isSelected())
           return 'b';
       else 
           return 'c';
    }    
}
