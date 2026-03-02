package practice;

public class Substring {

	public Substring() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
	        String s = "abcdef";
	        int k = 150;
	        int n = s.length();
	        int flag = -1;
	        for (int i = 0; i < n; i++) {
	            int sum = 0;
	            for (int j = i; j < n; j++) {
	                sum += s.charAt(j);  
	                if (sum == k) {
	                    flag = i;
	                    break;
	                }
	                if (sum > k) {
	                    break;
	                }
	            }
	            if (flag!= -1) {
	                break;
	            }
	        }
	        System.out.println(flag);
	    }
}
