package secureTransactionBankingEngine;

public class SavingsAccount extends Account {

	@Override
	public long withdrawCash(long withdraw, long balance) {
		System.out.println("Savinhgs Account");
		if(withdraw<=balance)
			return balance-withdraw;
		else {
			System.out.println("Insufficient Balance");
			return -1L;
		}
	}

	@Override
	public long depositCash(long deposit, long balance) {
		System.out.println("Savings Account");
		return balance+deposit;
	}
}
