package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.util.Properties;

import model.Student;

public class StudentDAO {

    private String url;
    private String USER;
    private String PASS;

    public StudentDAO() {

        try {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("config.properties");
            prop.load(fis);

            url = prop.getProperty("db.url");
            USER = prop.getProperty("db.user");
            PASS = prop.getProperty("db.password");

            createDatabaseAndTable();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, USER, PASS);
    }

    // create database and table automatically
    private void createDatabaseAndTable() {

        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS studentInfo");
            stmt.executeUpdate("USE studentInfo");

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS students(" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(50) NOT NULL," +
                "email VARCHAR(50) NOT NULL," +
                "age INT," +
                "course VARCHAR(50))"
            );

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // add student
    public void addStudent(Student student) {

        String sql = "INSERT INTO studentInfo.students(name,email,age,course) VALUES(?,?,?,?)";

        try(Connection conn = getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, student.getName());
            pst.setString(2, student.getEmail());
            pst.setInt(3, student.getAge());
            pst.setString(4, student.getCourse());

            pst.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // get all students
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM studentInfo.students";

        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()) {

                Student s = new Student();

                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setAge(rs.getInt("age"));
                s.setCourse(rs.getString("course"));

                students.add(s);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    // update student
    public void updateStudent(Student student) {

        String sql = "UPDATE studentInfo.students SET name=?,email=?,age=?,course=? WHERE id=?";

        try(Connection conn = getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, student.getName());
            pst.setString(2, student.getEmail());
            pst.setInt(3, student.getAge());
            pst.setString(4, student.getCourse());
            pst.setInt(5, student.getId());

            pst.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // delete student
    public void deleteStudent(int id) {

        String sql = "DELETE FROM studentInfo.students WHERE id=?";

        try(Connection conn = getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, id);
            pst.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}