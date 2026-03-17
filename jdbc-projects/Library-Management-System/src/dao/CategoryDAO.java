package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DBConnection;

public class CategoryDAO {

    public void addCategory(String name){
    String sql="insert into categories(name) values(?)";

    try(Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement(sql)){
        ps.setString(1, name);
        ps.executeUpdate();

        System.out.println("Category added !");

    }catch(Exception e){
        e.printStackTrace();
    }
 }

public void getAllCategories(){
    String sql="select * from categories";
    try(Connection conn=DBConnection.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql)){

            while(rs.next()){
                System.out.println(rs.getInt("category_id")+" - "+rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
}

}
