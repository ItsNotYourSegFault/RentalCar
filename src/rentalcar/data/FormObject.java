package rentalcar.data;

/*
  FormObject.java
  --
  Kendal Harland <kendaljharland@gmail.com>
  --
  Map-like class that represents a serializable object to be sent to the web server.
  All objects used to specify data structures need to inherit from this class
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import rentalcar.web.APIClient;

public class FormObject {
  
  // The fields this form object contains
  protected HashMap<String,String> fields = new HashMap<String,String>();

  public FormObject() {}

  /* 
    String ToQueryString
    @desc  Serialize the form object into a list of url parameters
   */
  public String ToQueryString() {
    String queryString = "";
    Iterator it = fields.entrySet().iterator();
    while (true) {
      Map.Entry pair = (Map.Entry)it.next();
      queryString += pair.getKey() + "=" + pair.getValue();
      it.remove();
      if (!it.hasNext()) break;
      queryString += "&";
    }
    return queryString;
  }
}