package Windows;

import Fields.Fields_DoctorRegistration;

import javax.swing.*;
import java.awt.*;

public class DoctorRegistration extends Fields_DoctorRegistration {
    public void doctorRegistrationWindow() {
        //defining panelDocRegistration window for doctor's registration form
        panelDoctorRegistration.setVisible(true);
        panelDoctorRegistration.setLayout(null);
        panelDoctorRegistration.setBackground(Color.LIGHT_GRAY);

        //if user wants he can click back to return to the first window
        panelDoctorRegistration.add(back);
        back.setBounds(10, 10, 90, 40);
        //top heading
        panelDoctorRegistration.add(docRegistration);
        docRegistration.setBounds(220, 50, 300, 70);

        //adding and defining all the text elements in the form
        panelDoctorRegistration.add(docName);
        panelDoctorRegistration.add(docSurname);
        panelDoctorRegistration.add(username);
        panelDoctorRegistration.add(personalCode);
        panelDoctorRegistration.add(certificate);
        panelDoctorRegistration.add(password);
        panelDoctorRegistration.add(reppassword);
        panelDoctorRegistration.add(errorMessage);

        docName.setBounds(50, 60, 200,200);
        docSurname.setBounds(50, 105, 200, 200);
        username.setBounds(50,150,200,200 );
        personalCode.setBounds(50,195,200,200);
        certificate.setBounds(50,240,200,200);
        password.setBounds(50,285,200,200);
        reppassword.setBounds(50,325,200,200);
        errorMessage.setBounds(280, 445, 200, 30);

        //adding all the fields for user input in the form
        panelDoctorRegistration.add(docNameText);
        panelDoctorRegistration.add(docSurnameText);
        panelDoctorRegistration.add(usernameText);
        panelDoctorRegistration.add(personalCodeText);
        panelDoctorRegistration.add(certificateText);
        panelDoctorRegistration.add(passwordText);
        panelDoctorRegistration.add(reppasswordText);

        docNameText.setBounds(280,140,200,35);
        docSurnameText.setBounds(280,185,200,35);
        usernameText.setBounds(280,230,200,35);
        personalCodeText.setBounds(280,275,200,35);
        certificateText.setBounds(280,320,200,35);
        passwordText.setBounds(280,365,200,35);
        reppasswordText.setBounds(280,410,200,35);

        panelDoctorRegistration.add(active);
        panelDoctorRegistration.add(blocked);

        active.setBounds(290, 500, 80, 20);
        blocked.setBounds(390, 500, 80, 20);

        //this method allows user to choose only one button doctor or clinic
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(active);
        active.setSelected(true);
        buttonGroup.add(blocked);

        panelDoctorRegistration.add(submit);
        submit.setBounds(440,570,150,60);
        docNameText.setText("");
        docSurnameText.setText("");
        usernameText.setText("");
        passwordText.setText("");
        personalCodeText.setText("");
        certificateText.setText("");
        reppasswordText.setText("");
    }
}
