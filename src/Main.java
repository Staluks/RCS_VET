import db.DBLogic_Clinic;
import db.DBLogic_Doctor;
import db.DBLogic_MedicalHistory;
import db.DBLogic_Patient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {

        LogIn loginmeth = new LogIn();
        Registration regmeth = new Registration();
        ClinicDashBoard clindashb = new ClinicDashBoard();
        DoctorDashBoard docdashb = new DoctorDashBoard();
        DocRegistration docreg = new DocRegistration();
        DBLogic_Clinic dbClinic = new DBLogic_Clinic();
        DBLogic_Doctor dbDoctor = new DBLogic_Doctor();
        DBLogic_Patient dbPatient = new DBLogic_Patient();
        DBLogic_MedicalHistory dbMedHistory = new DBLogic_MedicalHistory();




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
                    //todo add validations
                    try {
                        //get clinic id by login username and password
                        Integer clinicId = dbClinic.getClinicId(loginmeth.userText.getText(), loginmeth.passwordText.getText());
                        //if clinic was found in DB by username and password then log in is succesfull and clinic dash board opens
                        if (clinicId > -1) {
                            loginmeth.panellogin.setVisible(false);
                            loginmeth.frame.add(clindashb.panelClinicDashB);
                            clindashb.clinicDash();
                            //get clinic name to display in dashboard
                            String clinicName = dbClinic.getName(loginmeth.userText.getText());
                            clindashb.clinName.setText("Welcome " + clinicName);
                            //get doctor list in clinic dashboard
                            ArrayList<String> doctorList = dbDoctor.getDoctorList(clinicId);
                            for (String s : doctorList) {
                                //when clinic dashboard opens a list of all asosiated doctors will appear
                                JList alldoctors = new JList(doctorList.toArray());
                                clindashb.panelClinicDashB.add(alldoctors);
                                alldoctors.setBounds(30, 120, 600, 400);

                            }
                        } else {
                            //if log in failed this message will appear
                            loginmeth.wrongPass.setText("Log in failed! Check username or password and try again!");
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }

                }
                if (loginmeth.doctor.isSelected()) {
                    try {
                        Integer doctorId = dbDoctor.getDoctorId(loginmeth.userText.getText(), loginmeth.passwordText.getText());
                        if (doctorId > -1) {
                            loginmeth.panellogin.setVisible(false);
                            loginmeth.frame.add(docdashb.panelDoctorDashB);
                            docdashb.doctorDash();
                            String doctorName = dbDoctor.getName(loginmeth.userText.getText());
                            docdashb.welcome.setText("Welcome " + doctorName);
                            ArrayList<String> patientList = dbPatient.getPatientList(doctorId);
                            for (String s : patientList) {
                                //when clinic dashboard opens a list of all asosiated doctors will appear
                                JList allPatient = new JList(patientList.toArray());
                                docdashb.panelDoctorDashB.add(allPatient);
                                allPatient.setBounds(30, 120, 600, 400);

                            }

                        } else {
                            //if log in failed then this mesage will appear
                            loginmeth.wrongPass.setText("Log in failed! Check username or password and try again!");
                        }

                    } catch (SQLException b) {
                        b.printStackTrace();
                    }
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

        // ---------- ===== === -- - ------- = - = ========================================

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

        // ---------- ===== === -- - ------- = - = ========================================

    }
}