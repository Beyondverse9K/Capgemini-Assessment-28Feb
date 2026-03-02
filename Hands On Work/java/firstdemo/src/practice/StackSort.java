package practice;
import java.util.Stack;

public class StackSort {

	public StackSort() {
		// TODO Auto-generated constructor stub
	}
	static void sortedInsert(Stack<Integer> st, int element) {
		if (st.empty() || element > st.peek()) {
			st.push(element);
		} else {
			int top_element = st.peek();
			st.pop();
			sortedInsert(st, element);
			st.push(top_element);
			}
		}
	static void sortStack(Stack<Integer> st) {
		if (!st.empty()) {
			int top_element = st.peek();
			st.pop();
			sortStack(st);
			sortedInsert(st, top_element);
			}
		}
	public static void main(String args[]) {
		Stack <Integer> st = new Stack<>();
		st.push(1);
		st.push(3);
		st.push(4);
		st.push(2);
		for(int a: st) {
			System.out.print(a+" ");
		}
		System.out.println();
		sortStack(st);
		for(int a: st) {
			System.out.print(a+" ");
		}
	}
}
