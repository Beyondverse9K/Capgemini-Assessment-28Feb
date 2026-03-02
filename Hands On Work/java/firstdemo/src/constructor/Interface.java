package constructor;

public interface Interface {
	static int i=0; // by default final static
	//static int a; need initialisation
	//static {
	//	System.out.println("Hi");
	//}
	public static void print()
	{
		System.out.println("Hello");
	}
	//public abstract static void staticMethod();   not possible
	int j=0; //by default final static
	//{
	//	System.out.println("HiHello");
	//}
	//public void printer()
	//{
		//System.out.println("HelloHi");
	//}
	public abstract void nonStaticMethod();
}
