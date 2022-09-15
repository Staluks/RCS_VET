package Windows;

import Fields.Fields_History;

import java.awt.*;

public class HistoryWindow extends Fields_History {
public void historyWindow(){
    panelHistory.setVisible(true);
    panelHistory.setLayout(null);
    panelHistory.setBackground(Color.LIGHT_GRAY);
    panelHistory.add(back);
    back.setBounds(600,10,70,35);

    panelHistory.add(historyPanel);
    historyPanel.setBounds(30, 120, 600, 400);

    panelHistory.add(history);
    history.setBounds(270,10,300,70);



}
}
