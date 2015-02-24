package rentalcar.web;

/*
  APIClient.java
  --
  Kendal Harland <kendaljharland@gmail.com>
  --
  API Client library for the rental car application.
  The api client exposes the rentalcar application to all of the methods 
  provided by the rental car app server.
*/

import org.json.JSONObject;
import org.json.JSONArray; // delete
import java.util.List;
import java.util.ArrayList;
import rentalcar.web.Request; // delete
import rentalcar.web.JSONRequest;
import rentalcar.data.FormObject;

public class APIClient {

  /*
    JSONObject CreateReservation
    @desc  POST the server to create a new vehicle reservation
    @param reservation  The reservation to create
  */
  public static JSONObject CreateReservation(FormObject reservation) {
    JSONRequest request = new JSONRequest();
    return request.POST("create/reservation/", reservation.ToQueryString());
  }

  /*
    JSONObject GetVehiclesByLocation
    @desc  GET all vehicles in a particular location's inventory
    @param locationid  The ID of the location
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
