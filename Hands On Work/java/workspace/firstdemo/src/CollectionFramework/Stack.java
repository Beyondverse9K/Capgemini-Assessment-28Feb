package CollectionFramework;

public class Stack {
	
	public static void main(String[] args) {
		int capacity=10;
		int arr[]=new int[capacity];
		push(arr,5,-1);
		push(arr,6,1);
		push(arr,7,2);
		pop(arr,2);
	}
	static void push(int arr[],int a,int top) {
		if(top==arr.length-1)
		{
			System.out.println("Stack Overflow");
		}
		else
		{
			top++;
			arr[top]=a;
		}
	}
	static int pop(int arr[],int top) {
		if(top==-1) {
			System.out.println("Stack Empty");
			return -1;
		}
		else
		{
			int k=arr[top];
			top--;
			return k;
		}
	}
	
}
