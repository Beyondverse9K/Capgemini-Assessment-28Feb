package practice;
import java.util.Arrays;
public class WaveFormSort {

	public WaveFormSort() {
		// TODO Auto-generated constructor stub
	}
	static int[] waveformsort(int arr[]) {
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i+=2)
		{
			int temp=arr[i];
			arr[i]=arr[i+1];
			arr[i+1]=temp;
		}
		return arr;
	}
	public static void main(String[] args) {
		int arr[] = {1,5,6,8,2,9,4};
		int array[]=waveformsort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(array[i]);
		}
	}
}
