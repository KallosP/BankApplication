
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
}
