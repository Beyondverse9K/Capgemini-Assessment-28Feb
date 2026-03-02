package object_string_conversion;

public class Employee {
	String s;
	int id;
	Employee(String s,int id){
		this.s=s;
		this.id=id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id : "+this.id+" name : "+this.s ; 
	}
	/*
	 * @Override public String toString() { 
	 * // TODO Auto-generated method stub
	 * return super.toString(); }
	 */
}
