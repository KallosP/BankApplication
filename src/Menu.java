import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		LoadMenu loadMenu = new LoadMenu();
		AccountActions acctActions = new AccountActions();
		CheckingAccountMenuOptions CAMO = new CheckingAccountMenuOptions();
		SavingsAccountMenuOptions SAMO = new SavingsAccountMenuOptions();
		
		loadMenu.printWelcome();
		
		String userIn;
		do {
			loadMenu.printFirstPrompt();
			userIn = scnr.nextLine();
			loadMenu.newMenuSignal();
			
			if(userIn.equals("1")) {
				do {
					
					loadMenu.printCheckingPrompt();
					loadMenu.printCheckingMenu();
					userIn = scnr.nextLine();
					
					CAMO.executeCheckingMenu(userIn, acctActions, scnr);
					loadMenu.printEndOfAction(); //prints dotted line after every menu input for formatting purposes
					
				} while(!(userIn.equals("5")));
			}
			else if(userIn.equals("2")) {
				do {
					
					loadMenu.printSavingsPrompt();
					loadMenu.printSavingsMenu();
					userIn = scnr.nextLine();
					
					SAMO.executeSavingsMenu(userIn, acctActions, scnr);
					loadMenu.printEndOfAction();
					
				} while(!(userIn.equals("6")));
			}
						
		} while(!(userIn.equals("3")));
		 
		System.out.println("____________________________________________");
		System.out.println("\nLogout Successful: Goodbye!");
		System.out.println("____________________________________________");
		
		scnr.close();
	}
	
}
