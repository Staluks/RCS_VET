import java.awt.*;

public class DoctorDashBoard extends Fields_DoctorDashBoard{
    public void doctorDash (){
        panelDoctorDashB.setVisible(true);
        panelDoctorDashB.setLayout(null);
        panelDoctorDashB.setBackground(Color.LIGHT_GRAY);

        panelDoctorDashB.add(docform);

        docform.setBounds(270,10,300,70);

        panelDoctorDashB.add(logout);

        logout.setBounds(600,10,70,35);;

        panelDoctorDashB.add(history);

        history.setBounds(160,600,80,45);

        panelDoctorDashB.add(edit);

        edit.setBounds(350,600,100,45);

        panelDoctorDashB.add(addInfo);

        addInfo.setBounds(0,600,80,45);

        panelDoctorDashB.add(addnewPatient);

        addnewPatient.setBounds(460,600,125,45);


    }
}
