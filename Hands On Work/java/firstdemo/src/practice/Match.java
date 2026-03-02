package practice;

public class Match {

	public Match() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		String s="Hashmapset";
		String ss="map";
		int count=0;
		for(int i=0;i<s.length();i++) {
			int k=i;
			for(int j=0;j<ss.length();j++) {
				
				if(s.charAt(k)==ss.charAt(j)) {
					k++;
					count++;
				}
			}
			if(count==ss.length())
			{
				System.out.println("Match Found");
				System.exit(0);
			}
			count=0;
		}
		System.out.println("Match not found");
	}
}
