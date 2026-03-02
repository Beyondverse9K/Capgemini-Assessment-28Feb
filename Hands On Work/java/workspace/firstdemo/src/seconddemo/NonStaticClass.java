package seconddemo;
public class NonStaticClass {
	public NonStaticClass() {
		System.out.println("Constructor");
	}
	int i= 7;
	{
		System.out.println("Non static block");
	}	
	public static void main(String[] args) {
		System.out.println("Main Method");
		//Create objects to invoke non static method
		Object objectClass = new NonStaticClass();		
	}	
}
