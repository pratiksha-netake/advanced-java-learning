package dao;

import java.sql.*;

import util.DBConnection;

public class AuthorDAO {

    public void addAuthor(String name, String bio) {
        String sql = "INSERT INTO authors(name, bio) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, bio);

            ps.executeUpdate();
            System.out.println("Author added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllAuthors() {
        String sql = "SELECT * FROM authors";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("author_id") + " - " + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}