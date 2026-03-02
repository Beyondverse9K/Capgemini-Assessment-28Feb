package practice;

public class ThirdLargest {
	public ThirdLargest() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		int arr[]= {9,7,11,45,18,10};
	    int largest=arr[0];
	    int slargest=0;
	    int tlargest=Integer.MIN_VALUE;
	    for(int i=0;i<arr.length;i++)
	    {
	    	if(arr[i]>largest)
	    	{
	    		tlargest=slargest;
	    		slargest=largest;
	    		largest=arr[i];	
	    	}
	    	 for(int j=0;j<arr.length;j++)
	 	    {
	    		if(arr[j]<largest && arr[j]>slargest)
	    			slargest=arr[j];
	 	    	if(arr[j]<slargest && arr[j]>tlargest)
	 	    		tlargest=arr[j];
	 	    }
	   }
	   System.out.println(tlargest);
}
}