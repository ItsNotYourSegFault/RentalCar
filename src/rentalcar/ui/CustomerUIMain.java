package rentalcar.ui;

import rentalcar.ui.Display;


public class CustomerUIMain {

	static Display window = new Display();
	
	public static void reserve()
	{
		Display.println("RESERVATION");
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
