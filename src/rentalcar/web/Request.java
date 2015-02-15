/**
 * Request.java
 * 
 * Wrapper class that handles sending GET, POST, PUT and DELETE requests over
 * http.
 */
package rentalcar.web;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.DataOutputStream;
import java.io.IOException;

public class Request {

  private static final String SERVER = "https://rentalcar.herokuapp.com/";

  public Request() {}

  public String GET (String _url)  {
    try {
      URL url = new URL(SERVER + _url);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setRequestMethod("GET");
      String response = conn.getResponseMessage();
      conn.disconnect();
      return response.toString();
    } catch (MalformedURLException e) {
      System.out.println("x MalformedURLException: " + e.getMessage());
      return "";
    } catch (IOException e) {
      System.out.println("x IOException: " + e.getMessage());
      return "";
    }
  }

  // public static String POST (String url, String params) {
  //   URL url = URL(SERVER + url);
  //   HttpURLConnection conn = (HttpURLConnection)url.openConnection();
  //   conn.setRequestMethod("GET");
  //   // write data
  //   conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
  //   conn.setRequestProperty("Content-Length", Integer.toString(params.getBytes().length));
  //   DataOutputStream ostream = new DataOutputStream(conn.getOutputStream());
  //   ostream.writeBytes(params);
  //   ostream.flush();
  //   ostream.close();
  //   // get response
  //   InputStream instream = conn.getInputStream();
  //   BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
  //   String line;
  //   StringBuffer response = new StringBuffer();
  //   while ((line = reader.readline()) != null) {
  //     response.append(line);
  //     response.append('\r');
  //   }
  //   reader.close();
  //   return response.toString();
  // }

  public String PUT (String _url) {
    try {
      URL url = new URL(SERVER + _url);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setRequestMethod("PUT");
      String response = conn.getResponseMessage();
      conn.disconnect();
      return response.toString();
    } catch (MalformedURLException e) {
      System.out.println("x MalformedURLException: " + e.getMessage());
      return "";
    } catch (IOException e) {
      System.out.println("x IOException: " + e.getMessage());
      return "";
    }
  }
  
  public String DELETE (String _url) {
    try {
      URL url = new URL(SERVER + _url);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setRequestMethod("DELETE");
      String response = conn.getResponseMessage();
      conn.disconnect();
      return response.toString();
    } catch (MalformedURLException e) {
      System.out.println("x MalformedURLException: " + e.getMessage());
      return "";
    } catch (IOException e) {
      System.out.println("x IOException: " + e.getMessage());
      return "";
    }
  }
};