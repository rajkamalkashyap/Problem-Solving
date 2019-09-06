package gs;

public class OptimalPath {
	
	static int x=3,y=5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] arr =
				{
					{ 0,0,0,0,5 },
					{ 0,1,1,1,0 },
					{ 2,0,0,0,0 },
					
				};
		System.out.println(solve(arr,0,y-1));

	}

	static int solve(int[][] arr,int x1, int y1) {
		 
		if(x1==x-1 && y1 == 0) {
			return arr[x1][y1];
		} 
		if(x1<0 || x1>=x || y1<0 || y1>=y) return -100000000;
		else {
			return arr[x1][y1]+ Math.max(solve(arr,x1+1,y1), solve(arr,x1,y1-1));
		}
	}
	/*static int solve(int x1, int y1) {
		 
		if(x1==x-1 && y1 == 0) {
			return arr[x1][y1];
		} 
		if(x1<0 || x1>=x || y1<0 || y1>=y) return -100000000;
		else {
			return arr[x1][y1]+ Math.max(solve(x1+1,y1), solve(x1,y1-1));
	 
		}
	}*/
}
