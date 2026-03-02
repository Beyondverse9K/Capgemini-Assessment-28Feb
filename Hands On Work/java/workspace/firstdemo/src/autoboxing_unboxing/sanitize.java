package autoboxing_unboxing;

import java.util.Scanner;

public class sanitize {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringBuffer ss = new StringBuffer();
		byte pb;
		System.out.println(s);
		try {
			pb=Byte.parseByte(s);
		}
		catch(Exception e)
		{
			if(s.charAt(0)=='+'||s.charAt(0)=='-')
			{
				ss.append(s.charAt(0));
			}
			for(int i=0;i<s.length();i++)
			{
				if(Character.isDigit(s.charAt(i))) {
					ss.append(s.charAt(i));
				}
			}
			String sss=ss.toString();
			System.out.println(sss);
			System.out.println("Sanitize" + ss);
			pb=Byte.parseByte(sss);
			System.out.println(pb);
		}
		
	}
}
