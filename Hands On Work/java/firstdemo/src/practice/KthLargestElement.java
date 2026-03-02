package practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class KthLargestElement {
 
    public static int kthLargestElement(int[] arr, int k) {
    	HashSet<Integer> hs = new HashSet<>();
    	for(int num: arr) {
    		if(!hs.contains(num))
    			hs.add(num);
    	}
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());//Second Approach
        for (int num : hs) {
            pq.offer(num);
            pq1.offer(num);
        }
        int ans = -1;
        //int ans1 = -1;
        int size=hs.size();
        //Kth Largest = size-k+1
        for (int i = 0; i < size+1-k; i++) {
            ans = pq.poll();
        }
        //Second Approach
        //for(int i=0 ; i<k ; i++ ) {
        //	ans1 = pq.poll();
        //}
        return ans;
        //Second Approach   return ans1;
    }
    public static void main(String[] args) {
        int[] arr = {7, 7, 10, 4, 3, 3, 20, 15, 20};
        int k = 3;
        System.out.println(kthLargestElement(arr, k));
    }
}