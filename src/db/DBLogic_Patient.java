package db;

import java.sql.*;
import java.util.ArrayList;

public class DBLogic_Patient extends DBConnection{

    // register new patient
    public boolean register(String name, String group, String breed, float weight, Date date_of_birth,
                            String passport_num, String owner_name, String owner_surname, int doctor_id) {

        try {
            // connection to DB
            Connection conn = connectToDB();

            // sql statement to execute
            String sql = "INSERT INTO patient (`name`, `group`, breed, weight, date_of_birth, passport_num, " +
                    "owner_name, owner_surname, doctor_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, group);
            ps.setString(3, breed);
            ps.setFloat(4, weight);
            ps.setDate(5, date_of_birth);
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

    // Get True status if patient exists
    public boolean ifPatientExists(int id) {
        boolean ifPatientExists = false;
        String sql = "SELECT name FROM patient WHERE id = ? LIMIT 1";

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
    public ArrayList<Integer> getPatientIds(int patient_id) throws SQLException {
        String sql1 = "SELECT passport_num FROM patient WHERE id = ? LIMIT 1";
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

    //get list of patients (name, group, breed, passport_num, owner_name, owner_surname) by doctor_id
    public ArrayList<String> getPatientList(int doctor_id) throws SQLException {
        ArrayList<String> patientList = new ArrayList<String>();

        // connection to DB
        Connection conn = connectToDB();

        // sql statement to execute
        String select  = "SELECT id, name, `group`, breed, passport_num, owner_name, owner_surname " +
                "from patient WHERE doctor_id = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setInt(1, doctor_id);
        ResultSet rs = ps.executeQuery();

        // get doctor name, surname by username
        while (rs.next()) {
            patientList.add(rs.getString("name") + " " + rs.getString("group") + " "
                    + rs.getString("breed") +" " + rs.getString("passport_num") + " "
                    + rs.getString("owner_name") + " " + rs.getString("owner_surname") + " " + rs.getInt("id"));
        }

        conn.close();

        return patientList;
    }

    public int getPatientId(String passport_num, int doctor_id) throws SQLException {

        // connection to DB
        Connection conn = connectToDB();

        // sql statement to execute
        String select  = "SELECT id from patient WHERE passport_num = ? and doctor_id = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setString(1, passport_num);
        ps.setInt(2, doctor_id);
        ResultSet rs = ps.executeQuery();

        // check if such patient exists in DB
        if(rs.next()) {
            return rs.getInt("id");
        }

        conn.close();

        return -1;
    }


    //get patient full info (all info about patient to update) by patient_id
    public ArrayList<String> getPatientAllInfoList(int patient_id) throws SQLException {
        ArrayList<String> patientAllInfo = new ArrayList<String>();

        // connection to DB
        Connection conn = connectToDB();

        // sql statement to execute
        String select  = "SELECT name, `group`, breed, weight, date_of_birth, passport_num, owner_name, " +
                "owner_surname from patient WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setInt(1, patient_id);
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

    // Get patient name and group by ID (array[name, group])
    // Returns NULL if patient is not found (array(null, null))
    public String[] getPatientNameAndGroup(int patient_id) throws SQLException {
        String sql = "SELECT `name`, `group` from patient WHERE id = ? LIMIT 1";
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

    // update existing patient data
    public boolean update(String name, String group, String breed,
                          String passport_num, String owner_name, String owner_surname, int doctor_id, int patient_id) {

        try {
            // connection to DB
            Connection conn = connectToDB();

            // sql statement to execute
//            String sql = "UPDATE patient SET name = ?, `group` = ?, breed = ?, weight= ?, date_of_birth = ?, " +
//                    "passport_num = ?, owner_name = ?, owner_surname = ? WHERE doctor_id = ? AND id = ? LIMIT 1";
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            ps.setString(1, name);
//            ps.setString(2, group);
//            ps.setString(3, breed);
//            ps.setFloat(4, weight);
//            ps.setDate(5, date_of_birth);
//            ps.setString(6, passport_num);
//            ps.setString(7, owner_name);
//            ps.setString(8, owner_surname);
//            ps.setInt(9, doctor_id);
//            ps.setInt(10, patient_id);
            String sql = "UPDATE patient SET name = ?, `group` = ?, breed = ?, " +
                    "passport_num = ?, owner_name = ?, owner_surname = ? WHERE doctor_id = ? AND id = ? LIMIT 1";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, group);
            ps.setString(3, breed);
            ps.setString(4, passport_num);
            ps.setString(5, owner_name);
            ps.setString(6, owner_surname);
            ps.setInt(7, doctor_id);
            ps.setInt(8, patient_id);

            ps.executeUpdate();
            conn.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
