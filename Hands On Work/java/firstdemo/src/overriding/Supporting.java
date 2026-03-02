package overriding;

public class Supporting extends Employee{
	double varPay = 100000;
	@Override
	public double monthlySalCal() {
		return (varPay+basePay)/12;
	}
}
