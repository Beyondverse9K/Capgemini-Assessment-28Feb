package seconddemo;

public class UserDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object u1=new User("email","password");
		Object u2=new User("email","password","address");
		System.out.println(u1);
		System.out.println(u2);
	}

}
