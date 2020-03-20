package gs;

// https://www.youtube.com/watch?v=uAWxDcFaVwc
public class GcdOfTwoNumber {

	public static void main(String[] args) {
		int no1 = 10, no2 = 15;
		int ans = gcd(10, 15);
		System.out.println(ans);
	}

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
