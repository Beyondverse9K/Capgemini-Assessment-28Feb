package pc_access_modifier;

public class Child extends Parent {
	protected int b =7;
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c.a);
	}
	
}
