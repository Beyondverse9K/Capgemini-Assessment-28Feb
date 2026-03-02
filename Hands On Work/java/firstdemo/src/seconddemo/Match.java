package seconddemo;

public class Match {

	public Match() {
		// TODO Auto-generated constructor stub
	}
//	static StringBuilder sb=new StringBuilder("B@S1a");
//	static StringBuilder sbb=new StringBuilder();
////	static int count=0;
////	static char repeat='\0';
	public static void main(String[] args) {
//		for (int i = 0; i < sb.length(); i++) {
//			if(Character.isUpperCase(sb.charAt(i)))
//			{
//				sbb.append((char)(sb.charAt(i)+32));
//			}
//			else if(Character.isLowerCase(sb.charAt(i)))
//			{
//				sbb.append((char)(sb.charAt(i)-32));
//			}
//			else
//			{
//				sbb.append(sb.charAt(i));
//			}
//		}
//		System.out.println(sbb);
		StringBuilder sbb=new StringBuilder();
		StringBuilder ssb=new StringBuilder("      ahG  ghg");
		int count=0;
		for(int i=0;i<ssb.length();i++)
		{
			if(ssb.charAt(i)==' ')
			{
				if(count>0)
					sbb.append(ssb.charAt(i));
			}
			else
			{
				count++;
				sbb.append(ssb.charAt(i));
			}
		}
		System.out.println(sbb);
	}

}
