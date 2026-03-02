package practice;
import java.util.HashSet;

public class DistanceWithinK {
	public DistanceWithinK() {
		// TODO Auto-generated constructor stub
	}
	static boolean hasDuplicate(int[] arr, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(set.contains(arr[i])) {
				return true;
			}
			set.add(arr[i]);
			if(set.size()>k) {
				set.remove(arr[i-k]);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 5};
		int k = 3;
		System.out.println(hasDuplicate(arr, k));
	}
}
