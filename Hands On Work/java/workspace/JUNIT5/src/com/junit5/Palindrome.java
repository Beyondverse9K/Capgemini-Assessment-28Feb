package com.junit5;

public class Palindrome {

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
