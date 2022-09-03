import javax.swing.*;

public class FieldsDocRegister {
    JPanel panelDocRegistration = new JPanel();

    JButton back = new JButton("< Back");

    JLabel docRegistration = new JLabel("Create new Doctor's account for Your clinic here!");
    JLabel docName = new JLabel("Name of doctor *");
    JLabel docSurname = new JLabel("Surname of doctor *");
    JLabel username = new JLabel("Username *");
    JLabel personalCode = new JLabel("Personal code*");
    JLabel certificate = new JLabel("Certificate Nr. *");
    JLabel errorMessage = new JLabel();
    JLabel password = new JLabel("Password *");
    JLabel reppassword = new JLabel("Confirm password *");

    JTextField docNameText = new JTextField();
    JTextField docSurnameText = new JTextField();
    JTextField usernameText = new JTextField();
    JTextField personalCodeText = new JTextField();

    JTextField certificateText = new JTextField();


    JPasswordField passwordText = new JPasswordField();
    JPasswordField reppasswordText = new JPasswordField();

    JRadioButton active = new JRadioButton("active");
    JRadioButton blocked = new JRadioButton("blocked");

    JButton submit = new JButton("Submit");

}
