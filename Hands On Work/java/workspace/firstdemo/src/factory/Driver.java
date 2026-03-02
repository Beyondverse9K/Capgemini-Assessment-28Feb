package factory;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String [] args) {
		Lazy laptopFactory = Lazy.LaptopFactory();
		System.out.println(laptopFactory);
		Lazy laptopFactory1 = Lazy.LaptopFactory();
		System.out.println(laptopFactory1);
		Eager laptopFactory2 = Eager.LaptopFactory();
		System.out.println(laptopFactory2);
		Eager laptopFactory3 = Eager.LaptopFactory();
		System.out.println(laptopFactory3);
	}
}
