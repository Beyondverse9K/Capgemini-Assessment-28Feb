package practice;

public class JobScheduling {

	public JobScheduling() {
		// TODO Auto-generated constructor stub
	}
	public static int activitySel(int[] start, int[] finish) {
        int n = start.length;
        quickSort(start, finish, 0, n - 1);
        int count = 1;
        int lastFinish = finish[0];
 
        for (int i = 1; i < n; i++) {
            if (start[i] > lastFinish) {
                count++;
                lastFinish = finish[i];
            }
        }
        return count;
    } 
    static void quickSort(int[] start, int[] finish, int low, int high) {
        if (low < high) {
            int pi = partition(start, finish, low, high);
            quickSort(start, finish, low, pi - 1);
            quickSort(start, finish, pi + 1, high);
        }
    }
    static int partition(int[] start, int[] finish, int low, int high) {
        int pivot = finish[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (finish[j] < pivot) {
                i++;
                swap(finish, i, j);
                swap(start, i, j);
            }
        }
        swap(finish, i + 1, high);
        swap(start, i + 1, high);
        return i + 1;
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        System.out.println(activitySel(start, finish));
    }
}

