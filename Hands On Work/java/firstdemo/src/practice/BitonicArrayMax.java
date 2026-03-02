package practice;

public class BitonicArrayMax {
	public BitonicArrayMax() {
		// TODO Auto-generated constructor stub
	}
	public static int findMaximum(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < arr[mid + 1]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return arr[low];
	}
	public static void main(String[] args) {
		int[] arr = {1, 3, 8, 12, 9, 5, 2};
		System.out.println(findMaximum(arr));
	}
}