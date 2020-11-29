package appointmentsystem_2019300;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class LoginScreen extends JFrame {
    
    LoginController loginScreenController;
    private JTextField uName;
    private JTextField uPassword;
    
    public LoginScreen(LoginController controller){
        closeOnX();
        this.loginScreenController =  controller;
        frameSetter();
        showLoginScreen();
        
        validation();
    }
    
    private void frameSetter(){
        
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
    // Creates the Login Panel with the "New User" Option
    private void showLoginScreen(){
        
        //Makes left and right Panel
        JPanel mainCenterPanel = new JPanel();
        GridLayout mainCenterPanelLayout = new GridLayout(1,2);
        mainCenterPanel.setLayout(mainCenterPanelLayout);
        
        this.add(mainCenterPanel);
        //Login Panel(Left Panel)
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
        JLabel uNameLabel = new JLabel ("Email:        ");
        uName = new JTextField(15);
        uNamePanel.add(uNameLabel);
        uNamePanel.add(uName);
        item2.add(uNamePanel);
        
        JPanel uPasswordPanel = new JPanel();
        JLabel uPasswordLabel = new JLabel ("Password:");
        uPassword = new JPasswordField(15);
        uPasswordPanel.add(uPasswordLabel);
        uPasswordPanel.add(uPassword);
        item2.add(uPasswordPanel);
        
        JPanel lButtonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(loginScreenController);
        loginButton.setActionCommand("login");
        lButtonPanel.add(loginButton);
        item2.add(lButtonPanel);
        
        
        centerLogin.add(item2);
        //New user Panel (Right panel)
        
        JPanel newUserPanel = new JPanel();
        mainCenterPanel.add(newUserPanel);
        GridLayout nUPanelLayout = new GridLayout(3,1);
        newUserPanel.setLayout(nUPanelLayout);
        //Blank Panel to Give space
        JPanel blankPanel = new JPanel();
        newUserPanel.add(blankPanel);
        
        JPanel centerNewUser = new JPanel();
        GridLayout cnUserLayout = new GridLayout(3,1);
        centerNewUser.setLayout(cnUserLayout);
        newUserPanel.add(centerNewUser);
        
        JPanel newUserMsg = new JPanel();
        FlowLayout nuMsgLayout = new FlowLayout();
        JLabel messageNewUser = new JLabel("Don't have an account? Create one here!");
        newUserMsg.add(messageNewUser);
        newUserMsg.setLayout(nuMsgLayout);
        centerNewUser.add(newUserMsg);
        
        
        JPanel newUserButtonPanel = new JPanel();
        centerNewUser.add(newUserButtonPanel);
        JButton nUserButton = new JButton("New User");
        nUserButton.addActionListener(loginScreenController);
        nUserButton.setActionCommand("newUser");
        newUserButtonPanel.add(nUserButton);
        
        
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
    
    public String getUName(){
        return uName.getText();
    }
    
    public String getUPassword(){
        return uPassword.getText();
    }
    
    
    
    
    
}
