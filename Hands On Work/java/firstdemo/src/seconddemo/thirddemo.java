package seconddemo;

public class thirddemo {

	public static void main(String [] args)
	{
		varArgs(5.2,5.21,5.214);
	}
	public static void varArgs(double ...ds)
	{
		for (double d : ds) {
			System.out.println(d);
		}
			
	}
}

