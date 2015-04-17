

import java.util.Set;
import java.util.Iterator;
import java.util.HashMap;

import rentalcar.web.JSONRequest;
import rentalcar.system.Database;
import rentalcar.data.FormObject;
import org.json.JSONObject;
import org.json.JSONArray;

public class DataUnitTests {
  public static void main(String[] args) {

    // Instantiate a database client
    Database db = new Database();

    /// Get a list of available locations (unstable)
    String[] locations = db.GetLocations();
    
    /** 
     * Compare the number of vehicles at a location with a specific class to
     * the number of reserved vehicles in the same class at the same location
     * (location with location id of 1)
     */
    HashMap<String, Integer> countsV = db.GetVehicleClassCount(1);
    HashMap<String, Integer> countsR = db.GetReservedVehicleClassCount(1, "2016-01-01", "2015-01-01");
    Iterator<String> it = countsV.keySet().iterator();
      while (it.hasNext()) {
        String nextKey = it.next();
        System.out.print(nextKey+": Total ");
        System.out.print(countsV.get(nextKey));
        System.out.print(",  Reserved ");
      System.out.println(countsR.get(nextKey));
    }

    /// Print the tax rate for location 1
    System.out.println(db.GetTaxRate(1));

    /// Print the price for a Standard SUV rental
    System.out.println("vehicle class rates: " + db.GetVehicleClassRates("Standard SUV").toString());

    /// Print the reservations for the user with userid 1
    System.out.println(db.GetReservations(1));

    /// Print all vehicles
    System.out.println(db.GetAllVehicles());
  }
}