import rentalcar.web.Request;
import rentalcar.web.JSONRequest;

/*
  RentalCar.java
  --
  Kendal Harland <kendaljharland@gmail.com>
  Siddhant Sethi <siddhant.sethi91@gmail.com>
  Stephanie Sammons <chirox90@gmail.com>
  Grant Hays <granthays@gmail.com>
  Jackson Montgomery <j573m923@ku.edu>
  Lei Wang <l290w868@gmail.com>
  Greg Pregulman <gpregulman@gmail.com>
  --
  Main RentalCar application file.
 */
public class RentalCar {
  public static void main(String[] args) {
    JSONRequest jreq = null;
    Request req = new Request();
    System.out.println(req.GET("hello/world/"));
  }
}