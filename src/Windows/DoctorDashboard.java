package Windows;

import Fields.Fields_DoctorDashboard;

import java.awt.*;

public class DoctorDashboard extends Fields_DoctorDashboard {
    public void doctorDashboardWindow() {
        panelDoctorDashboard.setVisible(true);
        panelDoctorDashboard.setLayout(null);
        panelDoctorDashboard.setBackground(Color.LIGHT_GRAY);

        panelDoctorDashboard.add(docform);
        docform.setBounds(270,10,300,70);

        panelDoctorDashboard.add(logout);
        logout.setBounds(600,10,70,35);;

        panelDoctorDashboard.add(history);
        history.setBounds(160,600,80,45);

        panelDoctorDashboard.add(edit);
        edit.setBounds(350,600,100,45);

        panelDoctorDashboard.add(addMedHistory);
        addMedHistory.setBounds(10,600,140,45);

        panelDoctorDashboard.add(addnewPatient);
        addnewPatient.setBounds(460,600,125,45);

        panelDoctorDashboard.add(welcome);
        welcome.setBounds(20,10,300,50);
    }
}
