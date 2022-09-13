package Fields;

import javax.swing.*;

public class Fields_PatientRegistration {
    public JPanel panelPatientRegistration = new JPanel();

    public JButton cancel = new JButton("< Back");
    public JButton submitpat = new JButton("Submit");
    public JLabel patRegistration = new JLabel("Create new Patients account here!");
    public JLabel patName = new JLabel("Name of patient *");
    public JLabel patSpecies = new JLabel("Species of patient *");
    public JLabel patBreed = new JLabel("Breed of patient *");
    public JLabel patWeight = new JLabel("Weight of patient *");
    public  JLabel passportNr = new JLabel("Passport nr. of patient*");
    public JLabel dateofBirth = new JLabel("Date of birth*");
    public JLabel ownerName = new JLabel("Owner name *");
    public JLabel ownerSurname = new JLabel("Owner surname *");

    public JTextField patNameText = new JTextField();
    public JTextField patSpeciesText = new JTextField();
    public JTextField patBreedText = new JTextField();
    public JTextField patWeightText  = new JTextField();
    public  JTextField passportNrText = new JTextField();
    public JTextField dateofBirthText = new JTextField();
    public JTextField ownerNameText = new JTextField();
    public JTextField ownerSurnameText = new JTextField();
    public JLabel wrong = new JLabel();
    public JButton help = new JButton("Help");
    public JLabel nameHint = new JLabel("");
    public JLabel spHint = new JLabel("");
    public JLabel brHint = new JLabel("");
    public JLabel wigHint = new JLabel("");
    public JLabel passpHint = new JLabel("");
    public JLabel birthHint = new JLabel("");
    public  JLabel ownHint = new JLabel("");
     public JLabel surGint = new JLabel("");
}
