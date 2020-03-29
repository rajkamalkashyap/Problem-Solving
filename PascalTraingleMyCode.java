package gs.practiceCode;

/*
**  Below formation is called Pascals Triangle.
**
**  Example:
**               1
**              1 1
**             1 2 1
**            1 3 3 1
**           1 4 6 4 1
**         1 5 10 10 5 1
**        1 6 15 20 15 6 1
**
**  Complete the 'pascal' function below so that given a
**  col and a row it will return the value in that positon.
**
**  Example, pascal(1,2) should return 2
**
*/

/* 
*					******** IMPORTANT ********
*
* THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
* USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
*
*/
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public static  int pascal(int col, int row){
	  	if(row ==0 && col == 0)
	  		return 1;
	  	else {	
		int k=Math.max(col, row);
		int arr[][] = new int[k+1][k+1];

		int ans[][] = constructPascal(arr, k+1);
		return ans[row][col];
	  	}
	
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
  public static void main(String[] args) {
	  if(Solution.pascal(0,0) ==  1 &&
			  Solution.pascal(1,2) ==  2 &&
			  Solution.pascal(1,1) ==  1 &&
			  Solution.pascal(0,1) ==  1 &&
			  Solution.pascal(2,2) ==  1 &&
			  Solution.pascal(5,6) ==  6 &&
			  Solution.pascal(4,8) ==  70 &&
			  Solution.pascal(6,6) ==  1) {
		  System.out.println("Pass");		  
	  }else {
		  System.out.println("Failed");
	  }
  }
}
