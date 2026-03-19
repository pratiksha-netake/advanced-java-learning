package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Transaction;
import util.DBConnection;

public class TransactionDAO {
    public void saveTransaction(Connection con,Transaction txn) throws SQLException{
        
        String sql="insert into transactions(sender_id,receiver_id,amount,type,status)values(?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);

        ps.setInt(1, txn.getSenderId());
        ps.setInt(2, txn.getReceiveredId());
        ps.setDouble(3,txn.getAmount());
        ps.setString(4, txn.getType());
        ps.setString(5, txn.getStatus());

        ps.executeUpdate();
        
    }
}
