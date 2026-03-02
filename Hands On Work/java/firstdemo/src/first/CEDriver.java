package first;
public class CEDriver {

	public static void main(String [] args) {
		// TODO Auto-generated constructor stub
		Car car = new Car();
		Engine engine = new Engine();
		car.engine=engine;//fitting engine in a car
		engine.car=car;//fitting car in engine
		System.out.println(car.colour);
		System.out.println(car.engine);
		System.out.println(car.engine.cylinder);
		System.out.println(engine.cylinder);
		System.out.println(engine.car);
		System.out.println(engine.car.colour);
	}

}
