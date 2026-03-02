package seconddemo;

public class Candidate {
	String name;
	long mobileNumber;
	boolean gender;
	public void study() {
		System.out.println("Studying Hard");
	}
	//public Candidate() { super(); }
	public Candidate(String name, long mobileNumber, boolean gender)
	{
		this.name=name;
		this.mobileNumber=mobileNumber;
		this.gender=gender;
	}
	public Candidate(long mobileNumber, boolean gender, String name)
	{
		this.name=name;
		this.mobileNumber=mobileNumber;
		this.gender=gender;
	}
}
