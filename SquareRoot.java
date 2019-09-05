package gs;
 // https://www.geeksforgeeks.org/square-root-of-a-perfect-square/
// Babylonian method  
/*1 Start with an arbitrary positive start value x (the closer to the 
		   root, the better).
		2 Initialize y = 1.
		3. Do following until desired approximation is achieved.
		  a) Get the next approximation for root using average of x and y
		  b) Set y = n/x*/
public class SquareRoot {
	/*
	 * Returns the square root of n. Note that the function
	 */
	static float squareRoot(float n) {

		/*
		 * We are using n itself as initial approximation This can definitely be
		 * improved
		 */
		float x = n;
		float y = 1;

		// e decides the accuracy level
		double e = 0.000001;
		while (x - y > e) {
			x = (x + y) / 2;
			y = n / x;
		}
		return x;
	}

	/*
	 * Driver program to test above function
	 */
	public static void main(String[] args) {
		int n = 2;

		System.out.printf("Square root of " + n + " is " + squareRoot(n));
	}
}
