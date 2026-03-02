package factory;

public class Laptop {
	private static Laptop laptop;  //null default
	private Laptop() {
		// TODO Auto-generated constructor stub
	}
	public static Laptop LaptopFactory() {
		if(laptop==null) {
			laptop = new Laptop();
			System.out.println("First Object");
		}
		else {
			System.out.println("Same Object");
		}
		return laptop;
	}
}
