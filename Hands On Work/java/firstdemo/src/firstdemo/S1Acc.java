package firstdemo;

public class S1Acc {
	private double bal = 6000;
	private short pin = 1923;
	public double getBal(short pin)
	{
		if(this.pin==pin)
			return this.bal;
		else
			return -1;
	}
	public void setBalCredit(double amt)
	{
		this.bal+=amt;
	}
	public void setBalDebit(double amt)
	{
		this.bal+=amt;
	}
}
