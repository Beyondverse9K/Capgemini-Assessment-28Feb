package practice;

public class NumberOfChar {

	public NumberOfChar() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		String s="qwe2#";
		char ch;
		int count=0;
		for(int i=0;i<s.length();i++) {
			ch=s.charAt(i);
			if(Character.isLetter(ch))
				count++;
		
		}
		System.out.println(count);
	}

}
