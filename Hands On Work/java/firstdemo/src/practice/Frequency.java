package practice;

public class Frequency {
	public static void main(String[] args) {
		String s="Lesser";
		char ch=' ';
		int c;
		for(int i=0;i<s.length();i++)
		{
			ch=s.charAt(i);
			c=0;
			for(int j=0;j<s.length();j++)
			{
				if(ch==s.charAt(j)) {
					c++;
				}
			}
			System.out.println("Frequency of "+ch+" is:"+c);
		}
	}
}