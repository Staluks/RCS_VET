package Windows;

import Fields.Fields_ClinicDashboard;

import java.awt.*;

public class ClinicDashboard extends Fields_ClinicDashboard {
    public void clinicDashboardWindow() {
        panelClinicDashboard.setVisible(true);
        panelClinicDashboard.setLayout(null);
        panelClinicDashboard.setBackground(Color.LIGHT_GRAY);

        panelClinicDashboard.add(yourDashB);
        yourDashB.setBounds(270,10,300,70);

        panelClinicDashboard.add(logout);
        logout.setBounds(600,10,70,35);

        panelClinicDashboard.add(addNewDoc);
        addNewDoc.setBounds(460,600,125,45);

        panelClinicDashboard.add(edit);
        edit.setBounds(350,600,100,45);

        panelClinicDashboard.add(clinName);
        clinName.setBounds(20,10,300,50);
    }
}