package practice;

public class RodCutting {
	public static int cutRod(int[] price) {
        // Unbounded Knapsack Variation
        int n = price.length; // total number of available piece lengths
        // dp[j] = maximum profit for rod of length j
        int[] dp = new int[n+1];
        dp[0] = 0; // rod length 0 has profit 0
        for(int i=1; i<n+1; i++) { // i = number of pieces considered (or piece length)
            for(int j=i; j<n+1; j++) { // // j = current rod length, must be >= i
                int currPrice = price[i-1]; // price of piece of length i
                int include = currPrice + dp[j-i]; // include current piece and reduce rod length by i
                int exclude = dp[j]; // skip current piece
                dp[j] = Math.max(include, exclude); // choose the better option
            }
        }
        // maximum profit for rod of full length n
        return dp[n];
    }
    public static void main(String[] args) {
		//int [] startTime = {1,2,3,3};
		//int [] endTime = {3,4,5,6};
		int [] profit = {50,10,40,70};
		System.out.println(cutRod(profit));
	}
}

