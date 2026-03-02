package enumeration;

import java.util.Scanner;

public class Corporate {
	//EMPLOYEE emp;
	public static void main(String[] args) {
		//EMPLOYEE emp;
		Scanner sc = new Scanner(System.in);
		EMPLOYEE emp=new EMPLOYEE();
		String s=sc.nextLine();
		System.out.println(emp.name=s);
		int a=Integer.parseInt(sc.nextLine());
		System.out.println(emp.age=a);
		if(emp.age<18)
			System.out.println(emp.role.INTERN);
		else if(emp.age>18 && emp.age < 28)
			System.out.println(emp.role.LEAD);
		else if(emp.age>29 && emp.age <41)
			System.out.println(emp.role.DIRECTOR);
		else
			System.out.println(emp.role.ADMIN);
		
	}
}
