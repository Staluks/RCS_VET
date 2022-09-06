import Validation.ValidationLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends Fields_Login {

    public void loginWindow() {
//define and set the frame of the app
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(100, 100, 700, 700);
        frame.setTitle("Simply VET ");
        frame.setIconImage(icon.getImage());

        //defining pabellogin
        frame.add(panellogin);

        panellogin.add(logo1);
        logo1.setIcon(logo);
        logo1.setBounds(30, 0, 560, 290);

        panellogin.setVisible(true);
        panellogin.setLayout(null);
        panellogin.setBackground(Color.LIGHT_GRAY);

        panellogin.add(clinic);
        panellogin.add(doctor);

        clinic.setBounds(175, 260, 100, 100);
        doctor.setBounds(275, 260, 100, 100);

//this method allows user to choose only one button doctor or clinic
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(clinic);
        buttonGroup.add(doctor);

        panellogin.add(username);
        panellogin.add(password);

        username.setBounds(50, 275, 200, 200);
        password.setBounds(50, 330, 200, 200);

        panellogin.add(userText);
        panellogin.add(passwordText);

        userText.setBounds(270, 350, 150, 40);
        passwordText.setBounds(270, 410, 150, 40);

        panellogin.add(loginbut);

        loginbut.setBounds(250, 500, 200, 35);


        loginbut.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                   String field;
                   field = userText.getText();
                   String field2;
                   field2 = passwordText.getText();
                   if(ValidationLogin.isValidUsername(field) && ValidationLogin.isValidPassword(field2)) {

                   }
                   else {
                       JOptionPane.showMessageDialog(null, "Please enter your username and password correctly");
                   }
               }
           });



        panellogin.add(regbut);

        regbut.setBounds(20, 500, 160, 35);
       panellogin.add(wrongPass);
        wrongPass.setBounds(150, 540,400,100);




    }
}