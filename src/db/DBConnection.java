package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private final String DB = "jdbc:mysql://195.201.232.243:3309/rcs_vet";
    private final String USER = "rcs_vet_user";
    private final String PASS = "An0thrS3crt";


    // connection to DB
    public Connection connectToDB() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
