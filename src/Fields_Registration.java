import javax.swing.*;

public class Fields_Registration {
    JPanel panelRegistration = new JPanel();

    JButton back = new JButton("< Back");
    JLabel registration = new JLabel("Create new account for Your clinic here!");
    JLabel clinicName = new JLabel("Name of Clinic *");
    JLabel regNumber = new JLabel("Registration number *");
    JLabel adres = new JLabel("Address *");
    JLabel email = new JLabel("Email address *");
    JLabel phone = new JLabel("Phone number *");
    JLabel regaddress = new JLabel("Registration address");
    JLabel username = new JLabel("Username *");
    JLabel password = new JLabel("Password *");
    JLabel reppassword = new JLabel("Confirm password *");

    JTextField clinicNameText = new JTextField();
    JTextField regNumberText = new JTextField();
    JTextField adresText = new JTextField();
    JTextField emailText = new JTextField();
    JTextField phoneText = new JTextField();
    JTextField regaddressText = new JTextField();
    JTextField usernameText = new JTextField();

    JPasswordField passwordText = new JPasswordField();
    JPasswordField reppasswordText = new JPasswordField();

    JButton submit = new JButton("Submit");


}
