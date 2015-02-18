package rentalcar.data;

/*
  Reservation.java
  --
  Kendal Harland <kendaljharland@gmail.com>
  -- 
 	Data Object representing a rental agreement between a customer and the
 	rental company.
*/

import rentalcar.data.FormObject;

public class Reservation extends FormObject
{
	public Reservation() {
		// This is Example Code that shows you how to set these fields
		// These values should not actually be set here.
		fields.put("name"        , "Kendal Harland");
		fields.put("ccn"         , "1234567891011121");
		fields.put("vehicleType" , "SUV");
		fields.put("vehicleMake" , "Chevrolet");
		fields.put("vehicleModel", "Trailblazer");
		fields.put("rate"        , "1300");
		fields.put("startDate"   , "3/1/2015");
		fields.put("endDate"     , "3/30/2015");
	}

	// public int id;
	// public String sDat;  
	// public String eDate;
	// public int vin;
	// public int custID;
	// public double price;
	// public int salesID;
	// public int sMiles;
	// public int eMiles;
	
}
