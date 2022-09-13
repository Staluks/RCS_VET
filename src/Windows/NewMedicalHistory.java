package Windows;

import Fields.Fields_NewMedicalHistory;

import java.awt.*;

public class NewMedicalHistory extends Fields_NewMedicalHistory {
    public void newMedicalHistoryWindow() {
        //defining panelPatRegistration window for Patient registration form
        panelNewMedicalHistory.setVisible(true);
        panelNewMedicalHistory.setLayout(null);
        panelNewMedicalHistory.setBackground(Color.LIGHT_GRAY);

        //if user wants he can click cancel to return to the first window or submit data
        panelNewMedicalHistory.add(cancel);
        cancel.setBounds(10, 10, 90, 40);

        //top heading
        panelNewMedicalHistory.add(newMedHisForm);
        newMedHisForm.setBounds(220, 50, 300, 70);

        //adding and defining all the text elements in the form
        panelNewMedicalHistory.add(patName);
        panelNewMedicalHistory.add(patSpecies);
        panelNewMedicalHistory.add(diagnosis);
        panelNewMedicalHistory.add(dateOfDiagnosis);
        panelNewMedicalHistory.add(manipulations);
        panelNewMedicalHistory.add(medicine);

        patName.setBounds(50, 50, 200,200);
        patSpecies.setBounds(50, 105, 200, 200);
        diagnosis.setBounds(50,160,200,200 );
        dateOfDiagnosis.setBounds(50,225,200,200);
        manipulations.setBounds(50,290,200,200);
        medicine.setBounds(50,365,200,200);

        //adding all the fields for user input in the form
        panelNewMedicalHistory.add(patNameText);
        panelNewMedicalHistory.add(patSpeciesText);
        panelNewMedicalHistory.add(diagnosisText);
        panelNewMedicalHistory.add(dateOfDiagnosisText);
        panelNewMedicalHistory.add(manipulationsText);
        panelNewMedicalHistory.add(medicineText);

        patNameText.setBounds(280,140,200,35);
        patNameText.setText("");
        patSpeciesText.setBounds(280,185,200,35);
        patSpeciesText.setText("");
        diagnosisText.setBounds(280,230,350,70);
        diagnosisText.setText("");
        dateOfDiagnosisText.setBounds(280, 305,200,35);
        dateOfDiagnosisText.setText("");
        manipulationsText.setBounds(280,350,350,70);
        manipulationsText.setText("");
        medicineText.setBounds(280,430,350,70);
        medicineText.setText("");

        panelNewMedicalHistory.add(submithis);
        submithis.setBounds(440,570,150,60);
    }
}
