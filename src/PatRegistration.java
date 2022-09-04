import javax.swing.*;
import java.awt.*;

public class PatRegistration extends FieldsPatRegister {

    public void patRegistrationWindow(){

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(10, 100, 700, 700);
        frame.add(panelPatRegistration);
        //defining panelPatRegistration window for Patien registration form
        panelPatRegistration.setVisible(true);
        panelPatRegistration.setLayout(null);
        panelPatRegistration.setBackground(Color.LIGHT_GRAY);
        panelPatRegistration.add(cancel);


        //if user wants he can click cancel to return to the first window or submit data
        cancel.setBounds(10, 10, 90, 40);

        //top heading
        panelPatRegistration.add(patRegistration);
        patRegistration.setBounds(220, 50, 300, 70);

        //adding and defining all the text elements in the form
        panelPatRegistration.add(patName);
        panelPatRegistration.add(patSpecies);
        panelPatRegistration.add(passportNr);
        panelPatRegistration.add(dateofBirth);
        panelPatRegistration.add(ownerName);
        panelPatRegistration.add(ownerSurname);
        panelPatRegistration.add(ownerTelNr);


        patName.setBounds(50, 60, 200,200);
        patSpecies.setBounds(50, 105, 200, 200);
        passportNr.setBounds(50,150,200,200 );
        dateofBirth.setBounds(50,195,200,200);
        ownerName.setBounds(50,240,200,200);
        ownerSurname.setBounds(50,285,200,200);
        ownerTelNr.setBounds(50,330,200,200);



        //adding all the fields for user input in the form
        panelPatRegistration.add(patNameText);
        panelPatRegistration.add(patSpeciesText);
        panelPatRegistration.add(passportNrText);
        panelPatRegistration.add(dateofBirthText);
        panelPatRegistration.add(ownerNameText);
        panelPatRegistration.add(ownerSurnameText);
        panelPatRegistration.add(ownerTelNrText);


        patNameText.setBounds(280,140,200,35);
        patSpeciesText.setBounds(280,185,200,35);
        passportNrText.setBounds(280,230,200,35);
        dateofBirthText.setBounds(280,275,200,35);
        ownerNameText.setBounds(280,320,200,35);
        ownerSurnameText.setBounds(280,365,200,35);
        ownerTelNrText.setBounds(280,410,200,35);




        panelPatRegistration.add(submitpat);
        submitpat.setBounds(440,570,150,60);



    }
}
