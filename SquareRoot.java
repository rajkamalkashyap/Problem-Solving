package gs.practiceCode;
// https://www.geeksforgeeks.org/square-root-of-a-perfect-square/
// Babylonian method  
/*1 Start with an arbitrary positive start value x (the closer to the 
		   root, the better).
		2 Initialize y = 1.
		3. Do following until desired approximation is achieved.
		  a) Get the next approximation for root using average of x and y
		  b) Set y = n/x*/
public class Solution {
	/*
	 * double squareRoot( double x )
	 *
	 */

	public static double squareRoot(double n) {
	//  We are using n itself as initial approximation This can definitely be
		 // improved
		 
		double x = n;
		double y = 1;

		// e decides the accuracy level
		double e = 0.000001;
		while (x - y > e) {
			x = (x + y) / 2;
			y = n / x;
			//System.out.println("x:"+x+" y:"+y);
		}
		return x;
	
	}
	

	public static void main(String args[]) {
		double[] inputs = { 2, 4, 100 };
		double[] expected_values = { 1.41421, 2, 10 };
		double threshold = 0.001;
		for (int i = 0; i < inputs.length; i++) {
			if (Math.abs(squareRoot(inputs[i]) - expected_values[i]) > threshold) {
				System.out.printf("Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i],
						squareRoot(inputs[i]));
			}
		}
		System.out.println("All tests passed");
	}
}
