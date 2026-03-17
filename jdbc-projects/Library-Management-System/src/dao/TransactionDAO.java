package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import util.DBConnection;

public class TransactionDAO {

    //
    public void issueBook(int bookId,int userId,Date issueDate,Date dueDate) throws SQLException{
        String sql="insert into transactions(book_id,user_id,issue_date,due_date) values(?,?,?,?)";
        try(Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setInt(1,bookId);
            ps.setInt(2, userId);
            ps.setDate(3, (java.sql.Date) issueDate);
            ps.setDate(4, (java.sql.Date) dueDate);
            ps.executeUpdate();

            //reduce book count
            java.sql.Statement stmt=conn.createStatement();
            stmt.executeUpdate("update books set copies_available=copies_available-1 where book_id="+bookId);
            System.out.println("Book issued !");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // return book

    public void returnBook(int transactionid, Date returnDate){
        String sql="update transactions set return_date=? where transaction_id=?";
        try(Connection conn=DBConnection.getConnection();
          PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setDate(1,(java.sql.Date) returnDate);
            ps.setInt(2,transactionid);
            ps.executeUpdate();

            System.out.println("Book returned !");

          }catch(Exception e){
            e.printStackTrace();
          }
    }
    
}

