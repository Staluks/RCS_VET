import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

    LogIn loginmeth = new LogIn();
    Registration regmeth = new Registration();
    DocRegistration docRegMeth = new DocRegistration();

    loginmeth.loginWindow();
//      docRegMeth.docRegistrationWindow();
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

    }
}