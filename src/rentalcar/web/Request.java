package rentalcar.web;

/*
  Request.java
  --
  Kendal Harland <kendaljharland@gmail.com>
  --
  Wrapper class that handles sending GET, POST, PUT and DELETE requests over
  http.
*/

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Request {

  final static String EMPTY_RESPONSE = "{}";

  private static final String SERVER = "https://rentalcar.herokuapp.com/";
  //private static final String SERVER = "http://localhost:3000/";

  private static void _handleHTTPError(int code) {
    System.out.println("x A web request failed with code " + code + ". Implement _handleHTTPError");
  }

  private String _request(String _url, String _method) {
    try {
      URL url = new URL(SERVER + _url);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setRequestMethod(_method);
      int status = conn.getResponseCode();
      if (status != 200) // and exception was not thrown
        _handleHTTPError(status);
      InputStreamReader reader = new InputStreamReader(conn.getInputStream());
      int data;
      String response = "";
      while ((data = reader.read()) > 0)
        response += (char)data;
      conn.disconnect();
      return response;
    } catch (MalformedURLException e) {
      System.out.println("x MalformedURLException: " + e.getMessage());
      return EMPTY_RESPONSE;
    } catch (IOException e) {
      System.out.println("x IOException: " + e.getMessage());
      return EMPTY_RESPONSE;
    }
  }

  public Request() {}

  public String GET (String _url)  {
    String response = _request(_url, "GET");
    return response;
  }

  public String PUT (String _url) {
    String response = _request(_url, "PUT");
    return response;
  } 

  public String DELETE (String _url) {
    String response = _request(_url, "DELETE");
    return response;
  }
  
  public static String POST (String _url, String params) {
    try {
      URL url = new URL(SERVER + _url);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setDoOutput(true);
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      conn.setRequestProperty("Content-Length", Integer.toString(params.getBytes().length));
      DataOutputStream ostream = new DataOutputStream(conn.getOutputStream());
      String reqstr = params;
      ostream.writeBytes(reqstr);
      ostream.flush();
      ostream.close();
      InputStreamReader reader = new InputStreamReader(conn.getInputStream());
      int data;
      String response = "";
      while ((data = reader.read()) > 0)
        response += (char)data;
      reader.close();
      return response;
    } catch (MalformedURLException e) {
      System.out.println("x MalformedURLException: " + e.getMessage());
      return EMPTY_RESPONSE;
    } catch (IOException e) {
      System.out.println("x IOException: " + e.getMessage());
      return EMPTY_RESPONSE;
    }
  }
};
