package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    
    
    public static Connection getConnection(){
         Connection connection=null;
        try{

            Properties props=new Properties();
            InputStream input=new FileInputStream("resources/db.properties");
            props.load(input);

            String url=props.getProperty("db.url");
            String username=props.getProperty("db.username");
            String password=props.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection=DriverManager.getConnection(url, username, password);
            System.out.println("Connected to mysql database successfully !");
        }catch(IOException e){
            System.out.println("error loading db properties file");
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            System.out.println("mysql jdbc driver not found");
            e.printStackTrace();
        }catch(SQLException e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }

        return connection;
    }


}
