package firstdemo;

public class Island {

	public Island() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr= {{1,4,7},{2,0,8},{3,6,9}};
		int[][] cords= {{1,1,1},{1,1,1},{1,1,1}};
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==0)
					cords[i][j]=1;
			}
		}
		
	}

}
