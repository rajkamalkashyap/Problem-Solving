package gs;

public class Atoi {

	public static void main(String args[]) {
		String s = "123";
		int ans = PrintAtoi(s);
		System.out.println(ans);
	}

	static int PrintAtoi(String s) {
		if (s == null || s.length() < 0)
			return 0;
		s = s.trim();
		int flag = 1;
		char c = s.charAt(0);
		int i = 0;
		if (c == '-') {
			flag = 0;
			i++;
		} else if (c == '+') {
			i++;
		}
		double ans = 0.0;
		for (int k = i; k < s.length(); k++) {
			if (s.charAt(k) >= '0' && s.charAt(k) <= '9')
				ans = ans * 10 + (s.charAt(k) - '0');
		}
		if (flag == 0)
			ans = -ans;

		if (ans > Integer.MAX_VALUE)
			ans = Integer.MAX_VALUE;

		if (ans < Integer.MIN_VALUE)
			ans = Integer.MIN_VALUE;
		return (int) ans;
	}
}

/*
 * 
 * 1. null or empty string 2. white spaces 3. +/- sign 4. calculate real value
 * 
 * 5. handle min & max
 * 
 */
