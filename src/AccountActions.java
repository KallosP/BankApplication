import java.util.Scanner;

public class AccountActions {
	double currBalanceC; //checking amt
	double depAmtC;
	double withDrawAmtC;
	
	double currBalanceS; //savings amt
	double depAmtS;
	double withDrawAmtS;
	
	int transactionTracker; //tracks current transaction: 0 = deposit; 1 = withdrawal
	
	public AccountActions() { //constructor for initialization
		currBalanceC = 1000.0;
		depAmtC = 0.0;
		withDrawAmtC = 0.0;
		
		currBalanceS = 1000.0;
		depAmtS = 0.0;
		withDrawAmtS = 0.0;
	}
	
	public double getCheckingBalance() {
		return currBalanceC;
	}
	
	public double makeAndReturnCheckingDeposit(double depAmtC) {
		transactionTracker = 0;
		currBalanceC += depAmtC;
		return currBalanceC;
	}
	
	public double makeAndReturnCheckingWithdrawal(double withDrawAmtC) {
		transactionTracker = 1;
		currBalanceC -= withDrawAmtC;
		return currBalanceC;
	}
	
	
	public double getSavingsBalance() {
		return currBalanceS;
	}
	
	public double makeAndReturnSavingsDeposit(double depAmtS) {
		transactionTracker = 0;
		currBalanceS += depAmtS;
		return currBalanceS;
	}
	
	public double makeAndReturnSavingsWithdrawal(double withDrawAmtS) {
		transactionTracker = 1;
		currBalanceS -= withDrawAmtS;
		return currBalanceS;
	}
	
	public void manageDeposit(double depAmt, double balance, char acct, Scanner scnr) {

		System.out.println("\nEnter the amount you would like to deposit:");
		
		if(scnr.hasNextDouble()) { //prevents crash from invalid user input
			
			depAmt = scnr.nextDouble(); 
			
			if(depAmt < 0) {
				System.err.println("\nInvalid amount: No deposit made.");
				System.out.println("\nCURRENT BALANCE: $" + Math.round(balance * 100.0) / 100.0 + "\n");
			}
			else {
				
				//Sets deposit amt and balance of respective account
				if(acct == 'C') {
					depAmtC = depAmt;
					currBalanceC = balance;
					System.out.println("\nNEW TOTAL BALANCE: $" + Math.round(makeAndReturnCheckingDeposit(depAmt) * 100.0) / 100.0 + "\n");
				}
				else if (acct == 'S') {
					depAmtS = depAmt;
					currBalanceS = balance;
					System.out.println("\nNEW TOTAL BALANCE: $" + Math.round(makeAndReturnSavingsDeposit(depAmt) * 100.0) / 100.0 + "\n");
				}
				
			}
		}
		else {
			System.err.println("\nInvalid amount: No deposit made.");
			System.out.println("\nCURRENT BALANCE: $" + Math.round(balance * 100.0) / 100.0 + "\n");
		}
		scnr.nextLine(); //used as a counter measure for the above caution (prevents printMenu() from executing twice)	
		
	}
	
	public void manageWithdrawal(double withdrawalAmt, double balance, char acct, Scanner scnr) {
		
		System.out.println("\nEnter the amount you would like to withdraw:");
		
		if(scnr.hasNextDouble()) {
			withdrawalAmt = scnr.nextDouble();
			if(withdrawalAmt < 0) {
				System.err.println("\nInvalid amount: No withdrawal made.");
				System.out.println("\nCURRENT BALANCE: $" + Math.round(balance * 100.0) / 100.0 + "\n");
			}
			else if((balance - withdrawalAmt) < 0) {
				System.err.println("\nCannot withdraw more than the current balance: No withdrawal made.");
				System.out.println("\nCURRENT BALANCE: $" + Math.round(balance * 100.0) / 100.0 + "\n");
			}
			else {
				
				//Sets deposit amt and balance of respective account
				if(acct == 'C') {
					withDrawAmtC = withdrawalAmt;
					currBalanceC = balance;
					System.out.println("\nNEW TOTAL BALANCE: $" + Math.round(makeAndReturnCheckingWithdrawal(withdrawalAmt) * 100.0) / 100.0 + "\n");
				}
				else if (acct == 'S') {
					withDrawAmtS = withdrawalAmt;
					currBalanceS = balance;
					System.out.println("\nNEW TOTAL BALANCE: $" + Math.round(makeAndReturnSavingsWithdrawal(withdrawalAmt) * 100.0) / 100.0 + "\n");
				}
				
				
			}
		}
		else {
			System.err.println("\nInvalid amount: No withdrawal made.");
			System.out.println("\nCURRENT BALANCE: $" + Math.round(balance * 100.0) / 100.0 + "\n");
		}
		scnr.nextLine();
		
	}
	
	public void printPreviousTransaction(int transTracker, double depAmt, double withdrawalAmt, double balance) {
		
		if(transTracker == 0) {
			if(depAmt == 0) {
				System.err.println("\nNo transaction was made.");
				System.out.println("\nCURRENT BALANCE: $" + Math.round(balance * 100.0) / 100.0 + "\n");
			}
			else {
				System.out.println("\nA deposit of $" + Math.round(depAmt * 100.0) / 100.0 + " was made.");
				System.out.println("\nCURRENT BALANCE: $" + Math.round(balance * 100.0) / 100.0 + "\n");
			}	
		}
		else if(transTracker == 1) {
			
			if(withdrawalAmt == 0) {
				System.err.println("\nNo transaction was made.");
				System.out.println("\nCURRENT BALANCE: $" + Math.round(balance * 100.0) / 100.0 + "\n");
			}
			else {
				System.out.println("\nA withdrawal of $" + Math.round(withdrawalAmt * 100.0) / 100.0 + " was made.");
				System.out.println("\nCURRENT BALANCE: $" + Math.round(balance * 100.0) / 100.0 + "\n");
			}
		}
		
	}
	
}
