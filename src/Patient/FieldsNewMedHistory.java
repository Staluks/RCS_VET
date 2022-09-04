package Patient;

import javax.swing.*;

public class FieldsNewMedHistory {


    public JPanel panelNewMedHis = new JPanel();

    JButton cancel = new JButton("< Cancel");
    JButton submithis = new JButton("Submit");
    JLabel newMedHisForm = new JLabel("New Medical History form");
    JLabel patName = new JLabel("Name of Patient *");
    JLabel patSpecies = new JLabel("Patient Species *");
    JLabel diagnosis = new JLabel("Diagnosis *");
    JLabel dateOfDiagnosis = new JLabel("Date of diagnosis *");
    JLabel manipulations = new JLabel("Manipulations");
    JLabel medicine = new JLabel("Medicine/Drugs");




    JTextArea patNameText = new JTextArea();
    JTextArea patSpeciesText = new JTextArea();
    JTextField diagnosisText = new JTextField();
    JTextField dateOfDiagnosisText = new JTextField();
    JTextField manipulationsText = new JTextField();
    JTextField medicineText = new JTextField();

}
