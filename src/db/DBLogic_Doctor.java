package db;

import md5.MD5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBLogic_Doctor extends DBConnection{

    // check is username unique for doctor
    // returns "true" if username is unique, "false" if username already exists in DB
    public boolean isUsernameUnique(String username) throws SQLException {
        boolean isUnique = true;
        // connection to DB
        Connection conn = connectToDB();

        // sql statement to execute
        String select  = "SELECT username from doctor WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        // check if such doctor exists in DB
        if(rs.next()) {
            isUnique = false;
        }

        conn.close();

        return isUnique;
    }

    // check is certificate unique for doctor
    // returns "true" if certificate is unique, "false" if certificate already exists in DB
    public boolean isCertificateUnique(String certificate) throws SQLException {
        boolean isUnique = true;
        // connection to DB
        Connection conn = connectToDB();

        // sql statement to execute
        String select  = "SELECT id from doctor WHERE certificate = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setString(1, certificate);
        ResultSet rs = ps.executeQuery();

        // check if doctor with such certificate exists in DB
        if(rs.next()) {
            isUnique = false;
        }

        conn.close();

        return isUnique;
    }

    // register new doctor
    public boolean register(String name, String surname, String username, String password, String personal_code, String certificate, int clinic_id, String status) {

        try {
            if (isUsernameUnique(username) && isCertificateUnique(certificate)) {
                // connection to DB
                Connection conn = connectToDB();

                // object for password hashing
                MD5 passwordHash = new MD5();

                // sql statement to execute
                String sql = "INSERT INTO doctor (name, surname, username, password, personal_code, certificate, clinic_id, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, name);
                ps.setString(2, surname);
                ps.setString(3, username);
                ps.setString(4, passwordHash.getMd5(password));
                ps.setString(5, personal_code);
                ps.setString(6, certificate);
                ps.setInt(7, clinic_id);
                ps.setString(8, status);

                ps.executeUpdate();
                conn.close();

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // get doctor ID by username and password
    // returns doctor id or "-1" if doctor not found
    public int getDoctorId(String username, String password) throws SQLException {

        // connection to DB
        Connection conn = connectToDB();

        // object for password hashing
        MD5 passwordHash = new MD5();

        // sql statement to execute
        String select  = "SELECT id, username, password from doctor WHERE username = ? AND password = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setString(1, username);
        ps.setString(2, passwordHash.getMd5(password));
        ResultSet rs = ps.executeQuery();

        // check if such doctor exists in DB
        if(rs.next()) {
            return rs.getInt("id");
        }

        conn.close();

        return -1;
    }

    //get doctor name, surname by username
    // returns doctor, surname name or "" if doctor not found by username
    public String getName(String username) throws SQLException {
        String name = "";

        // connection to DB
        Connection conn = connectToDB();

        // sql statement to execute
        String select  = "SELECT name, surname from doctor WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        // get doctor name, surname by username
        if(rs.next()) {
            name = rs.getString("name") + " " + rs.getString("surname");
        }

        conn.close();

        return name;
    }

    //get list of doctors (name, surname, personal_code, status) by clinic_id
    public ArrayList<String> getDoctorList(int clinic_id) throws SQLException {
        ArrayList<String> doctorList = new ArrayList<String>();

        // connection to DB
        Connection conn = connectToDB();

        // sql statement to execute
        String select  = "SELECT name, surname, personal_code, status from doctor WHERE clinic_id = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setInt(1, clinic_id);
        ResultSet rs = ps.executeQuery();

        // get doctor name, surname by username
        while (rs.next()) {
            doctorList.add(rs.getString("name") + " " + rs.getString("surname") +
                    " " + rs.getString("personal_code") + " " + rs.getString("status"));
        }

        conn.close();

        return doctorList;
    }
}
