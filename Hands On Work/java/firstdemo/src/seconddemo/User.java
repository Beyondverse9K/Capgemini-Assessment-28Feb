package seconddemo;

public class User {
	String email;
	String password;
	
	public User(String email,String password) {
		// TODO Auto-generated constructor stub
		super();
		this.email=email;
		this.password=password;
	}
	String address;
	public User(String email,String password,String address) {
		this(email,password);
		this.address=address;
	}
}
