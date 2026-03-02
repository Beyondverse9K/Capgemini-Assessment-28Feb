package secureTransactionBankingEngine;

public interface BankAccount {
	long withdrawCash(long withdraw,long balance);
	long depositCash(long deposit,long balance);
}
