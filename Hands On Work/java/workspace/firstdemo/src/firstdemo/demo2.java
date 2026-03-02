package firstdemo;

import java.util.Scanner;


public class demo2{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//int r=sc.nextInt();
		//int c=sc.nextInt();
		//int[][] arr=new int[r][c];
		//int[][] arrr= {{1,2},{3,4,5},{6}}; //this is as is, column is not fixed
		int[][] arrrr= {{1},{2},{3}};
		System.out.println(isMat(arrrr));
//		for(int i=0;i<r;i++) {
//			for(int j=0;j<c;j++) {
//				arr[i][j]=sc.nextInt();
//			}
//		}
//		for(int i=0;i<r;i++) {
//			for(int j=0;j<c;j++) {
//				System.out.println(arr[i][j]);
//			}
//		}
//		System.out.println(arr);
//		System.out.println(elements(arrr));
	}
	public static boolean isMat(int[][]arr) {
		if(arr.length>1)
		{
			for(int i=0;i<arr.length;i++)
			{
				if(arr[0].length!=1)
					return false;
			}
		}
		return true;
	}
//	public static int elements(int [][]arr) {
//		return arr.length*arr[0].length;
//	}
}