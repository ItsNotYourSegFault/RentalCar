import rentalcar.web.JSONRequest;
import rentalcar.data.FormObject;

/*
  DataUnitTests.java
  --
  Kendal Harland <kendaljharland@gmail.com>
  Siddhant Sethi <siddhant.sethi91@gmail.com>
  Stephanie Sammons <chirox90@gmail.com>
  Grant Hays <granthays@gmail.com>
  Jackson Montgomery <j573m923@ku.edu>
  Lei Wang <l290w868@gmail.com>
  Greg Pregulman <gpregulman@gmail.com>
  --
  Unit tests for the rentalcar.data package
 */
  
public class DataUnitTests {
  public static void main(String[] args) {
    FormObject res = new FormObject();
    System.out.println(res.ToQueryString());
  }
}