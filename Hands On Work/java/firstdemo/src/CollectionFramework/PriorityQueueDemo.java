package CollectionFramework;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public PriorityQueueDemo() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		PriorityQueue<Integer> name = new PriorityQueue<>();
		Deque<Integer> name1 = new ArrayDeque<Integer>();
		LinkedList<Integer> name2 = new LinkedList<>();
		name1.offerFirst(1);
		name1.offerFirst(3);
		name1.offerFirst(2);
		name1.offerFirst(4);
		name1.offerFirst(0);
		name1.offerFirst(5);
		System.out.println(name1);
		System.out.println(name1.peek());
		name1.pollFirst();
		System.out.println(name1);
		name1.pollFirst();
		System.out.println(name1);
		name1.pollFirst();
		System.out.println(name1);
		name1.pollFirst();
		System.out.println(name1);
		name.offer(1);
		name.offer(3);
		name.offer(2);
		name.offer(4);
		name.offer(0);
		name.offer(5);
		System.out.println(name);
		System.out.println(name.peek());
		name.poll();
		System.out.println(name);
		name.poll();
		System.out.println(name);
		name.poll();
		System.out.println(name);
		name.poll();
		System.out.println(name);
		name2.add(1);
		name2.add(null);
		System.out.println(name2);
	}
}
