package db;

import java.sql.*;
import java.util.ArrayList;

public class DBLogic_MedicalHistory extends DBConnection {

    // Create medical history record
    public boolean register(int patient_id, int doctor_id, String diagnosis, Date date_of_diagnosis,
                            String medical_manipulation, String medicaments) {

        try {
            String sql = "INSERT INTO medical_history (patient_id, doctor_id, diagnosis, date_of_diagnosis, " +
                    "medical_manipulation, medicaments) VALUES (?, ?, ?, ?, ?, ?)";

            Connection conn = connectToDB();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, patient_id);
            ps.setInt(2, doctor_id);
            ps.setString(3, diagnosis);
            ps.setDate(4, date_of_diagnosis);
            ps.setString(5, medical_manipulation);
            ps.setString(6, medicaments);

            ps.executeUpdate();
            conn.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Get patient name and group by ID (array[name, group])
    // Return NULL if patient is not found (array(null, null))
    public String[] getPatient(int patient_id) throws SQLException {
        String sql = "SELECT `name`, `group` from patient WHERE id = ?";
        String[] patient = new String[2];

        Connection conn = connectToDB();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, patient_id);
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            patient[0] = rs.getString("name");
            patient[1] = rs.getString("group");
        }

        rs.close();
        ps.close();
        conn.close();

        return patient;
    }

    // Get True status if patient exists
    private boolean ifPatientExists(int id) {
        boolean ifPatientExists = false;
        String sql = "SELECT name FROM patient WHERE id = ?";

        Connection conn = connectToDB();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                ifPatientExists = true;
            }

            rs.close();
            ps.close();
        } catch (SQLException excptn) {
            excptn.printStackTrace();
        }

        return ifPatientExists;
    }

    // Get certain patient IDs by patient ID
    // Returns empty list if patient isn't found
    private ArrayList<Integer> getPatientIds(int patient_id) throws SQLException {
        String sql1 = "SELECT passport_num FROM patient WHERE id = ?";
        String sql2;
        String passport_nr = null;
        ArrayList<Integer> patientIds = new ArrayList<>();

        if (ifPatientExists(patient_id)) {
            Connection conn = connectToDB();

            // Get passport Nr. of patient
            PreparedStatement ps1 = conn.prepareStatement(sql1);

            ps1.setInt(1, patient_id);
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                passport_nr = rs1.getString("passport_num");
            }

            rs1.close();
            ps1.close();

            // Get all patients with same passport Nr.
            if (passport_nr == null) {
                sql2 = "SELECT id FROM patient WHERE passport_num is ?";
            } else {
                sql2 = "SELECT id FROM patient WHERE passport_num = ?";
            }

            PreparedStatement ps2 = conn.prepareStatement(sql2);

            ps2.setString(1, passport_nr);
            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                patientIds.add(rs2.getInt("id"));
            }

            rs2.close();
            ps2.close();
            conn.close();
        }

        return patientIds;
    }

    // Get full medical history of patient
    // Returns empty list if patient isn't found
    public ArrayList<String> getMedicalHistoryOfPatient(int patient_id) throws SQLException {
        ArrayList<String> meedicalHistoryOfPatient = new ArrayList<String>();

        String sql = "SELECT mh.date_of_diagnosis, mh.diagnosis, mh.medical_manipulation, mh.medicaments, " +
                "dc.name as doctor_name, dc.surname as doctor_surname, cl.name as clinic_name " +
                "FROM medical_history mh " +
                "JOIN doctor dc ON mh.doctor_id = dc.id " +
                "JOIN clinic cl ON dc.clinic_id = cl.id " +
                "WHERE mh.patient_id = ?";

        ArrayList<Integer> patientIds = getPatientIds(patient_id);

        Connection conn = connectToDB();

        PreparedStatement ps = conn.prepareStatement(sql);

        for (int patientId: patientIds) {
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                meedicalHistoryOfPatient.add(String.valueOf(rs.getDate("mh.date_of_diagnosis")) + " " +
                        rs.getString("mh.diagnosis") + " " +
                        rs.getString("mh.medical_manipulation") + " " +
                        rs.getString("mh.medicaments") + " " +
                        rs.getString("doctor_name") + " " +
                        rs.getString("doctor_surname") + " " +
                        rs.getString("clinic_name")
                );
            }

            rs.close();
        }

        ps.close();
        conn.close();

        return meedicalHistoryOfPatient;
    }
}
