package seconddemo;

import java.util.Scanner;

public class ArrayBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner name = new Scanner(System.in);
		Object [] arr =new Object[5];
		arr[0]=true;
		arr[1]=(byte)1;
		arr[2]='k';
		arr[3]="school";
		arr[4]=1234L;
		for(int j=0;j<=4;j++)
		{
			arr[j]=name.nextLine();
		}
		name.close();
		for(int i=0;i<=4;i++)
		{
			System.out.println(arr[i]);
		}
		try {
			arr[8]=false; //Checked Exception ArrayIndexOutOfBoundsException
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.exit(0);
		}
	}

}
