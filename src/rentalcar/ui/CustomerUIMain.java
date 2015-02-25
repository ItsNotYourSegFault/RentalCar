package rentalcar.ui;

import rentalcar.ui.Display;


public class CustomerUIMain {

	static Display window = new Display();
	public static void main(String[] args) {
		
		Boolean loggedIn = false;
		String username = "0";
		String password = "0";
		
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
		
		while(choice != 5) {
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
					loggedIn = true;
					choice = 0;
				} else if(choice == 3) {
					Display.println("VEHCILES");
					Display.println(" ");
					choice = 0;
				} else if(choice == 4) {
					Display.println("SERVICES");
					Display.println(" ");
					choice = 0;
				} else if(choice == 5) {
					Display.println("Thank you.");
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
					Display.println("VEHCILES");
					Display.println(" ");
					choice = 0;
				} else if(choice == 2) {
					Display.println("SERVICES");
					Display.println(" ");
					choice = 0;
				} else if(choice == 3) {
					Display.println("Thank you.");
					Display.println(" ");
					Display.println(" ");
					System.exit(0);
				} else {
					Display.println(" ");
					Display.println("Please, select an option");
					Display.println(" ");
					Display.println("\t1.\tBrowse Vehicles");
					Display.println("\t2.\tBrowse Services"); 
					Display.println("\t3.\tExit Application");
					
					choice = Display.inputInt();
				}
			}
		}
		
	}
	
}
