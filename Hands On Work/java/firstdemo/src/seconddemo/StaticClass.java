package seconddemo;

public class StaticClass {
	static {
		System.out.println("First Static");
	}
	static int i = printer();
	static {
		System.out.println("Second Static");
	}
	public static void main(String[] args) {
		System.out.println("Main Method");
	}
	public static int printer() {
		System.out.println("Printer");
		return 0;
	}
}
