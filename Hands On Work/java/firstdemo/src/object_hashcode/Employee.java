package object_hashcode;

public class Employee {
	String s;
	int id;
	public Employee(String s, int id) {
		super();
		this.s = s;
		this.id = id;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj) 
			return true; 
		if(obj==null||this.getClass()!=obj.getClass()) 
			return false; 
		Employee e=(Employee)obj;
		if(this.id==e.id)
			return true;
		return false;
	}
}
