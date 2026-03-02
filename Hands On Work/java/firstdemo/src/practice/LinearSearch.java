package practice;

public class LinearSearch {

	public LinearSearch() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7,8,9,0};
		int val=0;
		boolean flag=true;
		for(int i=0;i<arr.length;i++)
		{	
			if(val==arr[i]) {
				flag=true;
				System.out.println(i);
			}
		}
		if(!flag)
			System.out.println("Not Found");
	}
}
