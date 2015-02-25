import java.util.List;
import java.util.ArrayList;
import org.json.JSONObject;
import rentalcar.data.FormObject;
import rentalcar.web.User;

/*
  WebUnitTests.java
  --
  Kendal Harland <kendaljharland@gmail.com>
  Siddhant Sethi <siddhant.sethi91@gmail.com>
  Stephanie Sammons <chirox90@gmail.com>
  Grant Hays <granthays@gmail.com>
  Jackson Montgomery <j573m923@ku.edu>
  Lei Wang <l290w868@gmail.com>
  Greg Pregulman <gpregulman@gmail.com>
  --
  Unit tests for the rentalcar.web package
 */

public class UserUnitTests {
  public static void main(String[] args) {
    User client = new User();

    // Attempt to log in to the server
    FormObject user = new FormObject();
    user.Set("username", "kjh");
    user.Set("password", "kendalharland");
    client.LogIn(user);

    // Test create fake reservation
    FormObject reservation = new FormObject();
    reservation.Set("vehicleid",  "777777");
    reservation.Set("locationid", "1");
    reservation.Set("customerid", "1");
    reservation.Set("salesid",    "1");
    reservation.Set("totalcost",  "4999.99");
    reservation.Set("startmiles", "1000");
    reservation.Set("endmiles",   "2000");
    client.CreateReservation(reservation);

    // Test retrieve list of vehicles
    List<JSONObject> vehicles = client.GetVehiclesByLocation(51);
    System.out.println("VEHICLES: ");
    for (int i=0; i<vehicles.size(); i++) {
      System.out.println(vehicles.get(i)); // JSON Object prints as unparsed string
    }
  }
}