package constructor;

public class Child extends Parent1 {	
//public class Child extends Parent1,Parent2
	public Child(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}
	static final int i;
	static {
		i=10;
		System.out.println(i);
	}
	static {
		j=0;
		//System.out.println(j);   not accessible before initialization 
	}
	static final int j;
	static {
		//System.out.println(k);  not accessible before initialization
	}
	static final int k=8;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(j);
		System.out.println(Integer.MAX_VALUE+Integer.MAX_VALUE);
	}

}
