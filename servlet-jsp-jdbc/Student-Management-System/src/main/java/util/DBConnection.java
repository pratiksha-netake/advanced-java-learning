package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
		private static String url;
		private static String username;
		private static String password;
		private static String driver;
		private static String databasename;
		
		
		static {
			try {
				Properties props=new Properties();
				InputStream input=DBConnection.class
						.getClassLoader()
						.getResourceAsStream("db.properties");
				
				if(input==null) {
					throw new RuntimeException("db.properties file not found");
				}
				
				props.load(input);
				
				url=props.getProperty("db.url");
				username=props.getProperty("db.user");
				password=props.getProperty("db.password");
				driver=props.getProperty("db.driver");
				databasename=props.getProperty("db.databasename");
				
				System.out.println("DB Name:"+databasename);
				
				Class.forName(driver);
				
				Connection con=DriverManager.getConnection(url,username,password);
				Statement st=con.createStatement();
				
				st.executeUpdate("create database if not exists"+databasename);
				con.close();
				
				con=DriverManager.getConnection(url+databasename,username,password);
				st=con.createStatement();
				
				st.executeUpdate("create table if not exists Students("+
				"id int auto_increment, "+
						"name varchar(100),"+
				"email varchar(100),"+
						"course varchar(100)"
						
				
						);
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection() {
			Connection con=null;
			try {
				con=DriverManager.getConnection(url+databasename,username,password);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		
}
