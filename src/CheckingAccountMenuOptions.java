import java.util.Scanner;

public class CheckingAccountMenuOptions {
	
	public void executeCheckingMenu(String userIn, AccountActions AA, Scanner scnr) { //AA = acount actions
		
		if(userIn.equals("1")) { //checks balance
			
			System.out.println("\nCURRENT BALANCE: $" + AA.getCheckingBalance() + "\n");
			
		}
		else if(userIn.equals("2")) { //makes deposit
			
			System.out.println("\nEnter the amount you would like to deposit:");
			if(scnr.hasNextDouble()) { //prevents crash from invalid user input
				AA.depAmtC = scnr.nextDouble(); //CAUTION: returns extra new line which results in unwanted execution of printMenu()
				if(AA.depAmtC < 0) {
					System.err.println("\nInvalid amount: No deposit made.");
					System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceC + "\n");
				}
				else {
					System.out.println("\nNEW TOTAL BALANCE: $" + AA.makeAndReturnCheckingDeposit(AA.depAmtC) + "\n");
				}
			}
			else {
				System.err.println("\nInvalid amount: No deposit made.");
				System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceC + "\n");
			}
			scnr.nextLine(); //used as a counter measure for the above caution (prevents printMenu() from executing twice)
			
		}
		else if(userIn.equals("3")) { //makes withdrawal
			
			System.out.println("\nEnter the amount you would like to withdraw:");
			
			if(scnr.hasNextDouble()) {
				AA.withDrawAmtC = scnr.nextDouble();
				if(AA.withDrawAmtC < 0) {
					System.err.println("\nInvalid amount: No withdrawal made.");
					System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceC + "\n");
				}
				else {
					System.out.println("\nNEW TOTAL BALANCE: $" + AA.makeAndReturnCheckingWithdrawal(AA.withDrawAmtC) + "\n");
				}
			}
			else {
				System.err.println("\nInvalid amount: No withdrawal made.");
			}
			scnr.nextLine();
			
		}
		else if(userIn.equals("4")) { //prints previous transaction
			
			if(AA.transactionTracker == 0) {
				if(AA.depAmtC == 0) {
					System.err.println("\nNo transaction was made.");
					System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceC + "\n");
				}
				else {
					System.out.println("\nA deposit of $" + AA.depAmtC + " was made.");
					System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceC + "\n");
				}	
			}
			else if(AA.transactionTracker == 1) {
				
				if(AA.withDrawAmtC == 0) {
					System.err.println("\nNo transaction was made.");
					System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceC + "\n");
				}
				else {
					System.out.println("\nA withdrawal of $" + AA.withDrawAmtC + " was made.");
					System.out.println("\nCURRENT BALANCE: $" + AA.currBalanceC + "\n");
				}
			}
			
		}
	}
}
