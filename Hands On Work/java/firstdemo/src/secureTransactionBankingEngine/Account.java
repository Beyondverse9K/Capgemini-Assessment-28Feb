package secureTransactionBankingEngine;

public abstract class Account implements BankAccount{
	private long accountNumber=9876543210L;
	private String accountHolderName="Anirban Subarna Pushkar";
	private long balance=90000000L;
	private short pin=19999;
	public long getAccountNumber(short pin) {
		if(this.pin==pin)
			return accountNumber;
		else {
			System.out.println("Operation Failed! Invalid Pin");
			return -1L;
		}
	}
	public void setAccountNumber(short pin,long accountNumber) {
		if(this.pin==pin)
			this.accountNumber = accountNumber;
		else
			System.out.println("Operation Failed! Invalid Pin");
	}
	public String getAccountHolderName(short pin) {
		if(this.pin==pin)
			return accountHolderName;
		else {
			System.out.println("Operation Failed! Invalid Pin");
			return null;
		}
	}
	public void setAccountHolderName(short pin,String accountHolderName) {
		if(this.pin==pin)
			this.accountHolderName = accountHolderName;
		else {
			System.out.println("Operation Failed! Invalid Pin");
		}
	}
	public long getBalance(short pin) {
		if(this.pin==pin)
			return balance;
		else {
			System.out.println("Operation Failed! Invalid Pin");
			return -1L;
		}
	}
	public void setBalance(short pin,long balance) {
		if(this.pin==pin)
			this.balance = balance;
		else {
			System.out.println("Operation Failed! Invalid Pin");
		}
	}
	public short getPin() {
		return pin;
	}
	public void setPinNumber(short pin) {
		this.pin = pin;
	}
}
