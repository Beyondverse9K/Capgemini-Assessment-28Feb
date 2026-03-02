
package firstdemo;

public class EmailValidation {
static String email = "Yes@Yes.com";
	public EmailValidation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(isValid(email))
			System.out.println("Good");
		else
			System.out.println("Bad");
	}
	public static boolean isValid(String email) {
		if(!(email.contains("@")))
				return false;
		return true;
	}

}
