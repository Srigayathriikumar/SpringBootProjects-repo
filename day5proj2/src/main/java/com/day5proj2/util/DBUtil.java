package com.day5proj2.util;

import java.sql.DriverManager;
import java.sql.Connection;

public class DBUtil {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "root123"
            );
        } catch (Exception e) {
            System.err.println("Error loading driver or connecting to database");
            e.printStackTrace();
        }
        return con;
    }
}
