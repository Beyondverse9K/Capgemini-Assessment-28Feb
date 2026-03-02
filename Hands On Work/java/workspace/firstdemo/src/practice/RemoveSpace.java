package practice;

public class RemoveSpace {

	public RemoveSpace() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		String st=" West Indies ";
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<st.length();i++) {
			if(st.charAt(i)!=' ') {
				sb.append(st.charAt(i));
			}
		}
		System.out.println(sb);
	}
}
