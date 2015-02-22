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
import rentalcar.web.JSONRequest;
import rentalcar.data.FormObject;

public class APIClient {

  public APIClient() {}

  /*
   JSONObject CreateReservation
   @desc  POST the server to create a new vehicle reservation
   @param reservation  The reservation to create
  */
  public static JSONObject CreateReservation(FormObject reservation) {
    JSONRequest request = new JSONRequest();
    return request.POST("create/reservation/", reservation.ToQueryString());
  }
};
