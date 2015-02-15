package rentalcar.web;

import rentalcar.web.Request;
import rentalcar.web.JSONObject;

public class JSONRequest {

  public JSONRequest() {}

  public static JSONObject GET (String url) {
    Request request = new Request();
    String response = request.GET(url);
  }

  // public static JSONObject POST (String url, String params) {
  //   Request request = new Request();
  //   String response = request.GET(url, params);
  // }

  // public static JSONObject PUT (String url) {}
  // public static JSONObject DELETE (String url) {}
};