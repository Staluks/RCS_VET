package Windows;

import Fields.Fields_PatientRegistration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientRegistration extends Fields_PatientRegistration {
    public void patientRegistrationWindow() {
        //defining panelPatRegistration window for Patient registration form
        panelPatientRegistration.setVisible(true);
        panelPatientRegistration.setLayout(null);
        panelPatientRegistration.setBackground(Color.LIGHT_GRAY);

        //if user wants he can click cancel to return to the first window or submit data
        panelPatientRegistration.add(cancel);
        cancel.setBounds(10, 10, 90, 40);

        //top heading
        panelPatientRegistration.add(patRegistration);
        patRegistration.setBounds(220, 50, 300, 70);

        //adding and defining all the text elements in the form
        panelPatientRegistration.add(patName);
        panelPatientRegistration.add(patSpecies);
        panelPatientRegistration.add(patBreed);
        panelPatientRegistration.add(patWeight);
        panelPatientRegistration.add(passportNr);
        panelPatientRegistration.add(dateofBirth);
        panelPatientRegistration.add(ownerName);
        panelPatientRegistration.add(ownerSurname);

        patName.setBounds(70, 60, 200,200);
        patSpecies.setBounds(70, 105, 200, 200);
        patBreed.setBounds(70,150,200,200 );
        patWeight.setBounds(70,195,200,200);
        passportNr.setBounds(70,240,200,200);
        dateofBirth.setBounds(70,285,200,200);
        ownerName.setBounds(70,330,200,200);
        ownerSurname.setBounds(70,375,200,200);



        //adding all the fields for user input in the form
        panelPatientRegistration.add(patNameText);
        panelPatientRegistration.add(patSpeciesText);
        panelPatientRegistration.add(patBreedText);
        panelPatientRegistration.add(patWeightText);
        panelPatientRegistration.add(passportNrText);
        panelPatientRegistration.add(dateofBirthText);
        panelPatientRegistration.add(ownerNameText);
        panelPatientRegistration.add(ownerSurnameText);

        patNameText.setBounds(280,140,200,35);
        patNameText.setText("");
        patSpeciesText.setBounds(280,185,200,35);
        patSpeciesText.setText("");
        patBreedText.setBounds(280,230,200,35);
        patBreedText.setText("");
        patWeightText.setBounds(280,275,200,35);
        patWeightText.setText("");
        passportNrText.setBounds(280,320,200,35);
        passportNrText.setText("");
        dateofBirthText.setBounds(280,365,200,35);
        dateofBirthText.setText("");
        ownerNameText.setBounds(280,410,200,35);
        ownerNameText.setText("");
        ownerSurnameText.setBounds(280,455,200,35);
        ownerSurnameText.setText("");

        panelPatientRegistration.add(wrong);
        wrong.setBounds(120,570,200,50);
        wrong.setText("");

        panelPatientRegistration.add(submitpat);
        submitpat.setBounds(440,570,150,60);

        panelPatientRegistration.add(nameHint);
        panelPatientRegistration.add(spHint);
        panelPatientRegistration.add(brHint);
        passportNr.add(wigHint);
        passportNr.add(passpHint);
        panelPatientRegistration.add(birthHint);
        panelPatientRegistration.add(ownHint);
        panelPatientRegistration.add(spHint);

        nameHint.setBounds(485,140,200,20);
        spHint.setBounds(485,185,200,20);
        brHint.setBounds(485,230,200,20);
        wigHint.setBounds(485,275,200,20);
        passpHint.setBounds(485,320,200,20);
        birthHint.setBounds(485,365,200,20);
        ownHint.setBounds(485,410,200,20);
        spHint.setBounds(485,455,200,20);
        mesaage.setText("");
        nameHint.setText("");
        spHint.setText("");
        brHint.setText("");
        wigHint.setText("");
        passpHint.setText("");
        birthHint.setText("");
        ownHint.setText("");
        spHint.setText("");


        panelPatientRegistration.add(mesaage);
        mesaage.setBounds(220,10,400,40);

        panelPatientRegistration.add(help);
        help.setBounds(600,10,90,40);
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mesaage.setText("Please check, if fields are filled in correctly!");
                nameHint.setText("a-z, A-Z, 2-30 smb");
                spHint.setText("a-z, A-Z, 2-30 smb");
                brHint.setText("a-z, A-Z, 2-50 smb");
                wigHint.setText("0 - 500, format: xx.xx");
                passpHint.setText("a-z, A-Z, 2-50 smb");
                birthHint.setText("format: yyyy-mm-dd");
                ownHint.setText("a-z, A-Z, space, -,2-30 smb");
                spHint.setText("a-z, A-Z, space, -, 2-30 smb");

            }
        });

    }
}
