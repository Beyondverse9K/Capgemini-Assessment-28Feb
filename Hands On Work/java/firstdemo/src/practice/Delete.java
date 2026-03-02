package practice;

public class Delete {

	public static int[] deleteAtValue(int arr[],int val) {
		int x=0;
		for(int i=0;i<arr.length;i++) {
			if(val!=arr[i]) {
			arr[x++]=arr[i];
			}
		}
		while(x!=0)
		{
			arr[arr.length-x]=0;
			x--;
		}
		return arr;
	}
	public static int[] deleteAtPosition(int arr[],int pos) {
		int len=arr.length;
		for(int i=0;i<len-1;i++) {
			if(i>pos-1) {
				arr[i]=arr[i+1];
			}
		}
		arr[len-1]=0;
		return arr;
	}
	public static void main(String[] args) {
		int[] arr= {1,2,3,3,3,3,5};
		
		System.out.println();
		int[] nA=deleteAtPosition(arr, 2);
		for(int i=0;i<nA.length;i++) {
			System.out.print(nA[i]);
		}
		System.out.println();
		int[] naA=deleteAtValue(arr, 3);
		for(int i=0;i<naA.length;i++) {
			System.out.print(naA[i]);
		}
	}

}
