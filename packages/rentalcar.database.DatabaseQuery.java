package rentalcar.database.DatabaseQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseQuery {

  static String DB_NAME  = "RentalCar";
  static String USERNAME = "kharland";//"RentalCarClient";
  static String PASSWORD = "@mcdaniel1";//"ItsNotYourSegFault";

  public DatabaseQuery(String username, String password) {
    // store username and password
  }

  public DatabaseQuery() {}

  private Connection _connect_to_database() {

  }

  public Execute(String username, String password, String query) {
    Connection conn = _connect_to_database(username, password);
  }

  public Execute(String query) {
    if (/* username and password not set */) {
      // error
    } else {
      // execute query
    }
  }
}
import rentalcar.DatabaseQuery