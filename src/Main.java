import db.DBLogic_Clinic;
import db.DBLogic_Doctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        LogIn loginmeth = new LogIn();
        Registration regmeth = new Registration();
        ClinicDashBoard clindashb = new ClinicDashBoard();
        DoctorDashBoard docdashb = new DoctorDashBoard();
        DocRegistration docreg = new DocRegistration();
        DBLogic_Clinic dbClinic = new DBLogic_Clinic();




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
                    //todo backend validation - if true
//                    try {
//                        int a = dbClinic.getClinicId(loginmeth.userText.getText(), loginmeth.passwordText.getText());
//                        //if (a = -1)
//                    }catch (SQLException a){
//                        a.printStackTrace();
//                    }
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



        //DBLogic_Clinic dbClinic = new DBLogic_Clinic();
        //boolean s = dbClinic.register("clNameE", "cl5@email.com", "22030409", "cl5LegalAddress", "cl5PhysicalAddress", "cl5RegNumber", "clEUsername", "clEPass");
        //System.out.println(s);
        //int clinicId = dbClinic.getClinicId("clDUsername", "clDPass");
        //dbClinic.getName("clDUsername");
        //dbClinic.isUsernameUnique("clDUsername");

        //DBLogic_Doctor dbDoctor = new DBLogic_Doctor();
        //boolean b = dbDoctor.register("NameD3", "SurnameD3", "usernameD3", "passwordD3", "333333-33333", "CER333", "4", "active");
        //System.out.println();
        //int id = dbDoctor.getDoctorId("usernameD2", "passwordD3");
        //System.out.println(id);
        //System.out.println(dbDoctor.getName("usernameD3"));
        //ArrayList<String> list = dbDoctor.getDoctorList("4");
        //for (String s : list) {
        //    System.out.println(s);


    }
}