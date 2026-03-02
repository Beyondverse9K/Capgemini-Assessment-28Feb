package object_equals;

public class Driver {
	public static void main(String[] args) {
		String s="qwerty";
		String ss="qwerty";
		String sss=new String("qwerty");
		//Contents
		System.out.println(s.equals(ss));
		System.out.println(s.equals(sss));
		//Reference
		Employee e1=new Employee("Pushkar",69);
		Employee e2=new Employee("Pushkar",69);
		Employee e3=e1;
		Employee e5=null;
		System.out.println(e1.getClass());
		System.out.println(e2.getClass());
		System.out.println(e3.getClass());
		//System.out.println(e5.getClass());
		//System.out.println(e5.getClass());
		System.out.println(e1.equals(e2));
		System.out.println(e1.equals(e3));
		System.out.println(e3.equals("String"));
		System.out.println(e3.equals(e5));
		}
}

