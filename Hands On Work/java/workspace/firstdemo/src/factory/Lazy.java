package factory;

public class Lazy {
	private static Lazy lazy;  //null default
	private Lazy() {
		// TODO Auto-generated constructor stub
		System.out.println("Lazy Instance"); //Program execution
	}
	public static Lazy LaptopFactory() {
		if(lazy==null) {
			lazy = new Lazy();
			System.out.println("First Object");
		}
		else {
			System.out.println("Same Object");
		}
		return lazy;
	}
}

