package practice;

enum InvestmentType {EQUITY_INVESTMENT,DEBT_INVESTMENT};

class InvalidInvestmentException extends Exception{
	public InvalidInvestmentException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}

class InvestmentRejectedException extends RuntimeException{
	public InvestmentRejectedException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}

interface Investment{
	void authorize() throws InvestmentRejectedException, InvalidInvestmentException;
}

abstract class InvestmentTransaction implements Investment{	
	private String tId;
	private String iName;
	private double iAmount;
	private InvestmentType iType; 
	public InvestmentTransaction(String transactionId,String investorName,double investedAmount,InvestmentType investmentType) 
			throws InvalidInvestmentException  {
		if(investedAmount<=0) {
			throw new InvalidInvestmentException("Investment Amount should be greater than zero !");
		}
		this.tId=transactionId;
		this.iName=investorName;
		this.iAmount=investedAmount;
		this.iType=investmentType;
		
	}
	public String getTransactionId() {
		return tId;
	}
	public String getInvestorName() {
		return iName;
	}
	public double getInvestedAmount() {
		return iAmount;
	}
	public InvestmentType getInvestmentType() {
		return iType;
	}
	protected abstract double taxRate();
	protected abstract double bonusRate();
	protected abstract double riskFactor();
}

class EquityInvestment extends InvestmentTransaction{
	public EquityInvestment(String transactionId, String investorName, double investedAmount,InvestmentType investmentType) throws InvalidInvestmentException {
		super(transactionId, investorName, investedAmount, investmentType);
		
	}
	@Override
	public double taxRate() {
		return 0.15;
	}
	@Override
	public double bonusRate() {
		return 0.8;
	}
	@Override
	public double riskFactor() {
		return -0.3;
	}
	@Override
	public void authorize() throws InvestmentRejectedException,InvalidInvestmentException {
		double taxRate=taxRate();
		double bonusRate=bonusRate();
		double riskFactor=riskFactor();
		if(taxRate+bonusRate>=0 && taxRate+bonusRate<=0.30) {
			throw new InvalidInvestmentException("Invalid Taxation inclusive 0 and 30 !");
		}
		System.out.println("Transaction Id: "+getTransactionId()+"    Investor Name: "+getInvestorName());
		System.out.println("Invested Amount: "+getInvestedAmount()+"    Investment Type: "+getInvestmentType());
		System.out.println("Total charges after Tax: "+getInvestedAmount()*(1+taxRate+bonusRate-riskFactor));
	}
	public void authorize(String securityCode) throws InvestmentRejectedException,InvalidInvestmentException {
		if(securityCode!="6666") {
			throw new InvestmentRejectedException("Wrong Code, System Terminated!");
		}
		authorize();
	}
	
}
 
class DebtInvestment extends InvestmentTransaction{
	public DebtInvestment(String transactionId, String investorName, double investedAmount,InvestmentType investmentType) throws InvalidInvestmentException {
		super(transactionId, investorName, investedAmount, investmentType);
	}
	@Override
	public double taxRate() {
		return 0.25;
	}
	@Override
	public double bonusRate() {
		return 0.5;
	}
	@Override
	public double riskFactor() {
		return -0.1;
	}
	@Override
	public void authorize() throws InvestmentRejectedException,InvalidInvestmentException {
		double taxRate=taxRate();
		double bonusRate=bonusRate();
		double riskFactor=riskFactor();
		if(taxRate+bonusRate>=0 && taxRate+bonusRate<=0.30) {
			throw new InvalidInvestmentException("Invalid Taxation inclusive 0 and 30 !");
		}
		System.out.println("Transaction Id: "+getTransactionId()+"    Investor Name: "+getInvestorName());
		System.out.println("Invested Amount: "+getInvestedAmount()+"    Investment Type: "+getInvestmentType());
		System.out.println("Total charges after Tax: "+getInvestedAmount()*(1+taxRate+bonusRate-riskFactor));
	}
	public void authorize(String securityCode) throws InvestmentRejectedException,InvalidInvestmentException {
		if(securityCode!="6666") {
			throw new InvestmentRejectedException("Wrong Code, System Terminated!");
		}
		authorize();
	}
	
}

public class SecurePortfolioInvestmentEngine {

	public SecurePortfolioInvestmentEngine() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		try {
			EquityInvestment EI=new EquityInvestment("XCV35", "Subarna", 1000,InvestmentType.EQUITY_INVESTMENT);
			EI.authorize("6666");
		} catch (InvalidInvestmentException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e.getMessage());
		} catch (InvestmentRejectedException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e.getMessage());
		}
		try {
			DebtInvestment DI=new DebtInvestment("XCV35", "Anirban", 1000,InvestmentType.DEBT_INVESTMENT);
			DI.authorize("6666");
		} catch (InvalidInvestmentException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e.getMessage());
		} catch (InvestmentRejectedException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e.getMessage());
		}
		System.out.println("Validate Investment Amount");
		try {
			EquityInvestment EI=new EquityInvestment("XCV35", "Subarna", 0,InvestmentType.EQUITY_INVESTMENT);
			EI.authorize("6666");
		} catch (InvalidInvestmentException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e.getMessage());
		} catch (InvestmentRejectedException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e.getMessage());
		}
	}

}
