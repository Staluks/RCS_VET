package Fields;

import javax.swing.*;

public class Fields_NewMedicalHistory {
    public JPanel panelNewMedicalHistory = new JPanel();

    public JButton cancel = new JButton("< Back");
    public JButton submithis = new JButton("Submit");
    public JLabel newMedHisForm = new JLabel("New medical history");
    public JLabel patName = new JLabel("Name of patient *");
    public JLabel patSpecies = new JLabel("Species of patient *");
    public JLabel diagnosis = new JLabel("Diagnosis *");
    public JLabel dateOfDiagnosis = new JLabel("Date of diagnosis *");
    public JLabel manipulations = new JLabel("Manipulations");
    public JLabel medicine = new JLabel("Medicine/drugs");

    public JTextArea patNameText = new JTextArea();
    public JTextArea patSpeciesText = new JTextArea();
    public JTextField diagnosisText = new JTextField();
    public JTextField dateOfDiagnosisText = new JTextField();
    public JTextField manipulationsText = new JTextField();
    public JTextField medicineText = new JTextField();
}
