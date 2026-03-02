package secureTransactionBankingEngine;
public class CurrentAccount extends Account{
	
	@Override
	public long withdrawCash(long withdraw, long balance) {
		System.out.println("Current Account");
		if(withdraw<=balance)
			return balance-withdraw;
		else {
			System.out.println("Insufficient Balance");
			return -1L;
		}
	}

	@Override
	public long depositCash(long deposit, long balance) {
		System.out.println("Current Account");
		return balance+deposit;
	}
}
