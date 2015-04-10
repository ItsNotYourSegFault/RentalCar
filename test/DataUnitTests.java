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
    Database db = new Database();
    String location;
    int locationId;
    String[] locations = db.GetLocations();


    /** Garbage */
    // FormObject res = new FormObject();
    // res.Set("test", "value");
    // System.out.println(res.ToQueryString());
    
    // location = locations[5];

    /**
     * Example of iterating over the vehicle class names and the number of
     * vehicles for that class at a location
     */
    
    //Fetch the list of classes and their vehicle counts
    System.out.println(db.GetReservationClassCount(1, "2016-01-01", "2015-01-01"));
    System.out.println(db.GetVehicleClassCount(1));
    
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

  }
}