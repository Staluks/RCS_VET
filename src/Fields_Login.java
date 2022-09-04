import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fields_Login {
        JFrame frame = new JFrame();

        //this panel is the first window that opens for loging in
        JPanel panellogin = new JPanel();

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/paw.png"));
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo.png"));
        JLabel logo1 = new JLabel();

        JRadioButton clinic = new JRadioButton("Clinic");
        JRadioButton doctor = new JRadioButton("Doctor");

        JLabel username = new JLabel("Username");

        JLabel password = new JLabel("Password");

        JTextField userText = new JTextField();

        JPasswordField passwordText = new JPasswordField();

        JButton loginbut = new JButton("Log In");
        JButton regbut = new JButton("Create new account");

    }
