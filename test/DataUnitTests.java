import java.util.Set;

import rentalcar.web.JSONRequest;
import rentalcar.system.Database;
import rentalcar.data.FormObject;


public class DataUnitTests {
  public static void main(String[] args) {
    Database db = new Database();
    FormObject res = new FormObject();
    res.Set("test", "value");
    System.out.println(res.ToQueryString());

    Set locations = db.GetLocations();
    System.out.println(locations);
    Integer locationId = db.Locations.get(locations.toArray()[locations.size()-1]);
    System.out.println(db.GetVehiclesByLocation(locationId));
  }
}