package Windows;

import Fields.Fields_LogIn;

import javax.swing.*;
import java.awt.*;

public class LogIn extends Fields_LogIn {
    public void logInWindow() {
        //define and set the frame of the app
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(100, 100, 700, 700);
        frame.setTitle("Simply VET ");
        frame.setIconImage(icon.getImage());

        //defining pabellogin
        frame.add(panelLogIn);
        panelLogIn.add(logo1);
        logo1.setIcon(logo);
        logo1.setBounds(30, 0, 560, 290);

        panelLogIn.setVisible(true);
        panelLogIn.setLayout(null);
        panelLogIn.setBackground(Color.LIGHT_GRAY);

        panelLogIn.add(clinic);
        panelLogIn.add(doctor);

        clinic.setBounds(175, 260, 100, 100);
        doctor.setBounds(275, 260, 100, 100);

        //this method allows user to choose only one button doctor or clinic
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(clinic);
        buttonGroup.add(doctor);

        panelLogIn.add(username);
        panelLogIn.add(password);

        username.setBounds(50, 275, 200, 200);
        password.setBounds(50, 330, 200, 200);

        panelLogIn.add(userText);
        panelLogIn.add(passwordText);

        userText.setBounds(270, 350, 150, 40);
        userText.setText("");

        passwordText.setBounds(270, 410, 150, 40);
        passwordText.setText("");

        panelLogIn.add(loginbut);
        loginbut.setBounds(250, 500, 200, 35);

        panelLogIn.add(regbut);
        regbut.setBounds(20, 500, 160, 35);

        panelLogIn.add(wrongPass);
        wrongPass.setBounds(150, 540,400,100);
    }
}