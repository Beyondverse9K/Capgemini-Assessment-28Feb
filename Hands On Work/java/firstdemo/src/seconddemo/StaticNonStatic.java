package seconddemo;
public class StaticNonStatic {
	static int j = printer();
	int i= printerP();
	public StaticNonStatic() {
		System.out.println("Constructor");
	}
	{
		System.out.println("Non static block");
	}	
	public int printerP() {
		System.out.println("Non static Printer");
		return 0;
	}
	public static void main(String args[]) {
		System.out.println("Main Method");
		//Create objects to load non static method
		Object objectClass = new StaticNonStatic();	
		new StaticNonStatic();
	}
	static {
		System.out.println("First Static");
	}
	static {
		System.out.println("Second Static");
	}
	public static int printer() {
		System.out.println(" Static Printer");
		return 0;
	}
}
