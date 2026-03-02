package practice;

public class CountWords {

	public CountWords() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		String s=" Nope Nope Nope ";
		s=s.trim();
		int word=1;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==' ')
				word++;
		}
		System.out.println(word);
	}
}
