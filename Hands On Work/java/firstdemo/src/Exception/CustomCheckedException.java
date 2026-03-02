package Exception;

public class CustomCheckedException {
	public static void validateAge(int age) throws InvalidAgeException{
		if(age<18)
			throw new InvalidAgeException("Age must be 18 or older to register");
		System.out.println("Age is valid. Proceed to registration.");
		if(age>17 && age<22) {
			System.out.println(Permit.SOFT);
		}
		else {
			System.out.println(Permit.HARD);
		}
	}
	public static void main(String [] args) {
		try {
			validateAge(16);
		}
		catch(InvalidAgeException e) {
			System.out.println("Caught Exception  "+e.getMessage());
		}
		validateAge(18);
		validateAge(21);
		validateAge(22);
	}
}
