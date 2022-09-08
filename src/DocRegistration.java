import Fields.FieldsDocRegister;

import javax.swing.*;
import java.awt.*;

public class DocRegistration extends FieldsDocRegister {
    public void docRegistrationWindow(){

        //defining panelDocRegistration window for doctor's registration form
        panelDocRegistration.setVisible(true);
        panelDocRegistration.setLayout(null);
        panelDocRegistration.setBackground(Color.LIGHT_GRAY);
        panelDocRegistration.add(back);

        //if user wants he can click back to return to the first window
        back.setBounds(10, 10, 90, 40);
        //top heading
        panelDocRegistration.add(docRegistration);

        docRegistration.setBounds(220, 50, 300, 70);

        //adding and defining all the text elements in the form
        panelDocRegistration.add(docName);
        panelDocRegistration.add(docSurname);
        panelDocRegistration.add(username);
        panelDocRegistration.add(personalCode);
        panelDocRegistration.add(certificate);
        panelDocRegistration.add(password);
        panelDocRegistration.add(reppassword);
        panelDocRegistration.add(errorMessage);

        docName.setBounds(50, 60, 200,200);
        docSurname.setBounds(50, 105, 200, 200);
        username.setBounds(50,150,200,200 );
        personalCode.setBounds(50,195,200,200);
        certificate.setBounds(50,240,200,200);
        password.setBounds(50,285,200,200);
        reppassword.setBounds(50,325,200,200);
        errorMessage.setBounds(280, 445, 200, 30);

        //adding all the fields for user input in the form
        panelDocRegistration.add(docNameText);
        panelDocRegistration.add(docSurnameText);
        panelDocRegistration.add(usernameText);
        panelDocRegistration.add(personalCodeText);
        panelDocRegistration.add(certificateText);
        panelDocRegistration.add(passwordText);
        panelDocRegistration.add(reppasswordText);

        docNameText.setBounds(280,140,200,35);
        docSurnameText.setBounds(280,185,200,35);
        usernameText.setBounds(280,230,200,35);
        personalCodeText.setBounds(280,275,200,35);
        certificateText.setBounds(280,320,200,35);
        passwordText.setBounds(280,365,200,35);
        reppasswordText.setBounds(280,410,200,35);

        panelDocRegistration.add(active);
        panelDocRegistration.add(blocked);

        active.setBounds(290, 500, 80, 20);
        blocked.setBounds(390, 500, 80, 20);

        //this method allows user to choose only one button doctor or clinic
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(active);
        active.setSelected(true);
        buttonGroup.add(blocked);


        panelDocRegistration.add(submit);
        submit.setBounds(440,570,150,60);

    }

}
