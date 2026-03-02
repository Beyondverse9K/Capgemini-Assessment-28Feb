package practice;

public class ReverseArray {

	public ReverseArray() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int i=0,j=arr.length-1,temp;
		while(i<j)
		{
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
		for(int k=0;k<arr.length;k++)
			System.out.print(arr[k]);
	}
}
