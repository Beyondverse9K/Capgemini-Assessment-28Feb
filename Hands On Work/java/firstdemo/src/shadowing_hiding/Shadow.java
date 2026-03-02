package shadowing_hiding;

public class Shadow {
	int x=10;
	static int y =30;
	void show() {
		int x = 20; //Shadow instance
		//Not Duplicate as scope is different
		int y = 40;
		System.out.println("Shadow");
		System.out.println(x); //20
		System.out.println(this.x); //10
		System.out.println(y);
		System.out.println(Shadow.y);
		System.out.println(this.y); 
		//Why this works? static means no object
	}
	public static void main(String[] args) {
		new Shadow().show();
	}
}
