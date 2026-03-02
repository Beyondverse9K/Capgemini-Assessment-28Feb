package Porshe;

public class Car {

	public Car() {
		// TODO Auto-generated constructor stub
	}
	static Engine engine;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PetrolEngine PE = new PetrolEngine();
		engine=PE;
		System.out.println(engine.getClass());
		DieselEngine DE = new DieselEngine();
		engine=DE;
		System.out.println(engine.getClass());
	}

}
