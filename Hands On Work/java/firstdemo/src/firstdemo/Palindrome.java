package firstdemo;

import java.util.Scanner;

public class Palindrome {
static Scanner sc=new Scanner(System.in);
	public Palindrome() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		s=sc.nextLine();
		System.out.println(isPalindrome(s));
	}
	public static boolean isPalindrome(String P) {
		int i=0,j=P.length()-1;
		while(i<j)
		{
			if(P.charAt(i)!=P.charAt(j))
				return false;
			i++; j--;
		}
		return true;
	}

}
