package rentalcar.ui;

import rentalcar.ui.Display;


public class CustomerUIMain {
	// Instantiating Display window
	static Display window = new Display();
	
	/*
	 * Reservation System
	 * Asks for vehicle and services
	 * Vehicles are strings
	 * Services are int - 1 = yes, 0 = no
	 */
	public static void reserve()
	{
		String vehicleList[] = new String[7];
		vehicleList[0] = "Economy car";
		vehicleList[1] = "Compact car";
		vehicleList[2] = "Standard car";
		vehicleList[3] = "Premium car";
		vehicleList[4] = "Small SUV";
		vehicleList[5] = "Standard SUV";
		vehicleList[6] = "Minivan";
		
		int vehicleChoiceInt = 0;
		String vehicleChoice = "";
		
		int GPS, childSeat, KTAG, roadsideAsst, lossIns, personalIns;
		
		int month = 0;
		int day = 0;
		int year = 0;
		
		char yesOrNo = 'x';
		
		Display.println("**** Reservation - Vehicle ****");
		Display.println(" ");
		Display.println("Please, select a vehicle class: ");
		for (int i = 0; i < 7; i++) {
			Display.print(i + 1);
			Display.print(".\t");
			Display.println(vehicleList[i]);
		}
		Display.println(" ");
		Display.println(" ");
		
		vehicleChoiceInt = Display.inputInt() - 1;
		vehicleChoice = vehicleList[vehicleChoiceInt];
		
		Display.println("**** Reservation - Services ****");
		Display.println(" ");
		
		// GPS
		while((yesOrNo != 'y') || (yesOrNo != 'n')) {
			Display.println("GPS Reciever? (y/n)");
			yesOrNo = Display.inputChar();
			if((yesOrNo == 'y') || (yesOrNo == 'n')){
				break;
			}
		}
		if(yesOrNo == 'y') {
			GPS = 1;
		} else {
			GPS = 0;
		}
		yesOrNo = 'x';
		
		
		//Child Seat
		while((yesOrNo != 'y') || (yesOrNo != 'n')) {
			Display.println("Child Seat? (y/n)");
			yesOrNo = Display.inputChar();
			if((yesOrNo == 'y') || (yesOrNo == 'n')){
				break;
			}
		}
		if(yesOrNo == 'y') {
			childSeat = 1;
		} else {
			childSeat = 0;
		}
		yesOrNo = 'x';
		
		
		// K-TAG Rental
		while((yesOrNo != 'y') || (yesOrNo != 'n')) {
			Display.println("K-TAG Rental? (y/n)");
			yesOrNo = Display.inputChar();
			if((yesOrNo == 'y') || (yesOrNo == 'n')){
				break;
			}
		}
		if(yesOrNo == 'y') {
			KTAG = 1;
		} else {
			KTAG = 0;
		}
		yesOrNo = 'x';
			
		
		//Roadside Assistance
		while((yesOrNo != 'y') || (yesOrNo != 'n')) {
			Display.println("Roadside Assistance? (y/n)");
			yesOrNo = Display.inputChar();
			if((yesOrNo == 'y') || (yesOrNo == 'n')){
				break;
			}
		}
		if(yesOrNo == 'y') {
			roadsideAsst = 1;
		} else {
			roadsideAsst = 0;
		}
		yesOrNo = 'x';
		
		
		//Loss Damage Waiver Insurance
		while((yesOrNo != 'y') || (yesOrNo != 'n')) {
			Display.println("Loss Damage Waiver Insurance? (y/n)");
			yesOrNo = Display.inputChar();
			if((yesOrNo == 'y') || (yesOrNo == 'n')){
				break;
			}
		}
		if(yesOrNo == 'y') {
			lossIns = 1;
		} else {
			lossIns = 0;
		}
		yesOrNo = 'x';
		
		
		//Personal Accident Insurance
		while((yesOrNo != 'y') || (yesOrNo != 'n')) {
			Display.println("Personal Roadside Assistance? (y/n)");
			yesOrNo = Display.inputChar();
			if((yesOrNo == 'y') || (yesOrNo == 'n')){
				break;
			}
		}
		if(yesOrNo == 'y') {
			personalIns = 1;
		} else {
			personalIns = 0;
		}
		yesOrNo = 'x';
		
		// Gather date info
		while((month < 1) || (month > 12)) {
			Display.println("Please enter the number of the month for this reservation: ");
			month = Display.inputInt();
			if((month < 1) && (month > 12)){
				break;
			}
		}
		while((day < 1) || (day > 31)) {
			Display.println("Please enter the number of the day for this reservation: ");
			day = Display.inputInt();
			if((day < 1) && (day > 31)){
				break;
			}
		}
		while((year < 2015) || (month > 2017)) {
			Display.println("Please enter the number of the year for this reservation: ");
			year = Display.inputInt();
			if((year < 2015) && (month > 2017)){
				break;
			}
		}
		
		Display.println(" ");
		Display.println(" ");
		Display.print("Thank you. Your reservation for a ");
		Display.print(vehicleChoice);
		Display.print(" is set for ");
		Display.print(day);
		Display.print("-");
		Display.print(month);
		Display.print("-");
		Display.print(year);
		
		
		
		Display.println(" ");
		Display.println(" ");
		Display.println(" ");
		
		
	}
	
	public static void  vehicles() {
		Display.println("**** Economy Vehicles - $45/day or $300/week ****");
		Display.println("\tFord Fiesta");
		Display.println("\tToyota Yaris");
		Display.println(" ");
		Display.println(" ");
		Display.println("**** Compact Vehicles - $50/day or $325/week ****");
		Display.println("\tFord Focus");
		Display.println("\tHonda Civic");
		Display.println("\tToyota Corolla");
		Display.println(" ");
		Display.println(" ");
		Display.println("**** Standard Vehicles - $60/day or $325/week ****");
		Display.println("\tFord Fusion");
		Display.println("\tHonda Accord");
		Display.println("\tToyota Camry");
		Display.println(" ");
		Display.println(" ");
		Display.println("**** Premium Vehicles - $65/day or $400/week ****");
		Display.println("\tFord Mustang");
		Display.println(" ");
		Display.println(" ");
		Display.println("**** Small SUV - $70/day or $475/week ****");
		Display.println("\tFord Escape");
		Display.println("\tHonda CR-V");
		Display.println("\tToyota RAV4");
		Display.println(" ");
		Display.println(" ");
		Display.println("**** Standard SUV - $75/day or $500/week ****");
		Display.println("\tFord Explorer");
		Display.println("\tHonda Pilot");
		Display.println("\tToyota Highlander");
		Display.println(" ");
		Display.println(" ");
		Display.println("**** Minivan - $85/day or $575/week ****");
		Display.println("\tHonda Odyssey");
		Display.println("\tToyota Sienna");
		Display.println(" ");
		Display.println(" ");
		Display.println(" ");
		Display.println(" ");
	}
	
	
	public static void services()
	{
		Display.println(" ");
		Display.println(" ");
		Display.println("**** Additional Equipment and Services ****");
		Display.println(" ");
		
		Display.println("\tGPS Reciever\t\t\t-\t$15/day");
		Display.println(" ");
		
		Display.println("\tChild Seat\t\t\t-\t$10/day");
		Display.println(" ");
		
		Display.println("\tK-TAG rental\t\t\t-\t$2/day (plus accumulated tolls)");
		Display.println(" ");
		
		Display.println("\tRoadside Assistance\t\t-\t$7/day");
		Display.println(" ");
		
		Display.println("\tLoss Damage Waiver Insurance\t-\t$25/day");
		Display.println(" ");
		
		Display.println("\tPersonal Accident Insurance\t-\t$5/day");
		Display.println(" ");
		Display.println(" ");
		Display.println(" ");
		Display.println(" ");
	}
	
	
	public static void main(String[] args)
	{
		
		Boolean loggedIn = false;
		String username = "0";
		String password = "0";
		String firstName = "0";
		String lastName = "0";
		String ccNum = "0";
		
		
		Display.println("**********************************************************");
		Display.println("*                INYS Car Rental System                  *");
		Display.println("*                                                        *");
		Display.println("*            Please, select an option below              *");
		Display.println("*                                                        *");
		Display.println("**********************************************************");
		Display.println(" ");
		Display.println(" ");
		Display.println("\t1.\tLogin");
		Display.println("\t2.\tCreate Account");
		Display.println("\t3.\tBrowse Vehicles");
		Display.println("\t4.\tBrowse Services"); 
		Display.println("\t5.\tExit Application");
		
		int choice = Display.inputInt();
		
		while(true) {
			while(!loggedIn){
				if (choice == 1) {
					Display.println("Please, enter your username: ");
					username = Display.input();
					Display.println("Please, enter your password: ");
					password = Display.input();
					loggedIn = true;
					choice = 0;
				} else if(choice == 2) {
					Display.println("Please, enter a username: ");
					username = Display.input();
					Display.println("Please, enter a password: ");
					password = Display.input();
					Display.println("Please, enter your first name: ");
					firstName = Display.input();
					Display.println("Please, enter your last name");
					lastName = Display.input();
					Display.println("Please, enter your credit card number");
					ccNum = Display.input();
					loggedIn = true;
					choice = 0;
				} else if(choice == 3) {
					vehicles();
					choice = 0;
				} else if(choice == 4) {
					services();
					choice = 0;
				} else if(choice == 5) {
					System.exit(0);
				} else {
					Display.println(" ");
					Display.println("Please, select an option");
					Display.println(" ");
					Display.println("\t1.\tLogin");
					Display.println("\t2.\tCreate Account");
					Display.println("\t3.\tBrowse Vehicles");
					Display.println("\t4.\tBrowse Services");
					Display.println("\t5.\tExit Application");
					
					choice = Display.inputInt();
				}
			}
			
			while(loggedIn) {
				if(choice == 1) {
					vehicles();
					choice = 0;
				} else if(choice == 2) {
					services();
					choice = 0;
				} else if (choice == 3) {
					reserve();
					choice = 0;
				} else if(choice == 4) {
					System.exit(0);
				} else {
					Display.println(" ");
					Display.println("Please, select an option");
					Display.println(" ");
					Display.println("\t1.\tBrowse Vehicles");
					Display.println("\t2.\tBrowse Services"); 
					Display.println("\t3.\tReserve a vehicle");
					Display.println("\t4.\tExit Application");
					
					choice = Display.inputInt();
				}
			}
		}
		
	}
	
}
