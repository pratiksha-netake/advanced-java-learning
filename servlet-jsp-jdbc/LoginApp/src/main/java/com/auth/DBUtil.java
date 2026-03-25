package com.auth;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {

    private static String url;
    private static String username;
    private static String password;
    private static String driver;
    private static String databasename;

    // Static block runs once
    static {
        try {
            // Load properties file
            Properties props = new Properties();
            InputStream input = DBUtil.class
                    .getClassLoader()
                    .getResourceAsStream("db.properties");   // ✅ FIXED

            if (input == null) {
                throw new RuntimeException("db.properties file not found");
            }

            props.load(input);

            // Read values
            url = props.getProperty("db.url");
            username = props.getProperty("db.user");
            password = props.getProperty("db.password");
            driver = props.getProperty("db.driver");
            databasename = props.getProperty("db.databasename");

            System.out.println("DB Name: " + databasename); // debug

            // Load driver
            Class.forName(driver);

            // Step 1: connect without DB
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            // Step 2: create DB
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + databasename);
            con.close();

            // Step 3: connect with DB
            con = DriverManager.getConnection(url + databasename, username, password);
            st = con.createStatement();

            // Step 4: create table
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "email VARCHAR(100), " +
                "password VARCHAR(100))"
            );

            con.close();

            System.out.println("✅ Database & Table Ready");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to get connection
    public static Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(url + databasename, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}