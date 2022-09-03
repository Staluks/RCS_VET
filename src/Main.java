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
    DocRegistration doc = new DocRegistration();
    DocRegValidation docReg = new DocRegValidation();
    ClinicDashBoard clDash = new ClinicDashBoard();

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
        doc.submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(docReg.docRegVal(doc.docNameText.getText(), doc.docSurnameText.getText(), doc.usernameText.getText(), doc.passwordText.getText(), doc.reppasswordText.getText(), doc.personalCodeText.getText(), doc.certificateText.getText())){
                doc.errorMessage.setText("registration successful");
                doc.panelDocRegistration.setVisible(false);
                loginmeth.frame.add(clDash.panelClinicDashB);
                clDash.clinicDash();
            }else{
                doc.errorMessage.setText("Text fields are filled wrong");
            }
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