package practice;
import java.util.Stack;
public class IterativeQuickSort {
	static void quickSort(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		stack.push(arr.length - 1);
		while (!stack.isEmpty()) {
			int high = stack.pop();
			int low = stack.pop();
			int pivotIndex = partition(arr, low, high);
			if (pivotIndex - 1 > low) {
				stack.push(low);
				stack.push(pivotIndex - 1);
			}
			if (pivotIndex + 1 < high) {
				stack.push(pivotIndex + 1);
				stack.push(high);
			}
		}
	}
	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}
	public static void main(String[] args) {
		int[] arr = {10, 7, 8, 9, 1, 5};
		quickSort(arr);
		for (int x : arr) {
			System.out.print(x + " ");
		}
	}
}
