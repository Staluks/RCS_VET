package Fields;

import javax.swing.*;

public class Fields_ClinicDashboard {
    public JPanel panelClinicDashboard = new JPanel();

    public JLabel yourDashB = new JLabel("Clinic dashboard");

    public JButton logout = new JButton("Log out");
    public JButton addNewDoc = new JButton("Add new doctor");
    public JButton block = new JButton("Block");
    public JButton unblock = new JButton("Unblock");
    public JButton edit = new JButton("Edit");
    public JLabel clinName = new JLabel();
    public JList alldoctors = new JList();
}