package overriding;

public class Driver {
	public static void main(String[] args) {
		new Supporting().monthlySalCal();
		System.out.println(new Supporting().monthlySalCal());
		System.out.println(new It().monthlySalCal());
		System.out.println(new It().monthlySalCal(5000.0));
		System.out.println(new Employee().monthlySalCal());
	}
}
