package db;

import md5.MD5;

import java.sql.*;

public class DBLogic_Clinic extends DBConnection{

    // register new clinic
    public void register (String name, String email, String phone, String legal_address, String physical_address, String reg_number, String username, String password) {
        try {

            // connection to DB
            Connection conn = connectToDB();

            // object for password hashing
            MD5 passwordHash = new MD5();

            // sql statement to execute
            String sql = "INSERT INTO clinic (name, email, phone, legal_address, physical_address, reg_number, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, legal_address);
            ps.setString(5, physical_address);
            ps.setString(6, reg_number);
            ps.setString(7, username);
            ps.setString(8, passwordHash.md5(password));

            ps.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // login as a clinic
    public boolean login(String username, String password) throws SQLException {
        boolean isLoggedIn = false;

        // connection to DB
        Connection conn = connectToDB();

        // object for password hashing
        MD5 passwordHash = new MD5();

        // sql statement to execute
        String select  = "SELECT username, password from clinic WHERE username = ? AND password = ?";
        PreparedStatement ps = conn.prepareStatement(select);

        ps.setString(1, username);
        ps.setString(2, passwordHash.md5(password));
        ResultSet rs = ps.executeQuery();

        // check if such clinic exists in DB
        if(rs.next()) {
            isLoggedIn = true;
            System.out.println("Success");
        } else {
            System.out.println("Clinic not found");
        }

        conn.close();

        return isLoggedIn;
    }

    //get clinic name by username
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
            System.out.println(name);
        } else {
            System.out.println("Clinic not found");
        }

        conn.close();

        return name;
    }

}
