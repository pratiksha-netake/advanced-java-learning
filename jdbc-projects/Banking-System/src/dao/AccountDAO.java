package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import util.DBConnection;

public class AccountDAO {

    public void createAccount(Account acc) throws Exception{
        Connection con=DBConnection.getConnection();
        String sql="insert into accounts(name,email,balance)values(?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);

        ps.setString(1, acc.getName());
        ps.setString(2, acc.getEmail());
        ps.setDouble(3, acc.getBalance());

        ps.executeUpdate();
        con.close();
    }

    public double getBalance(Connection con,int account_id) throws SQLException{
      
        String sql="select balance from accounts where account_id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,account_id);

        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            return rs.getDouble("balance");
        }
         return 0;
        

    }

    public static void updateBalance(Connection con,int account_id,double newBalance) throws SQLException{
        
        String sql="update accounts set balance=? where account_id=?";
        PreparedStatement ps=con.prepareStatement(sql);

        ps.setDouble(1, newBalance);
        ps.setInt(2, account_id);

        ps.executeUpdate();

    }   
}
