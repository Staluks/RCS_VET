import com.sun.source.tree.NewArrayTree;
import db.DBLogic_Clinic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

    LogIn loginmeth = new LogIn();
    Registration regmeth = new Registration();
    ClinicDashBoard clindashb = new ClinicDashBoard();
    DocRegistration docreg = new DocRegistration();
    DoctorDashBoard docdashb = new DoctorDashBoard();


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
// todo add validation for login text fields
    loginmeth.loginbut.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (loginmeth.clinic.isSelected()) {
                loginmeth.panellogin.setVisible(false);
                loginmeth.frame.add(clindashb.panelClinicDashB);
                clindashb.clinicDash();
            } if (loginmeth.doctor.isSelected()){
                loginmeth.panellogin.setVisible(false);
                loginmeth.frame.add(docdashb.panelDoctorDashB);
                docdashb.doctorDash();
            }
        }
    });
    //to return to the log in window user can pres log out button
    clindashb.logout.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            clindashb.panelClinicDashB.setVisible(false);
            loginmeth.frame.add(loginmeth.panellogin);
            loginmeth.loginWindow();
        }
    });
    //when loged in as clinic, by pressing add new doctor, a registration form will open
    clindashb.addNewDoc.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            clindashb.panelClinicDashB.setVisible(false);
            loginmeth.frame.add(docreg.panelDocRegistration);
            docreg.docRegistrationWindow();
        }
    });
    //in doctor reg form, by  pressing back, user returns to clinic dash board
    docreg.back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            docreg.panelDocRegistration.setVisible(false);
            loginmeth.frame.add(clindashb.panelClinicDashB);
            clindashb.clinicDash();
        }
    });
    //user can log out from doctor dash board if preses log out button
docdashb.logout.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       docdashb.panelDoctorDashB.setVisible(false);
        loginmeth.frame.add(loginmeth.panellogin);
        loginmeth.loginWindow();
    }
});


        //DBLogic_Clinic db = new DBLogic_Clinic();
        //db.register("clNameD", "cl4@email.com", "22030408", "cl4LegalAddress", "cl4PhysicalAddress", "cl4RegNumber", "clDUsername", "clDPass");
        //db.login("clDUsername", "clDPass");
        //db.getName("clDUsername");

    }
}