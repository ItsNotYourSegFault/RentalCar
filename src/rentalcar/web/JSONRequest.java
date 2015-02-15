package rentalcar.web;

/*
  JSONRequest.java
  --
  Kendal Harland <kendaljharland@gmail.com>
  --
  Wrapper for rentalcar.web.Request that parses a response into a JSON object.
 */

import rentalcar.web.Request;
import org.json.JSONObject;

public class JSONRequest {

  public JSONRequest() {}

  public static JSONObject GET (String url) {
    Request request = new Request();
    String response = request.GET(url);
    jsonObject = new JSONObject();
    // parse the object ...
    return jsonObject;
  }

  public static JSONObject PUT (String url) {
    Request request = new Request();
    String response = request.PUT(url);
    jsonObject = new JSONObject();
    // parse the object ...
    return jsonObject;
  }
  
  public static JSONObject DELETE (String url) {
    Request request = new Request();
    String response = request.DELETE(url);
    jsonObject = new JSONObject();
    // parse the object ...
    return jsonObject; 
  }

  // public static JSONObject POST (String url, String params) {
  //   Request request = new Request();
  //   String response = request.GET(url, params);
  // }
};