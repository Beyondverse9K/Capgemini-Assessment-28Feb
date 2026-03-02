package practice;

public class ArraySort {

	public ArraySort() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7,8,9,0};
		boolean flag=true;
		for(int i=0;i<arr.length-1;i++)
		{	
			if(arr[i]>arr[i+1]) {
				flag=false;
				break;
			}
		}
		if(flag)
			System.out.println("Sorted");
		else
			System.out.println("Not");
	}
}
