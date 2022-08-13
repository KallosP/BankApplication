import java.util.Scanner;

public class CheckingAccountMenuOptions {
	
	public void executeCheckingMenu(String userIn, AccountActions AA, Scanner scnr) { //AA = acount actions
				
		if(userIn.equals("1")) { //checks balance
			
			System.out.println("\nCURRENT BALANCE: $" + AA.getCheckingBalance() + "\n");
			
		}
		else if(userIn.equals("2")) { //makes deposit
			
			AA.manageDeposit(AA.depAmtC, AA.currBalanceC, 'C', scnr);
			
		}
		else if(userIn.equals("3")) { //makes withdrawal
			
			AA.manageWithdrawal(AA.withDrawAmtC, AA.currBalanceC, 'C', scnr);			
			
		}
		else if(userIn.equals("4")) { //prints previous transaction
			
			AA.printPreviousTransaction(AA.transactionTracker, AA.depAmtC, AA.withDrawAmtC, AA.currBalanceC);
			
		}
	}
}
