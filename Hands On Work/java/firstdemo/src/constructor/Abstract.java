package constructor;

public abstract class Abstract {

	static int i=0;
	static {
		System.out.println("Hi");
	}
	public static void print()
	{
		System.out.println("Hello");
	}
	//public abstract static void staticMethod();   not possible
	int j=0;
	{
		System.out.println("HiHello");
	}
	public void printer()
	{
		System.out.println("HelloHi");
	}
	public abstract void nonStaticMethod();
	public Abstract()
	{
		
	}
}
