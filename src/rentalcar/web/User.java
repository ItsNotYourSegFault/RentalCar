package rentalcar.web;

/*
  User.java
  --
  Kendal Harland <kendaljharland@gmail.com>
  --
  User API Client library for the rental car application.
*/

import org.json.JSONObject;
import org.json.JSONArray;
import java.util.List;
import java.util.ArrayList;
import rentalcar.web.Request;
import rentalcar.web.JSONRequest;
import rentalcar.data.FormObject;

public class User {

  private JSONObject user = null;

  /*
    bool LogIn
    @desc  Find the user whose credentials match username and password
    @param user  Form with the user's login credentials
    @return upon success, a JSONObject representing a user is returned. else
            an empty JSON object is returned.
  */
  public static bool LogIn(FormObject user) {
    JSONRequest request = new JSONRequest();
    JSONObject info = request.POST("user/login/", user.ToQueryString());
    userInfo = info;
    return true;
  }

  /*
    JSONObject CreateReservation
    @desc  POST the server to create a new vehicle reservation
    @param reservation  The reservation to create
    @return a JSONObject containing a success or failure message
  */
  public static JSONObject CreateReservation(FormObject reservation) {
    JSONRequest request = new JSONRequest();
    return request.POST("create/reservation/", reservation.ToQueryString());
  }

  /*
    JSONObject GetVehiclesByLocation
    @desc  GET all vehicles in a particular location's inventory
    @param locationid  The ID of the location
    @return a List of type JSONObject whose elements are vehicles
  */
  public static List<JSONObject> GetVehiclesByLocation(int locationid) {
    Request request = new Request();
    List<JSONObject> vehicles = new ArrayList<JSONObject>();
    String response = request.GET("location/vehicles/"+Integer.toString(locationid));
    JSONArray vehicleStrings = new JSONArray(response);
    for (int i=0; i<vehicleStrings.length(); i++) {
      vehicles.add(vehicleStrings.getJSONObject(i));
    }
    return vehicles;
  }
};