package rentalcar.web;

/*
  JSONRequest.java
  --
  Kendal Harland <kendaljharland@gmail.com>
  --
  Wrapper for rentalcar.web.Request that parses a response into a JSON object.
*/

import rentalcar.web.Request;
import org.json.JSONTokener;
import org.json.JSONObject;

public class JSONRequest {

  public JSONRequest() {}

  public static JSONObject GET (String url) {
    Request request = new Request();
    String response = request.GET(url);
    return new JSONObject(new JSONTokener(response));
  }

  public static JSONObject PUT (String url) {
    Request request = new Request();
    String response = request.PUT(url);
    return new JSONObject(new JSONTokener(response));
  }
  
  public static JSONObject DELETE (String url) {
    Request request = new Request();
    String response = request.DELETE(url);
    return new JSONObject(new JSONTokener(response));
  }

  public static JSONObject POST (String url, String params) {
    Request request = new Request();
    String response = request.POST(url, params);
    System.out.println(response);
    return new JSONObject(new JSONTokener(response));
  }
};