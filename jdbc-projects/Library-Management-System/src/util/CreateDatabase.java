package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;

        try {
            // 🔥 STEP 1: Connect WITHOUT database
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String password = "9822523083";

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            stmt = conn.createStatement();

            String dbName = "librarydb";

            // 🔥 STEP 2: Create database
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
            System.out.println("Database " + dbName + " created successfully!");

            // 🔥 STEP 3: Use database
            stmt.execute("USE " + dbName);

            // AUTHOR TABLE
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS authors(
                author_id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                bio TEXT
                )
            """);

            // CATEGORY TABLE
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS categories(
                category_id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(50) NOT NULL
                )
            """);

            // BOOK TABLE
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS books(
                book_id INT AUTO_INCREMENT PRIMARY KEY,
                title VARCHAR(150) NOT NULL,
                author_id INT,
                category_id INT,
                isbn VARCHAR(50),
                publication_year INT,
                copies_available INT,
                FOREIGN KEY(author_id) REFERENCES authors(author_id),
                FOREIGN KEY(category_id) REFERENCES categories(category_id)
                )
            """);

            // USER TABLE
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS users(
                user_id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                email VARCHAR(100) UNIQUE NOT NULL,
                membership_date DATE,
                max_books_allowed INT
                )
            """);

            // TRANSACTION TABLE
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS transactions(
                transaction_id INT AUTO_INCREMENT PRIMARY KEY,
                book_id INT,
                user_id INT,
                issue_date DATE,
                due_date DATE,
                return_date DATE,
                fine DOUBLE,
                FOREIGN KEY (book_id) REFERENCES books(book_id),
                FOREIGN KEY (user_id) REFERENCES users(user_id)
                )
            """);

            System.out.println("All tables created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}