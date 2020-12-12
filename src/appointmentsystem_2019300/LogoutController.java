package appointmentsystem_2019300;
import javax.swing.JOptionPane;
/**
 *
 * @author Francisco Leite
 */
public class LogoutController {
    //set the user as null and open a new login view
    public static void logout(Window window){
        int a = JOptionPane.showConfirmDialog(null,"Are you sure you wanna exit?","=[",JOptionPane.YES_NO_OPTION);
        if (a == 0)
        {
            window.dispose();
            User.logoff();
            new LoginController();
        }
    }
}
