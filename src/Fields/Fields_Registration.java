package Fields;

import javax.swing.*;

public class Fields_Registration {
    public JPanel panelRegistration = new JPanel();

    public JButton back = new JButton("< Back");
    public JLabel registration = new JLabel("Create new account for Your clinic here!");
    public JLabel clinicName = new JLabel("Name of clinic *");
    public JLabel regNumber = new JLabel("Registration number *");
    public JLabel adres = new JLabel("Address *");
    public JLabel email = new JLabel("Email address *");
    public JLabel phone = new JLabel("Phone number *");
    public JLabel regaddress = new JLabel("Registration address *");
    public JLabel username = new JLabel("Username *");
    public JLabel password = new JLabel("Password *");
    public JLabel reppassword = new JLabel("Confirm password *");

    public JTextField clinicNameText = new JTextField();
    public JTextField regNumberText = new JTextField();
    public JTextField adresText = new JTextField();
    public JTextField emailText = new JTextField();
    public JTextField phoneText = new JTextField();
    public JTextField regaddressText = new JTextField();
    public JTextField usernameText = new JTextField();

    public JPasswordField passwordText = new JPasswordField();
    public JPasswordField reppasswordText = new JPasswordField();

    public JButton submit = new JButton("Submit");
    public JLabel warning = new JLabel("");
}



