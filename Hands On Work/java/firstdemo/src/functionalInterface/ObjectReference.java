package functionalInterface;

@FunctionalInterface
interface A{
	void show(String msg);
}
public class ObjectReference {

	public ObjectReference() {
		// TODO Auto-generated constructor stub
	}
	public void show(String msg) {
		msg=msg.toLowerCase();
		System.out.println(msg);
	}
	public static void main(String[] args) {
		//Object Reference
		ObjectReference or = new ObjectReference();
		A a = (msg) -> or.show(msg);
		a.show("Hello");
		//Method Reference for object
		A aa = or::show;
		aa.show("Hi");
	}
}
