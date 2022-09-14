package Windows;

import Fields.Fields_PatientRegistration;

import java.awt.*;

public class EditPatient extends Fields_PatientRegistration {
    public void patientEditWindow(String name, String spieces, String breed, String passport, String ownerN, String ownerS) {
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
        panelPatientRegistration.add(passportNr);
        panelPatientRegistration.add(ownerName);
        panelPatientRegistration.add(ownerSurname);

        patName.setBounds(70, 60, 200,200);
        patSpecies.setBounds(70, 105, 200, 200);
        patBreed.setBounds(70,150,200,200 );
        passportNr.setBounds(70,195,200,200);
        ownerName.setBounds(70,240,200,200);
        ownerSurname.setBounds(70,285,200,200);




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
        patNameText.setText(name);
        patSpeciesText.setBounds(280,185,200,35);
        patSpeciesText.setText(spieces);
        patBreedText.setBounds(280,230,200,35);
        patBreedText.setText(breed);
        passportNrText.setBounds(280,275,200,35);
        passportNrText.setText(passport);
        ownerNameText.setBounds(280,320,200,35);
        ownerNameText.setText(ownerN);
        ownerSurnameText.setBounds(280,365,200,35);
        ownerSurnameText.setText(ownerS);


        panelPatientRegistration.add(submitpat);
        submitpat.setBounds(440,570,150,60);
    }
}
