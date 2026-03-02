package shadowing_hiding;

public class Hiding {
	public static void main(String[] args) {
	Parent p = new Child();
	Child c = new Child();
	System.out.println("Hiding");
	System.out.println(p.x); //10
	System.out.println(c.x); //20
}
}
class Parent {
	int x =10;
}
class Child extends Parent{
	int x = 20;
}
