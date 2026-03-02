package abstraction;

import java.util.Scanner;

public class CarDriver {

	static Scanner UI = new Scanner(System.in);
	public static void main(String[] args) {
		Car car = new Car();
		Engine engine=null;
		System.out.println("Fit the Engine");
		System.out.println("Enter choice 1.P 2.D");
		int user=Integer.parseInt(UI.nextLine());
		switch(user) {
		case 1:
			PetrolEngine petrolEngine = new PetrolEngine();
			engine = petrolEngine;
			break;
		case 2:
			DieselEngine dieselEngine = new DieselEngine();
			engine = dieselEngine;
			break;
		default:
			ElectricEngine electricEngine = new ElectricEngine();
			engine = electricEngine;
			break;		
		}
		car.engine=engine;
		System.out.println(car.engine.getClass());
		//engine.startEngine();  //child member not accessible
		switch(user) {
		case 1:
			PetrolEngine petrolEngine = (PetrolEngine)engine;
			petrolEngine.startEngine();
			break;
		case 2:
			DieselEngine dieselEngine = (DieselEngine)engine;
			dieselEngine.startEngine();
			break;
		default:
			ElectricEngine electricEngine = (ElectricEngine)engine;
			electricEngine.startEngine();;
			break;		
		}
	}

}
