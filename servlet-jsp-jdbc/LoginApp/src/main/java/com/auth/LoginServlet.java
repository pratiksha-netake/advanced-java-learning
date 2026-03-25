package com.auth;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			Connection con=DBUtil.getConnection();
			PreparedStatement ps=con.prepareStatement(
					"select * from users where email=? and password=?"
					);
			ps.setString(1,email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession session=req.getSession();
				session.setAttribute("user",rs.getString("name"));
				res.sendRedirect("welcome.jsp");
				
			}else {
				res.sendRedirect("login.jsp?error=1");
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}