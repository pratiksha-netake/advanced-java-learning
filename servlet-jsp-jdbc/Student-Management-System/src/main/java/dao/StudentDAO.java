package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Student;
import util.DBConnection;

public class StudentDAO {
	
	public void insertStudent(Student s) {
		try {
			Connection con=DBConnection.getConnection();
			String sql="insert into students(name,email,course)values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3,s.getCourse());
			ps.executeUpdate();					 			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Student> getAllStudents(){
		List<Student> list= new ArrayList();
		try {
			Connection con=DBConnection.getConnection();
			String sql="select * from students";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()) {
				Student s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setCourse(rs.getString("course"));
				list.add(s);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public void deleteStudent(int id) {
		try {
			Connection con=DBConnection.getConnection();
			String sql="delete from students where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Student  getStudentById(int id) {
		Student s = new Student();
		try {
			Connection con=DBConnection.getConnection();
			String sql="select * from students where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setCourse(rs.getString("course"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	
	public void updateStudent(Student s) {
		try {
			Connection con=DBConnection.getConnection();
			String sql="update students set name=?,email=?,course=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getCourse());
			ps.setInt(4,s.getId());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
