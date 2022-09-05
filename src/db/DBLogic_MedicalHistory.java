package db;

import java.sql.*;
import java.util.ArrayList;

public class DBLogic_MedicalHistory extends DBConnection {

    // Create medical history record for doctor's patient
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

    // Get full medical history of patient
    // Returns empty list if patient isn't found
    public ArrayList<String> getMedicalHistoryOfPatient(int patient_id) throws SQLException {
        DBLogic_Patient dbPatient = new DBLogic_Patient();
        ArrayList<String> meedicalHistoryOfPatient = new ArrayList<String>();

        String sql = "SELECT mh.date_of_diagnosis, mh.diagnosis, mh.medical_manipulation, mh.medicaments, " +
                "dc.name as doctor_name, dc.surname as doctor_surname, cl.name as clinic_name " +
                "FROM medical_history mh " +
                "JOIN doctor dc ON mh.doctor_id = dc.id " +
                "JOIN clinic cl ON dc.clinic_id = cl.id " +
                "WHERE mh.patient_id = ?";

        ArrayList<Integer> patientIds = dbPatient.getPatientIds(patient_id);

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
