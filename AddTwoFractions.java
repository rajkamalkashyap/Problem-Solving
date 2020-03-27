package gs;

import java.util.Scanner;

public class AddTwoFractions {

	public static void main(String[] args) {
		/*int arr1[] = { 1, 500 };
		int arr2[] = { 2, 500 };*/
		int arr1[] = { 5, 6 };
		int arr2[] = { 2, 3 };
		int ans[] = addFraction(arr1, arr2);
		System.out.println(ans[0] + " " + ans[1]);

	}

	private static int[] addFraction(int[] arr1, int[] arr2) {
		if( ( arr1.length != 2 ) || ( arr2.length != 2 ) ) {
		      throw new IllegalArgumentException( "Arguments passed should be two-element arrays" );
		    }
		if( arr1[1] == 0 || arr2[1] == 0 ) {
		      throw new IllegalArgumentException( "Denominator in at least one of the input fractions is zero, which is not allowed." );
		  }
		int a = arr1[0] * arr2[1];
		int b = arr1[1] * arr2[0];
		int c = arr1[1] * arr2[1];
		int d = a + b;
		int gcd = gcd(c, d);
		int ans1 = d / gcd;
		int ans2 = c / gcd;
		// System.out.println(ans1+" "+ans2);
		int ans[] = new int[2];
		ans[0] = ans1;
		ans[1] = ans2;
		return ans;

	}

	/*static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}*/
	
	static int gcd(int no1, int no2) {
		if (no1 == 0 || no2 == 0)
			return 0;
		if (no1 == no2)
			return no1;
		if (no1 > no2)
			return gcd(no1 - no2, no2);
		else
			return gcd(no1, no2 - no1);
	}


}
