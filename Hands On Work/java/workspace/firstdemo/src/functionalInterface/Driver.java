package functionalInterface;
@FunctionalInterface
interface Draw{
	void circle();
}
public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Draw d = () -> {
			System.out.println("Overidden Lambda Expression");
		};
		d.circle();
		Draw draw = () -> System.out.println("Lambda Expression Overidden");
		draw.circle();
	}
}
