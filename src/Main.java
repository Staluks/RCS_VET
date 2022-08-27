import db.DBLogic_Clinic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

    LogIn loginmeth = new LogIn();
    Registration regmeth = new Registration();

    loginmeth.loginWindow();

    //to join  the panellogin and panelregistration actionlistener is brought to the main class
        //if user presses create new account a new window will open with the registration form
    loginmeth.regbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginmeth.panellogin.setVisible(false);
                loginmeth.frame.add(regmeth.panelRegistration);
                regmeth.registrationWindow();
            }
        });
    //if user decides to not create new account, user can press button back and return to the login page
    regmeth.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regmeth.panelRegistration.setVisible(false);
                loginmeth.frame.add(loginmeth.panellogin);
                loginmeth.loginWindow();
            }
        });



        DBLogic_Clinic db = new DBLogic_Clinic();
        //db.register("clNameD", "cl4@email.com", "22030408", "cl4LegalAddress", "cl4PhysicalAddress", "cl4RegNumber", "clDUsername", "clDPass");
        //db.login("clDUsername", "clDPass");
        db.getName("clDUsername");

    }
}