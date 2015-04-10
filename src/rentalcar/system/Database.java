package rentalcar.system;

/*
  User.java
  --
  Kendal Harland <kendaljharland@gmail.com>
  --
  Database API Client library for the rental car application.
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import rentalcar.web.Request;
import rentalcar.web.JSONRequest;
import rentalcar.data.FormObject;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;


public class Database {

  public static final Map<String, Integer> Locations;

  /** Maps location names to database constants */
  static {
    HashMap<String, Integer> nonConstLocations = new HashMap<String, Integer>();
    nonConstLocations.put("Atchison", 1);
    nonConstLocations.put("Belton", 11);
    nonConstLocations.put("Emporia", 21);
    nonConstLocations.put("Hiawatha", 31);
    nonConstLocations.put("Kansas City", 41);
    nonConstLocations.put("Lawrence", 51);
    nonConstLocations.put("Leavenworth", 61);
    nonConstLocations.put("Manhattan", 71);
    nonConstLocations.put("Platte City", 81);
    nonConstLocations.put("St Joseph", 91);
    nonConstLocations.put("Topeka", 101);
    nonConstLocations.put("Warrensburg", 111);
    Locations = Collections.unmodifiableMap(nonConstLocations);
  }
  

  /** Get the full list of locations */
  public String[] GetLocations() {
    return Locations.keySet().toArray(new String[Locations.size()]);
  }

  /** Get the location id for a location from the location's name */
  public Integer GetLocationId(String locationName) {
    return Locations.get(locationName);
  }

  /**
    JSONObject CreateReservation
    @desc  POST the server to create a new vehicle reservation
    @param reservation  The reservation to create
    @return a JSONObject containing a success or failure message
  */
  public JSONObject CreateReservation(FormObject reservation) {
    JSONRequest request = new JSONRequest();
    return request.POST("create/reservation/", reservation.ToQueryString());
  }

  /**
    JSONObject GetVehiclesByLocation
    @desc  GET all vehicles in a particular location's inventory
    @param locationid  The ID of the location
    @return a List of type JSONObject whose elements are vehicles
  */
  public List<JSONObject> GetVehiclesByLocation(int locationid) {
    Request request = new Request();
    List<JSONObject> vehicles = new ArrayList <JSONObject>();
    String response = request.GET("location/vehicles/"+Integer.toString(locationid));
    JSONArray vehicleStrings = new JSONArray(response);
    for (int i=0; i<vehicleStrings.length(); i++) {
      vehicles.add(vehicleStrings.getJSONObject(i));
    }
    return vehicles;
  }

  /** 
   * Get the full set of vehicle classes and their rental agreement counts at a 
   * specific location.
   */
  public HashMap<String, Integer> GetReservedVehicleClassCount(
      int locationid, String startDate, String endDate) {
    Request request = new Request();
    String url = "location/reservations/class/count/" + Integer.toString(locationid) + "/" + 
      startDate + "/" + endDate;
    JSONArray objects = new JSONArray(new JSONTokener(request.GET(url)));
    HashMap<String, Integer> classCounts = new HashMap<String, Integer>();
    for (int i=0; i<objects.length(); i++) {
      JSONObject object = objects.getJSONObject(i);
      classCounts.put(
        object.getString("class"),
        object.getInt("count"));
    }
    return classCounts;
  }

  /** 
   * Get the full set of vehicle classes and their quantities  at a 
   * specific location
   */
  public HashMap<String, Integer> GetVehicleClassCount(int locationid) {
    Request request = new Request();
    String url = "location/vehicles/class/count/" + Integer.toString(locationid);
    JSONArray objects = new JSONArray(new JSONTokener(request.GET(url)));
    HashMap<String, Integer> classCounts = new HashMap<String, Integer>();
    for (int i=0; i<objects.length(); i++) {
      JSONObject object = objects.getJSONObject(i);
      classCounts.put(
        object.getString("class"),
        object.getInt("count"));
    }
    return classCounts;
  }

   
}

