public class LoadMenu {
	
	public boolean checkingPromptOneExecuted = false;
	public boolean savingsPromptOneExecuted = false;
	
	public void printCheckingMenu() {
		System.out.println("1. Check your balance"
				+ "\n2. Make a deposit"
				+ "\n3. Make a withdrawal"
				+ "\n4. View previous transaction"
				+ "\n5. Exit Checking Account");
	}
	
	public void printSavingsMenu() {
		System.out.println("1. Check your balance"
				+ "\n2. Make a deposit"
				+ "\n3. Make a withdrawal"
				+ "\n4. View previous transaction"
				+ "\n5. Simple Interest Calculator"
				+ "\n6. Exit Savings Account");
	}
	
	public void printICTitle() { //IC = interest calculator
		System.out.println("............................................\n"
						 + "SIMPLE INTEREST CALCULATOR:\n");
	}
	
	public void printWelcome() {
		System.out.println("____________________________________________");
		System.out.println();
		System.out.println("        WELCOME TO YOUR BANK ACCOUNT      ");
		System.out.println("____________________________________________");
		System.out.println();
		System.out.println("    |To perform an action, please enter|"
				   	   + "\n    |its corresponding number.         |\n");
		System.out.println("============================================");
	}
	
	public void printFirstPrompt() {
		System.out.println("Choose the account you wish to enter."); 
		System.out.println("\n1. Checking Account\n2. Savings Account\n3. Log Out");
	}
	
	public void printCheckingPrompt() {
		//Checks if initial prompt has been executed
		if(!checkingPromptOneExecuted) { 
			System.out.println("CHECKING ACCOUNT:\n");
			System.out.println("What would you like to do today?\n");
		}
		else {
			System.out.println("CHECKING ACCOUNT:\n");
			System.out.println("What else would you like to do today?\n");
		}
		checkingPromptOneExecuted = true;
	}
	
	public void printSavingsPrompt() {
		if(!savingsPromptOneExecuted) {
			System.out.println("SAVINGS ACCOUNT:\n");
			System.out.println("What would you like to do today?\n");
		}
		else {
			System.out.println("SAVINGS ACCOUNT:\n");
			System.out.println("What else would you like to do today?\n");
		}
		savingsPromptOneExecuted = true;
	}
	
	public void printEndOfAction() {
		System.out.println("--------------------------------------------");
	}
	
	public void newMenuSignal() {
		System.out.println("============================================");
	}
	
}
