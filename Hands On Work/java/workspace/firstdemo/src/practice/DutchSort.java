package practice;

public class DutchSort {

	public DutchSort() {
		// TODO Auto-generated constructor stub
	}
	public static void sort012(int[] arr) {
	    int low=0,mid=0,high=arr.length-1;
	    while(mid<=high) {
	    	if(arr[mid]==0) {
	    		swap(arr,low,mid);
	    		low++;
	    		mid++;
	    	}
	    	else if(arr[mid]==1) {
	    		mid++;
	    	}
	    	else { //arr[mid]==2
	    		swap(arr,mid,high);
	    		high--;
	    	}
	    }
	}
	 
	static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	public static void main(String[] args) {
		int arr[]= {1,0,2,1,0,2,1,0,2};
		sort012(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
	}
}
