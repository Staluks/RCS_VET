package db;

import md5.MD5;

import java.sql.*;

public class DBLogic_Clinic extends DBConnection{

    // check is username unique for clinic
    // returns "true" if username is unique, "false" if username already exists in DB
    public boolean isUsernameUnique(String username) throws SQLException {
        boolean isUnique = true;
        // connection to DB
        Connection conn = connectToDB();

        // sql statement to execute
        String select  = "SELECT username from clinic WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        // check if such clinic exists in DB
        if(rs.next()) {
            isUnique = false;
        }

        conn.close();

        return isUnique;
    }

    // register new clinic
    public boolean register(String name, String email, String phone, String legal_address, String physical_address,
                            String reg_number, String username, String password) {

        try {
            if (isUsernameUnique(username)) {
                // connection to DB
                Connection conn = connectToDB();

                // object for password hashing
                MD5 passwordHash = new MD5();

                // sql statement to execute
                String sql = "INSERT INTO clinic (name, email, phone, legal_address, physical_address, " +
                        "reg_number, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, phone);
                ps.setString(4, legal_address);
                ps.setString(5, physical_address);
                ps.setString(6, reg_number);
                ps.setString(7, username);
                ps.setString(8, passwordHash.getMd5(password));

                ps.executeUpdate();
                conn.close();

                return true;
            }
        } catch (SQLException e) {
                e.printStackTrace();
            }

        return false;
    }

    // get clinic ID by username and password
    // returns clinic id or "-1" if clinic not found
    public int getClinicId(String username, String password) throws SQLException {

        // connection to DB
        Connection conn = connectToDB();

        // object for password hashing
        MD5 passwordHash = new MD5();

        // sql statement to execute
        String select  = "SELECT id, username, password from clinic WHERE username = ? AND password = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setString(1, username);
        ps.setString(2, passwordHash.getMd5(password));
        ResultSet rs = ps.executeQuery();

        // check if such clinic exists in DB
        if(rs.next()) {
            return rs.getInt("id");
        }

        conn.close();

        return -1;
    }

    //get clinic name by username
    // returns clinic name or "" if clinic not found by username
    public String getName(String username) throws SQLException {
        String name = "";

        // connection to DB
        Connection conn = connectToDB();

        // sql statement to execute
        String select  = "SELECT name from clinic WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        // get clinic name by username
        if(rs.next()) {
            name = rs.getString("name");
        }

        conn.close();

        return name;
    }
}
