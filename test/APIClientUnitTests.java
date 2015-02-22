import rentalcar.data.FormObject;
import rentalcar.web.APIClient;

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

public class APIClientUnitTests {
  public static void main(String[] args) {
    APIClient client = new APIClient();
    // Test create fake reservation
    FormObject reservation = new FormObject();
    reservation.Set("vin",        "123456");
    reservation.Set("customerid", "1");
    reservation.Set("salesid",    "1");
    reservation.Set("totalcost",  "4999.99");
    reservation.Set("startmiles", "1000");
    reservation.Set("endmiles",   "2000");
    reservation.Set("services",   "5");
    reservation.Set("equipment",  "5");
    client.CreateReservation(reservation);
  }
}