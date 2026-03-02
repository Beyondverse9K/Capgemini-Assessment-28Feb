package practice;

public class SecondLargest {
	public static void main(String[] args) {
		int arr[]= {7,45,18,10};
	    int largest=arr[0];
	    int slargest=0;
	    for(int i=0;i<arr.length;i++)
	    {
	    	if(arr[i]>largest)
	    	{
	    		slargest=largest;
	    		largest=arr[i];	
	    	}
	    	 for(int j=0;j<arr.length;j++)
	 	    {
	 	    	if(arr[j]<largest && arr[j]>slargest)
	 	    		slargest=arr[j];
	 	    }
	   }
	   System.out.println(slargest);
}
}