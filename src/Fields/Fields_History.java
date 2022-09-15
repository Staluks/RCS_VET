package Fields;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Fields_History {
   public JPanel panelHistory = new JPanel();
    public JLabel history = new JLabel();
    public DefaultListModel model = new DefaultListModel();

    public JList historyPanel = new JList(model);
    public JButton back = new JButton("< Back");
}
