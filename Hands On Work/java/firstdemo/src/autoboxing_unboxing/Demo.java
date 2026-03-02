package autoboxing_unboxing;

public class Demo {
	public static void main(String[] args) {
		byte b=7;
		Byte b1=b;//Autoboxing
		System.out.println(b1.getClass());
		byte b2=b1;//Unboxing
		System.out.println(b2);
		//Constructor
		Byte num1= new Byte((byte)77);
		System.out.println(num1.getClass());
		Byte num2 = new Byte("77");
		System.out.println(num2.getClass());
		//Method
		byte num3=Byte.parseByte("9");
		System.out.println(num3);
		//If its not byte then NumberFormatException
	}
}
