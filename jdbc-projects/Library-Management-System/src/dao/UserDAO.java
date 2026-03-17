package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import util.DBConnection;

public class UserDAO {
    public void addUser(String name,String email, Date membershipDate,int maxbooks){
        String sql="Insert into users(name,email,membership_date,max_books_allowed)values(?,?,?,?)";
        try(Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(sql))

        {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setDate(3, (java.sql.Date) membershipDate);
            ps.setInt(4,maxbooks);

            ps.executeUpdate();
            System.out.println("User added !");
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }

    public void getAllUsers() throws SQLException{
        String sql="Select * from users";
        try(Connection conn=DBConnection.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql)){
            while(rs.next()){
                System.out.println(rs.getInt("user_id")+" - "+ rs.getString("name"));
          
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
