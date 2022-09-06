import javax.swing.*;
import java.awt.*;

public class ClinicDashBoard extends Fields_ClinicDashBoard{

    public void clinicDash (){
        panelClinicDashB.setVisible(true);
        panelClinicDashB.setLayout(null);
        panelClinicDashB.setBackground(Color.LIGHT_GRAY);

        panelClinicDashB.add(yourDashB);

        yourDashB.setBounds(270,10,300,70);

        panelClinicDashB.add(logout);

        logout.setBounds(600,10,70,35);

        panelClinicDashB.add(addNewDoc);

        addNewDoc.setBounds(460,600,125,45);

        panelClinicDashB.add(edit);

        edit.setBounds(350,600,100,45);

        panelClinicDashB.add(block);

        block.setBounds(160,600,80,45);

        panelClinicDashB.add(unblock);

        unblock.setBounds(70,600,80,45);

        panelClinicDashB.add(clinName);

        clinName.setBounds(20,10,300,50);










    }
}