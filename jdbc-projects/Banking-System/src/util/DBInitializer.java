package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBInitializer {
    public static void initialize(){
        try{
            Connection con=DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASS);

            Statement stmt=con.createStatement();

            stmt.executeUpdate("create database if not exists bankdb");
            stmt.executeUpdate("use bankdb");

             stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS accounts (" +
                            "account_id INT AUTO_INCREMENT PRIMARY KEY," +
                            "name VARCHAR(100)," +
                            "email VARCHAR(100)," +
                            "balance DOUBLE," +
                            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                            ")"
            );

              stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS transactions (" +
                            "transaction_id INT AUTO_INCREMENT PRIMARY KEY," +
                            "sender_id INT," +
                            "receiver_id INT," +
                            "amount DOUBLE," +
                            "type VARCHAR(20)," +
                            "status VARCHAR(20)," +
                            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                            ")"
            );

            con.close();


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
