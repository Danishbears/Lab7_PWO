import java.sql.*;
import javax.sql.*; 
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DockerConnectMySql {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://db:3306/bookAPI";

   static final String USER = "DB";
   static final String PASS = "aaaaaa";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM `Cloud202191299` ";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
         int age  = rs.getInt("Wiek");
         String first = rs.getString("Imie");
         String last = rs.getString("Nazwisko");
	
         System.out.println("Wiek: " + age);
         System.out.println(", Imie: " + first);
         System.out.println(", Nazwisko: " + last);
      }
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
 }
}

