package Fields;

import javax.swing.*;

public class FieldsNewMedHistory {

    public JPanel panelNewMedHis = new JPanel();

    public JButton cancel = new JButton("< Cancel");
    public JButton submithis = new JButton("Submit");
    public JLabel newMedHisForm = new JLabel("New Medical History");
    public JLabel patName = new JLabel("Name of Patient *");
    public JLabel patSpecies = new JLabel("Species of Patient *");
    public JLabel diagnosis = new JLabel("Diagnosis *");
    public JLabel dateOfDiagnosis = new JLabel("Date of Diagnosis *");
    public JLabel manipulations = new JLabel("Manipulations");
    public JLabel medicine = new JLabel("Medicine/Drugs");

    public JTextArea patNameText = new JTextArea();
    public JTextArea patSpeciesText = new JTextArea();
    public JTextField diagnosisText = new JTextField();
    public JTextField dateOfDiagnosisText = new JTextField();
    public JTextField manipulationsText = new JTextField();
    public JTextField medicineText = new JTextField();

}
