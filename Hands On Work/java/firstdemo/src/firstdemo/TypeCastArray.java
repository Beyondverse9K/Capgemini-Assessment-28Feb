package firstdemo;

public class TypeCastArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] boolArr= {true,true};
		char[] charArr= {'k','k','k'};
		char[] charARR= {'k','k','k'};
		Object[] obj= { 1234L, "string", '1' };
		Printer(boolArr, charARR, charArr, obj);
	}
	public static void Printer(Object... objects) {

	    for (Object obj : objects) {

	        if (obj instanceof boolean[]) {
	            boolean[] arr = (boolean[]) obj;
	            for (boolean b : arr) {
	                System.out.println(b);
	            }

	        } else if (obj instanceof char[]) {
	            char[] arr = (char[]) obj;
	            for (char c : arr) {
	                System.out.println(c);
	            }

	        } else if (obj instanceof Object[]) {
	            Object[] arr = (Object[]) obj;
	            for (Object o : arr) {
	                System.out.println(o);
	            }

	        } else {
	            System.out.println(obj);
	        }
	    }
	}

}
