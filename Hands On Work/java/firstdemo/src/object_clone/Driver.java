package object_clone;

public class Driver {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1=new Employee(69);
		Employee e2 = (Employee) e1.clone();
		System.out.println(e1.id+"  "+e2.id);
		System.out.println(e1+"  "+e2);
	}
}
