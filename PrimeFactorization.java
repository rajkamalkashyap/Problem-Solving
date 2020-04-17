package gs;

import java.util.ArrayList;

public class PrimeFactorization {

	public static void main(String args[]) {
//		ArrayList ans=primeFactors(1575);
//		System.out.println(ans);
		ArrayList ans=primeFactors(15);
		System.out.println(ans);
		//primeFactors(6);
		// System.out.println(ans);
	}

	public static ArrayList<Integer> primeFactors(int n) {
		ArrayList<Integer> al= new ArrayList<Integer>();
		// Print the number of 2s that divide n
		while (n % 2 == 0) {
			//System.out.print(2 + " ");
			al.add(2);
			n /= 2;
		}
		// n must be odd at this point. So we can
		// skip one element (Note i = i +2)
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			// While i divides n, print i and divide n
			while (n % i == 0) {
			//	System.out.print(i + " ");
				al.add(i);
				n /= i;
			}
		}
		// This condition is to handle the case whien
		// n is a prime number greater than 2
		if (n > 2)
			//System.out.print(n);
			al.add(n);
		
		return al;
	}

}
