package gs.practiceCode;

/*
** Instructions to candidate.
**  1) You are an avid rock collector who lives in southern California. Some rare 
**     and desirable rocks just became available in New York, so you are planning 
**     a cross-country road trip. There are several other rare rocks that you could 
**     pick up along the way. 
**     
**     You have been given a grid filled with numbers, representing the number of 
**     rare rocks available in various cities across the country.  Your objective 
**     is to find the optimal path from So_Cal to New_York that would allow you to 
**     accumulate the most rocks along the way. 
**     
**     Note: You can only travel either north (up) or east (right).
**  2) Consider adding some additional tests in doTestsPass().
**  3) Implement optimalPath() correctly.
**  4) Here is an example:
**                                                           ^
**                 {{0,0,0,0,5}, New_York (finish)           N
**                  {0,1,1,1,0},                         < W   E >
**   So_Cal (start) {2,0,0,0,0}}                             S
**                                                           v 
**   The total for this example would be 10 (2+0+1+1+1+0+5).
*/

import java.io.*;
import java.util.*;

class testInGsFormat_practice {

	public static Integer optimalPath(Integer[][] grid) {
	    int row_len = grid.length;
	    int col_len = grid[0].length;

		return solve(grid,0,col_len-1,row_len,col_len);
	}
	static Integer solve(Integer[][] arr,int x1, int y1,int row_len,int col_len) {
		 
		if(x1==row_len-1 && y1 == 0) {
			return arr[x1][y1];
		} 
		if(x1<0 || x1>=row_len || y1<0 || y1>=col_len) return -100000000;
		else {
			return arr[x1][y1]+ Math.max(solve(arr,x1+1,y1,row_len,col_len), solve(arr,x1,y1-1, row_len, col_len));
		}
	}
	
	
	public static boolean doTestsPass() {
		boolean result = true;
		result &= optimalPath(new Integer[][] { { 0, 0, 0, 0, 5 }, { 0, 1, 1, 1, 0 }, { 2, 0, 0, 0, 0 } }) == 10;
		return result;
	}

	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("Tests fail.");
		}
	}
}
