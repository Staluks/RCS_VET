package Fields;

import javax.swing.*;

public class Fields_LogIn {
    public JFrame frame = new JFrame();

    //this panel is the first window that opens for loging in
    public JPanel panelLogIn = new JPanel();

    public ImageIcon icon = new ImageIcon(getClass().getResource("/images/paw.png"));
    public ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo.png"));
    public JLabel logo1 = new JLabel();

    public JRadioButton clinic = new JRadioButton("Clinic");
    public JRadioButton doctor = new JRadioButton("Doctor");

    public JLabel username = new JLabel("Username");
    public JLabel password = new JLabel("Password");

    public JTextField userText = new JTextField();

    public JPasswordField passwordText = new JPasswordField();

    public JButton loginbut = new JButton("Log in");
    public JButton regbut = new JButton("Create new account");
    public JLabel wrongPass = new JLabel();
}
