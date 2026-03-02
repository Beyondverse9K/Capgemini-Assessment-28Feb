package practice;

public class Insert {

	public Insert() {
		// TODO Auto-generated constructor stub
	}
	public static int[] insertAtPosition(int arr[],int pos,int val)
	{
		int len=arr.length;
		int newArr[]=new int[len+1];
		for(int i=0;i<newArr.length;i++) {
			if(i<pos-1) {
				newArr[i]=arr[i];
			}
			else if(i==pos-1) {
				newArr[i]=val;
			}
			else {
				newArr[i]=arr[i-1];
			}
		}
		return newArr;
	}
	public static int[] insertAtValue(int arr[],int val)
	{
		int len=arr.length;
		int newArr[]=new int[len+1];
		for(int i=0;i<newArr.length-1;i++) {
			if(arr[i]<val) {
				newArr[i]=arr[i];
			}
			else if(arr[i]>val) {
				newArr[i]=arr[i-1];
			}
			else {
				newArr[i]=val;
			}
		}
		return newArr;
	}
	public static void main(String[] args) {
		int[] arr= {1,2,3,5};
		int[] nA=insertAtValue(arr, 4);
		for(int i=0;i<nA.length;i++) {
			System.out.print(nA[i]);
		}
		System.out.println();
		}
	}


