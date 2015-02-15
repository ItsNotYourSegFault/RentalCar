import rentalcar.web.Request;

public class RentalCar {
  public static void main(String[] args) {
    Request req = new Request();
    System.out.println(req.GET("hello/world/"));
  }
}