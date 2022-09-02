package Patient;

import javax.swing.*;
import java.awt.*;

public class NewMedHistory extends FieldsNewMedHistory {

    public void NewMedHistoryWindow() {

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(10, 100, 700, 700);
        frame.add(panelNewMedHis);
        //defining panelPatRegistration window for Patien registration form
        panelNewMedHis.setVisible(true);
        panelNewMedHis.setLayout(null);
        panelNewMedHis.setBackground(Color.LIGHT_GRAY);
        panelNewMedHis.add(cancel);


        //if user wants he can click cancel to return to the first window or submit data
        cancel.setBounds(10, 10, 90, 40);

        //top heading
        panelNewMedHis.add(newMedHisForm);
        newMedHisForm.setBounds(220, 50, 300, 70);

        //adding and defining all the text elements in the form
        panelNewMedHis.add(patName);
        panelNewMedHis.add(patSpecies);
        panelNewMedHis.add(diagnosis);
        panelNewMedHis.add(manipulations);
        panelNewMedHis.add(medicine);



        patName.setBounds(50, 60, 200,200);
        patSpecies.setBounds(50, 105, 200, 200);
        diagnosis.setBounds(50,160,200,200 );
        manipulations.setBounds(50,240,200,200);
        medicine.setBounds(50,320,200,200);




        //adding all the fields for user input in the form
        panelNewMedHis.add(patNameText);
        panelNewMedHis.add(patSpeciesText);
        panelNewMedHis.add(diagnosisText);
        panelNewMedHis.add(manipulationsText);
        panelNewMedHis.add(medicineText);



        patNameText.setBounds(280,140,200,35);
        patSpeciesText.setBounds(280,185,200,35);
        diagnosisText.setBounds(280,230,350,70);
        manipulationsText.setBounds(280,310,350,70);
        medicineText.setBounds(280,390,350,70);

        panelNewMedHis.add(submithis);
        submithis.setBounds(440,570,150,60);

    }
}
