import Fields.Fields_Registration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration extends Fields_Registration {
    public void registrationWindow () {
        //defining panelRegistration window for registration form
        panelRegistration.setVisible(true);
        panelRegistration.setLayout(null);
        panelRegistration.setBackground(Color.LIGHT_GRAY);

        //if user wants he can click back to return to the first window
        panelRegistration.add(back);
        back.setBounds(10, 10, 90, 40);

        //user can press button help to see hints appear to know how to fill in reg form
        panelRegistration.add(help);
        help.setBounds(585,10,90,40);

        //top heading
        panelRegistration.add(registration);
        registration.setBounds(220, 50, 300, 70);

        //adding and defining all the text elements in the form
        panelRegistration.add(clinicName);
        panelRegistration.add(regNumber);
        panelRegistration.add(adres);
        panelRegistration.add(email);
        panelRegistration.add(phone);
        panelRegistration.add(regaddress);
        panelRegistration.add(username);
        panelRegistration.add(password);
        panelRegistration.add(reppassword);

        clinicName.setBounds(50, 60, 200, 200);
        regNumber.setBounds(50, 105, 200, 200);
        adres.setBounds(50,150,200,200 );
        email.setBounds(50,195,200,200);
        phone.setBounds(50,240,200,200);
        regaddress.setBounds(50,285,200,200);
        username.setBounds(50,325,200,200);
        password.setBounds(50,370,200,200);
        reppassword.setBounds(50,415,200,200);

        //adding all the fields for user input in the form
        panelRegistration.add(clinicNameText);
        panelRegistration.add(regNumberText);
        panelRegistration.add(adresText);
        panelRegistration.add(emailText);
        panelRegistration.add(phoneText);
        panelRegistration.add(regaddressText);
        panelRegistration.add(usernameText);
        panelRegistration.add(passwordText);
        panelRegistration.add(reppasswordText);
        //adding all hint labels
        panelRegistration.add(nameHint);
        panelRegistration.add(regNumHint);
        panelRegistration.add(adrHint);
        panelRegistration.add(mailHint);
        panelRegistration.add(phoneHint);
        panelRegistration.add(regAdrHint);
        panelRegistration.add(userHint);
        panelRegistration.add(passHint);
        panelRegistration.add(repassHint);

        clinicNameText.setBounds(250,140,200,35);
        clinicNameText.setText("");
        nameHint.setBounds(470, 135,270,35);
        nameHint.setText("");
        regNumberText.setBounds(250,185,200,35);
        regNumberText.setText("");
        regNumHint.setBounds(470,180,270,35);
        regNumHint.setText("");
        adresText.setBounds(250,230,200,35);
        adresText.setText("");
        adrHint.setBounds(470,225,270,35);
        adrHint.setText("");
        emailText.setBounds(250,275,200,35);
        emailText.setText("");
        mailHint.setBounds(470,270,270,35);
        mailHint.setText("");
        phoneText.setBounds(250,320,200,35);
        phoneText.setText("");
        phoneHint.setBounds(470,315,270,35);
        phoneHint.setText("");
        regaddressText.setBounds(250,365,200,35);
        regaddressText.setText("");
        regAdrHint.setBounds(470,360,270,35);
        regAdrHint.setText("");
        usernameText.setBounds(250,410,200,35);
        usernameText.setText("");
        userHint.setBounds(470, 405,270,35);
        userHint.setText("");
        passwordText.setBounds(250,455,200,35);
        passwordText.setText("");
        passHint.setBounds(470,450,270,35);
        passHint.setText("");
        reppasswordText.setBounds(250,500,200,35);
        reppasswordText.setText("");
        repassHint.setBounds(470,495,270,35);
        repassHint.setText("");

        //this mesage is if help button is pressed
        panelRegistration.add(mesaage);
        mesaage.setBounds(220,10,400,40);
        mesaage.setText("");

        //submit button for creating new account
        panelRegistration.add(submit);
        submit.setBounds(440,570,150,60);

        panelRegistration.add(warning);
        warning.setBounds(20,550, 300,50);
    help.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mesaage.setText("Please check, if fields are filled in correctly!");
            nameHint.setText("a-z, A-Z, 0-9, space, -, 2-30 smb");
            regNumHint.setText("a-z, A-Z, 0-9, 2-30 smb");
            adrHint.setText("a-z, A-Z, 0-9, space, -, 2-255 smb");
            mailHint.setText("6-50 smb");
            phoneHint.setText("0-9, 1-8 smb");
            regAdrHint.setText("a-z, A-Z, 0-9, space, -, 2-255 smb");
            userHint.setText("a-z, A-Z, 0-9, 6-30 smb");
            passHint.setText("a-z, A-Z, 0-9, 8-20 smb");
            repassHint.setText("a-z, A-Z, 0-9, 8-20 smb");
        }
    });
    }
}
