package overriding;

public class Child extends Parent {

	@Override
	public void Star() {
		System.out.println("STAR");
	}
	public static void main(String[] args) {
		Parent p = new Parent();
		p.Star();
		Child c = new Child();
		c.Star(); 
		//Override only one available
	}
}
