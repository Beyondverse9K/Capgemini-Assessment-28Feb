package factory;

public class Eager {
	private static Eager eager;  //null default
	private Eager() {
		// TODO Auto-generated constructor stub
		System.out.println("Eager Instance"); //Class Loading
	}
	public static Eager LaptopFactory() {
		if(eager==null) {
			eager = new Eager();
			System.out.println("First Object");
		}
		else {
			System.out.println("Same Object");
		}
		return eager;
	}
}

