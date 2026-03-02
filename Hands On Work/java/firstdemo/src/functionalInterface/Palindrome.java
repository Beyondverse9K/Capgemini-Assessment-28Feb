package functionalInterface;

@FunctionalInterface
interface palin{
	boolean isPalin(String st);
}
public class Palindrome {

	public Palindrome() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		palin p = (String st) -> {
			int l=0;
			int r=st.length()-1;
			while(l<r) {
				if(st.charAt(l)!=st.charAt(r))
					return false;
				l++;
				r--;
			}
			return true;
		};
		System.out.println(p.isPalin("RACECAR"));
	}
}
