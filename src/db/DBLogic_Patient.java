package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class DBLogic_Patient extends DBConnection{

    // register new doctor
    public boolean register(String name, String group, String breed, float weight, Date date_of_birth, String passport_num, String owner_name, String owner_surname, int doctor_id) {

        try {
            // connection to DB
            Connection conn = connectToDB();

            // sql statement to execute
            String sql = "INSERT INTO patient (`name`, `group`, breed, weight, date_of_birth, passport_num, " + "owner_name, owner_surname, doctor_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, group);
            ps.setString(3, breed);
            ps.setFloat(4, weight);
            ps.setDate(5, (java.sql.Date) date_of_birth);
            ps.setString(6, passport_num);
            ps.setString(7, owner_name);
            ps.setString(8, owner_surname);
            ps.setInt(9, doctor_id);

            ps.executeUpdate();
            conn.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //get list of patients (name, group, breed, passport_num, owner_name, owner_surname) by doctor_id
    public ArrayList<String> getPatientList(String doctor_id) throws SQLException {
        ArrayList<String> patientList = new ArrayList<String>();

        // connection to DB
        Connection conn = connectToDB();

        // sql statement to execute
        String select  = "SELECT name, `group`, breed, passport_num, owner_name, owner_surname from patient WHERE doctor_id = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setString(1, doctor_id);
        ResultSet rs = ps.executeQuery();

        // get doctor name, surname by username
        while (rs.next()) {
            patientList.add(rs.getString("name") + " " + rs.getString("group") + " " + rs.getString("breed") +" " + rs.getString("passport_num") + " " + rs.getString("owner_name") + " " + rs.getString("owner_surname"));
        }

        conn.close();

        return patientList;
    }

    //get patient full info (all info about patient to update) by pacient_id
    public ArrayList<String> getPatientAllInfoList(String patient_id) throws SQLException {
        ArrayList<String> patientAllInfo = new ArrayList<String>();

        // connection to DB
        Connection conn = connectToDB();

        // sql statement to execute
        String select  = "SELECT name, `group`, breed, weight, date_of_birth, passport_num, owner_name, owner_surname from patient WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setString(1, patient_id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            patientAllInfo.add(rs.getString("name"));
            patientAllInfo.add(rs.getString("group"));
            patientAllInfo.add(rs.getString("breed"));
            patientAllInfo.add(rs.getString("passport_num"));
            patientAllInfo.add(rs.getString("owner_name"));
            patientAllInfo.add(rs.getString("owner_surname"));
        }
        conn.close();

        return patientAllInfo;
    }



}
