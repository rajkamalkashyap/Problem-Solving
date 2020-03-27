package gs;

import java.util.Arrays;

public class PascalTraingleMyCode {

	public static void main(String[] args) {
		/*int k = 9;
		int arr[][] = new int[k][k];

		int ans[][] = constructPascal(arr, k);
		System.out.println(arr[2][1]);*/
		int ans=pascal(4,8);
		System.out.println(ans);
	}
	
	public static  int pascal(int col, int row){
		int k=Math.max(col, row);
		int arr[][] = new int[k+1][k+1];

		int ans[][] = constructPascal(arr, k+1);
		return ans[row][col];
	}
	
	private static int[][] constructPascal(int[][] arr, int k) {

		arr[0][0] = 1;
		for (int ii = 0; ii < k; ii++)
			arr[ii][0] = 1;
		arr[1][1] = 1;
		int i, j;
		for (i = 2; i < k; i++) {
			for (j = 1; j < i; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
			arr[i][j] = 1;
		}
		return arr;
	}

}
