import java.util.Scanner;

public class SavingsAccountMenuOptions {
	
	LoadMenu loadMenu = new LoadMenu();
	
	public void executeSavingsMenu(String userIn, AccountActions AA, Scanner scnr) { //AA = acount actions
		
		if(userIn.equals("1")) { //checks balance
			
			System.out.println("\nCURRENT BALANCE: $" + AA.getSavingsBalance() + "\n");
			
		}
		else if(userIn.equals("2")) { //makes deposit
			
			System.out.println("\nEnter the amount you would like to deposit:");
			if(scnr.hasNextDouble()) { //prevents crash from invalid user input
				AA.depAmtS = scnr.nextDouble(); //CAUTION: returns extra new line which results in unwanted execution of printMenu()
				if(AA.depAmtS < 0) {
					System.err.println("\nInvalid amount: No deposit made.");
					System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceS + "\n");
				}
				else {
					System.out.println("\nNEW TOTAL BALANCE: $" + AA.makeAndReturnSavingsDeposit(AA.depAmtS) + "\n");
				}
			}
			else {
				System.err.println("\nInvalid amount: No deposit made.");
				System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceS + "\n");
			}
			scnr.nextLine(); //used as a counter measure for the above caution (prevents printMenu() from executing twice)
			
		}
		else if(userIn.equals("3")) { //makes withdrawal
			
			System.out.println("\nEnter the amount you would like to withdraw:");
			//TODO: PREVENT CRASH IF NUMBER ISN'T ENTERED (maybe use do-while loop)
			if(scnr.hasNextDouble()) {
				AA.withDrawAmtS = scnr.nextDouble();
				if(AA.withDrawAmtS < 0) {
					System.err.println("\nInvalid amount: No withdrawal made.");
					System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceS + "\n");
				}
				else {
					System.out.println("\nNEW TOTAL BALANCE: $" + AA.makeAndReturnSavingsWithdrawal(AA.withDrawAmtS) + "\n");
				}
			}
			else {
				System.err.println("\nInvalid amount: No withdrawal made.");
			}
			scnr.nextLine();
			
		}
		else if(userIn.equals("4")) { //prints previous transaction
			
		   if(AA.transactionTracker == 0) {
				if(AA.depAmtS == 0) {
					System.err.println("\nNo transaction was made.");
					System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceS + "\n");
				}
				else {
					System.out.println("\nA deposit of $" + AA.depAmtS + " was made.");
					System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceS + "\n");
				}	
			}
			else if(AA.transactionTracker == 1) {
				
				if(AA.withDrawAmtS == 0) {
					System.err.println("\nNo transaction was made.");
					System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceS + "\n");
				}
				else {
					System.out.println("\nA withdrawal of $" + AA.withDrawAmtS + " was made.");
					System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceS + "\n");
				}
			}
			
		}
		else if(userIn.equals("5")) {
			
			int initDeposit;
			double numMonthsInYears;
			double interestRate;
			
			
			loadMenu.printICTitle();
			
			System.out.println("Starting Balance:");
			initDeposit = scnr.nextInt();
			System.out.println("\nNumber of Months:");
			numMonthsInYears = (double) scnr.nextInt() / 12;
			System.out.println("\nAnnual Interest Rate:");
			interestRate = scnr.nextDouble() / 100;
						
			calculateAndPrintTotalSavings(initDeposit, numMonthsInYears, interestRate);
			
			scnr.nextLine();
			
		}
	}
	
	private void calculateAndPrintTotalSavings(int deposit, double months, double apy) {
		
		System.out.println("\nFuture Savings: $" + (double) Math.round( ( (double) deposit * (1 + ((double) apy * months)) ) * 100) / 100);
		
	}
	
}
