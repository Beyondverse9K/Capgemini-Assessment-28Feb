package practice;

public class PrimsMST {

	public PrimsMST() {
		// TODO Auto-generated constructor stub
	}
	static final int N = 5;
	public static void main(String[] args) {
		int[][] cost = {
				{0, 2, 0, 6, 0},
				{2, 0, 3, 8, 5},
				{0, 3, 0, 0, 7},
				{6, 8, 0, 0, 9},
				{0, 5, 7, 9, 0}
		};
		boolean[] visited = new boolean[N];
		visited[0] = true;
		int edgesAdded = 0;
		int totalCost = 0;
		while (edgesAdded < N-1) {
			int min = Integer.MAX_VALUE;
			int x = -1, y = -1;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					for (int j = 0; j < N; j++) {
						if (!visited[j] && cost[i][j] != 0 && cost[i][j] < min) {
							min = cost[i][j];
							x = i;
							y = j;
						}
					}
				}
			}
			visited[y] = true;
			totalCost += min;
			edgesAdded++;
			System.out.println(x+">"+y+"Cost="+min);
		}
		System.out.println("Minimum total cost =" + totalCost);
	}
}
