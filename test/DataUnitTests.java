
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import java.util.HashMap;

import rentalcar.web.JSONRequest;
import rentalcar.system.Database;
import rentalcar.data.FormObject;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class DataUnitTests {
  public static void main(String[] args) throws JSONException {

    // Instantiate a database client
    Database db = new Database();

    /// Get a list of available locations (unstable)
    String[] locations = db.GetLocations();
    
    /** 
     * Compare the number of vehicles at a location with a specific class to
     * the number of reserved vehicles in the same class at the same location
     * (location with location id of 1)
     */
    HashMap<String, Integer> countsV = db.GetVehicleClassCount(41);
    HashMap<String, Integer> countsR = db.GetReservedVehicleClassCount(41, "2016-01-01", "2015-01-01");
    Iterator<String> it = countsV.keySet().iterator();
      while (it.hasNext()) {
        String nextKey = it.next();
        System.out.print(nextKey+": Total ");
        System.out.print(countsV.get(nextKey));
        System.out.print(",  Reserved ");
      System.out.println(countsR.get(nextKey));
    }

    /// Print the tax rate for location 1
    System.out.println("Tax rate: " + db.GetTaxRate(1));

    /// Print the price for a Standard SUV rental
    HashMap<String, Double> classRates = db.GetVehicleClassRates("Standard SUV");
    System.out.println("vehicle class rates: ");
    System.out.println("weekly: " + classRates.get("weeklyprice").toString());
    System.out.println("daily: " + classRates.get("dailyprice").toString());

    /// Print the reservations for the user with userid 1
    System.out.println("Printing all reservations....");

    System.out.println(db.GetReservations(1) + "\n");

    // System.out.println(db.GetAllVehicles());

    // System.out.println(db.GetAllReservations());

    FormObject reservation = new FormObject();
    reservation.Set("startDate",    "2015-01-12");
    reservation.Set("endDate",      "2015-01-12");
    reservation.Set("vehicleClass", "Standard SUV");
    reservation.Set("locationId",   "1");
    reservation.Set("salesrepId",   "12");
    reservation.Set("customerId",   "1");
    reservation.Set("ccn",          "1111777712122323");
    reservation.Set("gps",          "1");
    reservation.Set("childSeat",    "0");
    reservation.Set("ktag",         "0");
    reservation.Set("roadside",     "1");
    reservation.Set("waiver",       "1");
    reservation.Set("accident",     "1");
    reservation.Set("totalCost",    "1320.44");
    String affectedRows = db.CreateReservation(reservation);
    System.out.println("created "+ affectedRows + " reservation(s)");
  }
}