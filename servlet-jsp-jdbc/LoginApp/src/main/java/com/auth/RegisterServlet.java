package com.auth;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			Connection con=DBUtil.getConnection();
			PreparedStatement ps=con.prepareStatement(
					"insert into users(name,email,password)values(?,?,?)"
					);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			
			ps.executeUpdate();
			res.sendRedirect("login.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	}
	
