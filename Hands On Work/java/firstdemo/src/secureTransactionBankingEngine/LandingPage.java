package secureTransactionBankingEngine;
import java.util.Scanner;

public class LandingPage {
	private static short userPin;
	private static char userChoice;
	private static long amount;
	public static void validateInvalidAmount(long amount)throws InvalidAmountException{
		if(amount<=0)
			throw new InvalidAmountException("You have entered invalid amount!");
	}
	public static void validateInsufficientBalance(long amount,long balance)throws InsufficientBalanceException{
		if(amount>balance)
			throw new InsufficientBalanceException("Withdrawl failed, not enough balance!");
	}
	public static void main(String[] args) {
		Account account=null;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter your Pin");
		userPin=Short.parseShort(userInput.nextLine());
		System.out.println("Enter 'C' for Current Account and 'S' for Savings Account");
		userChoice=userInput.nextLine().charAt(0);
		switch(userChoice) {
		case 'C' :
			CurrentAccount currentAccount=new CurrentAccount();
			account=currentAccount;
			System.out.println("Welcome Back! "+account.getAccountHolderName(userPin));
			System.out.println("Account Number :"+account.getAccountNumber(userPin));
			System.out.println("Enter 'D' for Current Account Deposit and 'W' for Current Account Withdrawl, any other key to Check Balance");
			userChoice=userInput.nextLine().charAt(0);
			switch(userChoice) {
			case 'D' :
				System.out.println("Enter the amount you want to deposit :");
				amount=Long.parseLong(userInput.nextLine());
				try {
					validateInvalidAmount(amount);
				}
				catch(InvalidAmountException e){
					System.out.println("Caught Exception :"+e.getMessage());
				}
				account.setBalance(userPin, currentAccount.depositCash(amount, account.getBalance(userPin)));
				System.out.println("Current Balance after Current Account Deposit :"+account.getBalance(userPin));
				break;
			case 'W' :
				System.out.println("Enter the amount you want to withdraw :");
				amount=Long.parseLong(userInput.nextLine());
				try{
					validateInsufficientBalance(amount, account.getBalance(userPin));
				}
				catch(InsufficientBalanceException e) {
					System.out.println("Caught Exception :"+e.getMessage());
				}
				try {
					validateInvalidAmount(amount);
				}
				catch(InvalidAmountException e){
					System.out.println("Caught Exception :"+e.getMessage());
				}
				account.setBalance(userPin, currentAccount.withdrawCash(amount, account.getBalance(userPin)));
				System.out.println("Current Balance after Current Account Withdrawl :"+account.getBalance(userPin));
				break;
			default :
				System.out.println("Current Account Balance :"+account.getBalance(userPin));
				break;
			}
			break;
		case 'S' :
			SavingsAccount savingsAccount = new SavingsAccount();
			account=savingsAccount;
			System.out.println("Welcome Back! "+account.getAccountHolderName(userPin));
			System.out.println("Account Number :"+account.getAccountNumber(userPin));
			System.out.println("Enter 'D' for Savings Account Deposit and 'W' for Savings Account Withdrawl, any other key to Check Balance");
			userChoice=userInput.nextLine().charAt(0);
			switch(userChoice) {
			case 'D' :
				System.out.println("Enter the amount you want to deposit :");
				amount=Long.parseLong(userInput.nextLine());
				try {
					validateInvalidAmount(amount);
				}
				catch(InvalidAmountException e){
					System.out.println("Caught Exception :"+e.getMessage());
				}
				account.setBalance(userPin, savingsAccount.depositCash(amount, account.getBalance(userPin)));
				System.out.println("Current Balance after Savings Account Deposit :"+account.getBalance(userPin));
				break;
			case 'W' :
				System.out.println("Enter the amount you want to withdraw :");
				amount=Long.parseLong(userInput.nextLine());
				try{
					validateInsufficientBalance(amount, account.getBalance(userPin));
				}
				catch(InsufficientBalanceException e) {
					System.out.println("Caught Exception :"+e.getMessage());
				}
				try {
					validateInvalidAmount(amount);
				}
				catch(InvalidAmountException e){
					System.out.println("Caught Exception :"+e.getMessage());
				}
				account.setBalance(userPin, savingsAccount.withdrawCash(amount, account.getBalance(userPin)));
				System.out.println("Current Balance after Savings Account Withdrawl :"+account.getBalance(userPin));
				break;
			default :
				System.out.println("Savings Account Balance :"+account.getBalance(userPin));
				break;
			}
			break;
		default :
			System.out.println("Invalid Choice of Account");
			break;
		}
		userInput.close();
	}
}
