package practice;

public class Binary {

	public Binary() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		boolean flag=true;
		String st="0101010101";
		for(int i=0;i<st.length();i++) {
			if(st.charAt(i)!='0'&&st.charAt(i)!='1')
			{
				flag=false; 
				break;
			}
		}
		System.out.println(flag);
	}

}
