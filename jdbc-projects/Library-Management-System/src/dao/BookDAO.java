package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBConnection;

public class BookDAO {
    //add book
    public void addBook(String title,int authorId,int categoryId, String isbn,int year,int copies)
    {
    String sql="insert into books(title,author_id,category_id,isbn,publication_year,copies_available)values(?,?,?,?,?,?)";

    try(Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement(sql)){
        ps.setString(1, title);
        ps.setInt(2, authorId);
        ps.setInt(3, categoryId);
        ps.setString(4, isbn);
        ps.setInt(5,year);
        ps.setInt(6,copies);

        ps.executeUpdate();
        System.out.println("Book added Successfully !");
    }catch(Exception e){
        e.printStackTrace();
    }

    }


    //get all books
    public void getAllBooks() throws SQLException{
        String sql="select * from books";
        try(Connection conn=DBConnection.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql)){
            while(rs.next()){
                System.out.println(rs.getInt("book_id")+" - "+rs.getString("title"));
            }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }

    public void deleteBook(int bookId){
        String sql="delete from books where book_id=?";
        try(Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setInt(1,bookId);
            ps.executeUpdate();
            System.out.println("book deleted");


        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

