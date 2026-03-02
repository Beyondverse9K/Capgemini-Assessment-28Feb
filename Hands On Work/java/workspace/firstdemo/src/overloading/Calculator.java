package overloading;

public class Calculator extends Calc{
	public static void addition() {
	//Base	
	}
	// public static int addition() {}
	// public void addition() {}
//Only with method signature and nothing else
	public static void addition(double a, double b) {
	//Number of argument	
	//Compare base1
	}
	public static void addition(int a, double b) {
	//Different data type	
	//Compare base2
	}
	public static void addition(double a, int b) {
	//Different order
	//Compare base3
	}
	public static void main(String[] args) {
		Calc c = new Calc();
		Calculator cc = new Calculator();
		c.addition(0);
		cc.addition(0);
	}
}

