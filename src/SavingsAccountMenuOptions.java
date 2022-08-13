import java.util.Scanner;

public class SavingsAccountMenuOptions {
	
	LoadMenu loadMenu = new LoadMenu();
	
	public void executeSavingsMenu(String userIn, AccountActions AA, Scanner scnr) { //AA = acount actions
				
		if(userIn.equals("1")) { //checks balance
			
			System.out.println("\nCURRENT BALANCE: $" + AA.getSavingsBalance() + "\n");
			
		}
		else if(userIn.equals("2")) { //makes deposit
			
			AA.manageDeposit(AA.depAmtS, AA.currBalanceS, 'S', scnr);
			
		}
		else if(userIn.equals("3")) { //makes withdrawal
			
			AA.manageWithdrawal(AA.withDrawAmtS, AA.currBalanceS, 'S', scnr);
			
		}
		else if(userIn.equals("4")) { //prints previous transaction
			
			AA.printPreviousTransaction(AA.transactionTracker, AA.depAmtS, AA.withDrawAmtS, AA.currBalanceS);
			
		}
		else if(userIn.equals("5")) {
						
			startInterestCalculator(scnr);
			scnr.nextLine();
			
		}
	}
	
	private void startInterestCalculator(Scanner scnr) {
		
		int initDeposit;
		double numMonthsInYears;
		double interestRate;
			
		loadMenu.printICTitle();
		
		System.out.println("Starting Balance:");
		if(scnr.hasNextInt()) {
			
			initDeposit = scnr.nextInt();
			
			System.out.println("\nNumber of Months:");
			if(scnr.hasNextDouble()) {
				
				numMonthsInYears = (double) scnr.nextInt() / 12;
				
				System.out.println("\nAnnual Interest Rate (Percentage):");
				if(scnr.hasNextDouble()) {
					
					interestRate = scnr.nextDouble() / 100;
					//If all input is valid, calculate and print the total savings
					calculateAndPrintTotalSavings(initDeposit, numMonthsInYears, interestRate);
					
				}
				else {
					System.err.println("\nInvalid entry.");
					//Prevents Savings menu from printing more than once
					scnr.nextLine();
				}
				
			}
			else {
				System.err.println("\nInvalid entry.");
				scnr.nextLine();
			}
			
		}
		else {
			System.err.println("\nInvalid entry.");
			scnr.nextLine();
		}
		
	}
	
	private void calculateAndPrintTotalSavings(int deposit, double months, double apy) {
		
		System.out.println("\nFuture Savings: $" + Math.round( ( (double) deposit * (1 + ((double) apy * (double) months)) ) * 100.0) / 100.0 + "\n");
		
	}
	
}
