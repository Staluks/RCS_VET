package Patient;

import javax.swing.*;

public class FieldsNewMedHistory {

    JFrame frame = new JFrame();
    JPanel panelNewMedHis = new JPanel();

    JButton cancel = new JButton("< Cancel");
    JButton submithis = new JButton("Submit");

    JLabel newMedHisForm = new JLabel("New Medical History form");
    JLabel patName = new JLabel("Name of Patient *");
    JLabel patSpecies = new JLabel("Species of Patient *");
    JLabel diagnosis = new JLabel("Diagnosis *");
    JLabel manipulations = new JLabel("Manipulations*");
    JLabel medicine = new JLabel("Medicine/Drugs *");




    JTextField patNameText = new JTextField();
    JTextField patSpeciesText = new JTextField();
    JTextField diagnosisText = new JTextField();
    JTextField manipulationsText = new JTextField();
    JTextField medicineText = new JTextField();


}
