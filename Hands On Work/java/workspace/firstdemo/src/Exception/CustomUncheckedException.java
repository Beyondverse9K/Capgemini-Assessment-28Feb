package Exception;

public class CustomUncheckedException {
	public static void withdraw(double balance,double amount) {
		if(amount>balance) {
			throw new InsufficientBalanceException("Withdraw Amount exceeded the available balance");
		}
		System.out.println("Withdrawal Successful! Remaining balance: "+(balance-amount));
	}
	public static void main(String[] args) {
		double balance=5000;
		double amount=6000;
		try {
			withdraw(balance,amount);
		}
		catch(InsufficientBalanceException e){
			System.out.println("Caught Exception: "+e.getMessage());
		}
	}
}
