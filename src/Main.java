import Validation.Validation_DoctorRegistration;
import Validation.Validation_LogIn;
import Windows.*;
import db.DBLogic_Clinic;
import db.DBLogic_Doctor;
import db.DBLogic_MedicalHistory;
import db.DBLogic_Patient;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        LogIn loginmeth = new LogIn();
        Registration regmeth = new Registration();
        ClinicDashboard clindashb = new ClinicDashboard();
        DoctorDashboard docdashb = new DoctorDashboard();
        DoctorRegistration docreg = new DoctorRegistration();
        DBLogic_Clinic dbClinic = new DBLogic_Clinic();
        DBLogic_Doctor dbDoctor = new DBLogic_Doctor();
        DBLogic_Patient dbPatient = new DBLogic_Patient();
        DBLogic_MedicalHistory dbMedHistory = new DBLogic_MedicalHistory();
        Validation_DoctorRegistration docRegVal = new Validation_DoctorRegistration();
        EditDoctorRegistration editDoc = new EditDoctorRegistration();
        Validation_LogIn logInVal = new Validation_LogIn();
        PatientRegistration patReg = new PatientRegistration();
        NewMedicalHistory medHisWin = new NewMedicalHistory();
        JTable allPatient = new JTable();





        loginmeth.logInWindow();

        // to join  the panellogin and panelregistration actionlistener is brought to the main class
        // if user presses create new account a new window will open with the registration form
        loginmeth.regbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginmeth.panelLogIn.setVisible(false);
                loginmeth.frame.add(regmeth.panelRegistration);
                regmeth.registrationWindow();
            }
        });

        // if user decides to not create new account, user can press button back and return to the login page
        regmeth.submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String name = regmeth.clinicNameText.getText();
                    String email = regmeth.emailText.getText();
                    String phone =regmeth.phoneText.getText();
                    String adress = regmeth.adresText.getText();
                    String regNumber = regmeth.regNumberText.getText();
                    String regAdress = regmeth.regaddressText.getText();
                    String username = regmeth.usernameText.getText();
                    String password = regmeth.passwordText.getText();
                    if (dbClinic.register(name, email, phone, adress, regAdress, regNumber, username, password)){
                        regmeth.panelRegistration.setVisible(false);
                        loginmeth.frame.add(clindashb.panelClinicDashboard);
                        clindashb.panelClinicDashboard.setVisible(true);
                        clindashb.clinicDashboardWindow();
                        // get clinic id by login username and password
                        Integer clinicId = dbClinic.getClinicId(loginmeth.userText.getText(), loginmeth.passwordText.getText());
                        clindashb.clinName.setText("Welcome " + name);
                        // get doctor list in clinic dashboard
                        ArrayList<String> doctorList = dbDoctor.getDoctorList(clinicId);
                        for (String s : doctorList) {
                            // when clinic dashboard opens a list of all associated doctors will appear
                            JList alldoctors = new JList(doctorList.toArray());
                            clindashb.panelClinicDashboard.add(alldoctors);
                            alldoctors.setBounds(30, 120, 600, 400);
                        }
                    }else{
                        // if something is wrong this message will appear
                        regmeth.warning.setText("Registration failed! Please check all fields!");

                    }
                }catch (SQLException s){
                    s.printStackTrace();
                }
            }
        });

        regmeth.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regmeth.panelRegistration.setVisible(false);
                loginmeth.frame.add(loginmeth.panelLogIn);
                loginmeth.logInWindow();
            }
        });

        loginmeth.loginbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check if input is correct
                if (logInVal.isValidUsername(loginmeth.userText.getText()) && logInVal.isValidPassword(loginmeth.passwordText.getText())) {
                    if (loginmeth.clinic.isSelected()) {
                        try {
                            // get clinic id by login username and password
                            Integer clinicId = dbClinic.getClinicId(loginmeth.userText.getText(), loginmeth.passwordText.getText());
                            // if clinic was found in DB by username and password then log in is successful and clinic dashboard opens
                            if (clinicId > -1) {
                                loginmeth.panelLogIn.setVisible(false);
                                loginmeth.frame.add(clindashb.panelClinicDashboard);
                                clindashb.clinicDashboardWindow();
                                // get clinic name to display in dashboard
                                String clinicName = dbClinic.getName(loginmeth.userText.getText());
                                clindashb.clinName.setText("Welcome " + clinicName);
                                // get doctor list in clinic dashboard
                                ArrayList<String> doctorList = dbDoctor.getDoctorList(clinicId);
                                for (String s : doctorList) {
                                    // when clinic dashboard opens a list of all associated doctors will appear
                                    JList alldoctors = new JList(doctorList.toArray());
                                    clindashb.panelClinicDashboard.add(alldoctors);
                                    alldoctors.setBounds(30, 120, 600, 400);
                                }
                            } else {
                                // if log in failed this message will appear
                                loginmeth.wrongPass.setText("Log in failed! Check username or password and try again!");
                            }
                        } catch (SQLException a) {
                            a.printStackTrace();
                        }
                    }
                    // if doctor is selected, input is validated and checked with DB
                    if (loginmeth.doctor.isSelected()) {
                        try {
                            Integer doctorId = dbDoctor.getDoctorId(loginmeth.userText.getText(), loginmeth.passwordText.getText());
                            if (doctorId > -1) {
                                loginmeth.panelLogIn.setVisible(false);
                                loginmeth.frame.add(docdashb.panelDoctorDashboard);
                                docdashb.doctorDashboardWindow();
                                // display doctors name in dashboard
                                String doctorName = dbDoctor.getName(loginmeth.userText.getText());
                                docdashb.welcome.setText("Welcome " + doctorName);
                                // doctor dashboard will display list of all patients it has registered
                                ArrayList<String> patientList = dbPatient.getPatientList(doctorId);
                                for (String s : patientList) {
                                    // when clinic dashboard opens a list of all associated doctors will appear
                                    JList allPatient = new JList(patientList.toArray());
                                    docdashb.panelDoctorDashboard.add(allPatient);
                                    allPatient.setBounds(30, 120, 600, 400);
                                }
                            } else {
                                // if log in failed then this message will appear
                                loginmeth.wrongPass.setText("Log in failed! Check username or password and try again!");
                            }

                        } catch (SQLException b) {
                            b.printStackTrace();
                        }
                    }

                } else {
                    // if log in failed this message will appear
                    loginmeth.wrongPass.setText("Log in failed! Check username or password and try again!");
                }
                docdashb.history.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int patientId = dbPatient.getPatientIds(allPatient.getSelectedColumn());
                        JPanel his = (JPanel) e.getSource();
                        loginmeth.frame.add(his);
                        JTable m = new JTable(dbPatient.getPatientAllInfoList(patientId));
                    }
                });
            }
        });

        // to return to the log in window user can pres log out button
        clindashb.logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clindashb.panelClinicDashboard.setVisible(false);
                loginmeth.frame.add(loginmeth.panelLogIn);
                loginmeth.logInWindow();
            }
        });

        // when logged in as clinic, by pressing add new doctor, a registration form will open
        clindashb.addNewDoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clindashb.panelClinicDashboard.setVisible(false);
                loginmeth.frame.add(docreg.panelDoctorRegistration);
                docreg.doctorRegistrationWindow();
            }
        });

        // in doctor reg form, by  pressing back, user returns to clinic dashboard
        docreg.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                docreg.panelDoctorRegistration.setVisible(false);
                loginmeth.frame.add(clindashb.panelClinicDashboard);
                clindashb.clinicDashboardWindow();
            }
        });

        // user can log out from doctor dashboard if preses log out button
        docdashb.logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                docdashb.panelDoctorDashboard.setVisible(false);
                loginmeth.frame.add(loginmeth.panelLogIn);
                loginmeth.logInWindow();
            }
        });

        // if everything is filled right clinic can register new doctor for clinic with submit button
        docreg.submit.addActionListener(new ActionListener() {
            // submit button for new doctors registration
            @Override
            public void actionPerformed(ActionEvent e) {
                // gets Clinic ID
                try {
                    int dbClId = dbClinic.getClinicId(loginmeth.userText.getText(), loginmeth.passwordText.getText());

                    // checks if text fields are filled correct
                    if(docRegVal.isValidRegistration(docreg.docNameText.getText(), docreg.docSurnameText.getText(), docreg.usernameText.getText(), docreg.passwordText.getText(), docreg.reppasswordText.getText(), docreg.personalCodeText.getText(), docreg.certificateText.getText())){
                        // checks if unique needed fields are unique
                        // if unique then fields are registered in doctors table.
                        if(dbDoctor.register(docreg.docNameText.getText(), docreg.docSurnameText.getText(), docreg.usernameText.getText(), docreg.passwordText.getText(), docreg.personalCodeText.getText(), docreg.certificateText.getText(), dbClId, docRegVal.getStatus(docreg.active))){
                            dbDoctor.register(docreg.docNameText.getText(), docreg.docSurnameText.getText(), docreg.usernameText.getText(), docreg.passwordText.getText(), docreg.personalCodeText.getText(), docreg.certificateText.getText(), dbClId, docRegVal.getStatus(docreg.active));
                            docreg.panelDoctorRegistration.setVisible(false);
                            loginmeth.frame.add(clindashb.panelClinicDashboard);
                            clindashb.clinicDashboardWindow();
                            docreg.docNameText.setText("");
                            docreg.docSurnameText.setText("");
                            docreg.usernameText.setText("");
                            docreg.passwordText.setText("");
                            docreg.personalCodeText.setText("");
                            docreg.certificateText.setText("");
                            docreg.reppasswordText.setText("");
                            docreg.active.setSelected(true);

                        }else{
                            docreg.errorMessage.setText("doctor with this username/personal code/certificate Nr. already exists");
                        }
                    }else{
                        docreg.errorMessage.setText("fields are filled wrong");
                    }
                }catch (SQLException a) {
                    a.printStackTrace();
                }
            }
        });

        // button to get to doctors edit form
        clindashb.edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //need to select from list
                clindashb.panelClinicDashboard.setVisible(false);
                loginmeth.frame.add(editDoc.panelDoctorRegistration);
                editDoc.editDoctorRegistrationWindow("arturs", "kalnins", "310790-11708", "NR0135");

            }
        });

        editDoc.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editDoc.panelDoctorRegistration.setVisible(false);
                loginmeth.frame.add(clindashb.panelClinicDashboard);
                clindashb.clinicDashboardWindow();
            }
        });

        docdashb.history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

        }
        });
        docdashb.addnewPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if user preses button add med his, a new window with a form will open
                docdashb.panelDoctorDashboard.setVisible(false);
                loginmeth.frame.add(patReg.panelPatientRegistration);
                patReg.panelPatientRegistration.setVisible(true);
                patReg.patientRegistrationWindow();
            }
        });

        patReg.cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if user decides to not make new patient, by pressing back, user returns to dashboard
                patReg.panelPatientRegistration.setVisible(false);
                loginmeth.frame.add(docdashb.panelDoctorDashboard);
                docdashb.panelDoctorDashboard.setVisible(true);
                docdashb.doctorDashboardWindow();
            }
        });

        docdashb.addMedHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //doctor opens window for entering new info about patient
                docdashb.panelDoctorDashboard.setVisible(false);
                loginmeth.frame.add(medHisWin.panelNewMedicalHistory);
                medHisWin.panelNewMedicalHistory.setVisible(true);
                medHisWin.newMedicalHistoryWindow();
            }
        });

        medHisWin.cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //to return to dashboard user presses back
                medHisWin.panelNewMedicalHistory.setVisible(false);
                loginmeth.frame.add(docdashb.panelDoctorDashboard);
                docdashb.doctorDashboardWindow();
            }
        });





        // -------------------------------------------------------------------------

        //DBLogic_Clinic dbClinic = new DBLogic_Clinic();

        //boolean s = dbClinic.register("clNameE", "cl5@email.com", "22030409", "cl5LegalAddress", "cl5PhysicalAddress", "cl5RegNumber", "clEUsername", "clEPass");
        //System.out.println(s);
        //int clinicId = dbClinic.getClinicId("clDUsername", "clDPass");
        //dbClinic.getName("clDUsername");
        //dbClinic.isUsernameUnique("clDUsername");

        //DBLogic_Doctor dbDoctor = new DBLogic_Doctor();

        //boolean b = dbDoctor.register("NameD10", "SurnameD10", "usernameD10", "passwordD10", "999999-99999", "CER101010", 4, "active");
        //System.out.println(b);

        //int id = dbDoctor.getDoctorId("usernameD2", "passwordD3");
        //System.out.println(id);

        //System.out.println(dbDoctor.getName("usernameD3"));

        //ArrayList<String> list = dbDoctor.getDoctorList("4");
        //for (String s : list) {
        //    System.out.println(s);
        //}

        //ArrayList<String> list = dbDoctor.getDoctorAllInfoList(14);
        //for (String s : list) {
        //    System.out.println(s);
        //}
        //boolean d = dbDoctor.update("NameD8", "SurnameD8", "888888-88888", "CER888", "active",14);
        //System.out.println(d);

        // -------------------------------------------------------------------------

        //DBLogic_Patient dbPatient = new DBLogic_Patient();
        //boolean p = dbPatient.register("Kroshka", "Dog", "Chihua-hua", 2.5f, Date.valueOf("2013-03-13"), "CH1111", "Helena", "Luropa", 10 );

        //boolean p = dbPatient.register("Snowball", "Dog", "Husky", 20.5f, Date.valueOf("2020-06-15"), "CF1234", "Milena", "Sokolova", 7 );
        //System.out.println(p);

        //int id = dbPatient.getPatientId("passport_num2", 1);
        //System.out.println(id);
        //ArrayList<String> list = dbPatient.getPatientAllInfoList("7");
        //for (String s : list) {
        //    System.out.println(s);
        //}
        //ArrayList<String> list = dbPatient.getPatientList("3");
        //for (String s : list) {
        //    System.out.println(s);
        //}
        //boolean u = dbPatient.update("Snowball", "Dog", "Husky", 22.5f, Date.valueOf("2019-06-15"), "CF4321", "Alina", "Sokolova", 7, 7);
        //System.out.println(u);
/*
        String[] patient = dbPatient.getPatientNameAndGroup(3);
        System.out.println(patient[0] + " " + patient[1]);
        System.out.println(Arrays.toString(patient));
*/
/*
        ArrayList<Integer> patientIds = dbPatient.getPatientIds(4);
        for (int id: patientIds) {
            System.out.println("ID: " + id);
        }
*/
        // -------------------------------------------------------------------------

//        DBLogic_MedicalHistory dbMedHist = new DBLogic_MedicalHistory();
/*
        boolean regStatus = dbMedHist.register(9, 7, "diagnosis10", Date.valueOf("1985-08-13"), "medical_manipulation10", "medicaments10");
//        boolean regStatus = dbMedHist.register(9, 7, "diagnosis11", Date.valueOf("2002-02-20"), null, null);
        System.out.println(regStatus);
*/
/*
        ArrayList<String> medicalHistoryOfPatient = dbMedHist.getMedicalHistoryOfPatient(9);
        for (String el: medicalHistoryOfPatient) {
            System.out.println("MH: " + el);
        }
*/

        // -------------------------------------------------------------------------

    }
}