import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class LoadDriver {
    
  static Connection conn = null;
  static Statement stmt = null;

  public static void main(String[] args) {
    try {
      // Make the connection
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ccb", "kharland", "@mcdaniel1");
      Statement stmt = conn.createStatement();
      String sql = "CREATE DATABASE RentalCar;";
      ResultSet rs = stmt.executeQuery(sql);
      // Extract data from the result set
      //while (rs.next()) {
      System.out.println(rs);
      //}
    } catch (SQLException ex) {  
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
    }
  }
}