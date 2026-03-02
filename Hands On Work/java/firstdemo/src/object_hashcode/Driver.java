package object_hashcode;

public class Driver {
	public static void main(String[] args) {
		Employee e1=new Employee("Pushkar",69);
		System.out.println(e1.hashCode());	
		System.out.println(e1);
	}
}
