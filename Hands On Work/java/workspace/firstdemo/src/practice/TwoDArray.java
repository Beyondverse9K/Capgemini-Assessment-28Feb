package practice;

import java.util.Scanner;

public class TwoDArray {
	static Scanner userInput = new Scanner(System.in);
	public TwoDArray() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		int arr[][]= {{1,2,3,4,5,6,7,8,9,0},{1,2,3,4,5,6,7,8,9,0}};
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{	
			for(int j=0;j<arr[i].length;j++) {
			//System.out.print(arr[i][j]);
			sum=sum+arr[i][j];
			}
		}
		System.out.println(sum);
	}
}
