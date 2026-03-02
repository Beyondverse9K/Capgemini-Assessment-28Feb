package overriding;

public class It extends Employee{
	double varPay=200000;
	@Override
	public double monthlySalCal() {
		return (varPay+basePay)/12;
	}
	public double monthlySalCal(double bonus) {
		return (basePay/12)+bonus;
	}
	@Override
	public Integer objM() {
		return null;
	}
}
