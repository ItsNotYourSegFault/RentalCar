package rentalcar.system;

/*
  User.java
  --
  Kendal Harland <kendaljharland@gmail.com>
  --
  User API Client library for the rental car application.
*/

import java.util.List;
import java.util.ArrayList;
import rentalcar.web.Request;
import rentalcar.web.JSONRequest;
import rentalcar.data.FormObject;
import org.json.JSONObject;
import org.json.JSONArray;

public class User {

  private JSONObject _user = null;

  /*
    boolean LogIn
    @desc  Find the user whose credentials match username and password
    @param user  Form with the user's login credentials
    @return upon success, a JSONObject representing a user is returned. else
            an empty JSON object is returned.
  */
  public boolean LogIn(FormObject user) throws IllegalStateException {
    if (this.IsLoggedIn())
      throw new IllegalStateException("User is already logged in.");
    JSONRequest request = new JSONRequest();
    JSONObject response = request.POST("user/login/", user.ToQueryString());
    if (response.length() == 0)
      return false;
    _user = response;
    return true;
  }

  /*
    boolean IsLoggedIn
    @desc  Return true if the user is logged in, else false.
  */
  public boolean IsLoggedIn() { return _user != null; }

  /*
    String FirstName
    @desc Get the User's first name
    @param key  The name of the property
    @return upon success, the value associated with key. else the empty string
  */
  public String FirstName() throws IllegalStateException {
    if (!this.IsLoggedIn())
      throw new IllegalStateException("User is not logged in.");
    return (String)_user.get("firstname"); 
  }

  /*
    String GetLastName
    @desc Get the User's first name
    @param key  The name of the property
    @return upon success, the value associated with key. else the empty string
  */
  public String LastName() throws IllegalStateException { 
    if (!this.IsLoggedIn())
      throw new IllegalStateException("User is not logged in.");
    return (String)_user.get("lastname");
  }

  /*
   String Email
   */
  public String Email() throws IllegalStateException {
    if (!this.IsLoggedIn())
      throw new IllegalStateException("User is not logged in.");
    return (String)_user.get("email");
  }
};
