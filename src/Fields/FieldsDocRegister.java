package Fields;

import javax.swing.*;

public class FieldsDocRegister {
    public JPanel panelDocRegistration = new JPanel();

    public  JButton back = new JButton("< Back");

    public JLabel docRegistration = new JLabel("Create new Doctor's account for Your clinic here!");
    public JLabel docName = new JLabel("Name of doctor *");
    public JLabel docSurname = new JLabel("Surname of doctor *");
    public  JLabel username = new JLabel("Username *");
    public JLabel personalCode = new JLabel("Personal code*");
    public JLabel certificate = new JLabel("Certificate Nr. *");

    public JLabel password = new JLabel("Password *");
    public  JLabel reppassword = new JLabel("Confirm password *");
    public  JLabel errorMessage = new JLabel();

    public JTextField docNameText = new JTextField();
    public  JTextField docSurnameText = new JTextField();
    public  JTextField usernameText = new JTextField();
    public  JTextField personalCodeText = new JTextField();

    public  JTextField certificateText = new JTextField();


    public JPasswordField passwordText = new JPasswordField();
    public JPasswordField reppasswordText = new JPasswordField();

    public JRadioButton active = new JRadioButton("active");
    public  JRadioButton blocked = new JRadioButton("blocked");

    public JButton submit = new JButton("Submit");

}
