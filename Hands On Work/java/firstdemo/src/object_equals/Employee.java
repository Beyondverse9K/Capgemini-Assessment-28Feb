package object_equals;

public class Employee {
	String s;
	int id;
	Employee(String s,int id){
		this.s=s;
		this.id=id;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj) {
			System.out.println("Same Reference");
			return true; }
		if(obj==null) {
			System.out.println("Null Object");
			return false; }
		if(this.getClass()!=obj.getClass()) {
			System.out.println("Not same Object Type");
			return false; }
		Employee e=(Employee)obj;
		System.out.println("Same Object Type");
		if(this.id==e.id)
			return true;
		return false;
	}
	
}
