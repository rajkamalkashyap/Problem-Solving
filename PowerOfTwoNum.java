package gs;
 // https://www.youtube.com/watch?v=wAyrtLAeWvI&t=309s
public class PowerOfTwoNum {
	/*static double power(double x, int y) {
		if (y == 0)
			return 1;
		else if (y % 2 == 0)
			return power(x, y / 2) * power(x, y / 2);
		else
			return  (x * power(x, y / 2) * power(x, y / 2));
	}
*/
	/* Program to test function power */
	public static void main(String[] args) {
		double x = 2;
		int y = 3;

		//System.out.printf("%d", power(x, y));
		System.out.println(power(x,y));
	}
	
	/*static double power(double x, int n) {
		
		if (n == 0)
			return 1;
		else if (n % 2 == 0) {
			double y=power(x, n / 2);
			return y*y;
		}
		else
			return  (x * power(x,n-1));
	}*/
	
	static double power(double base, int exp) {
		if (base == 0)
			return 0;
		if (exp == 0)
			return 1;
		if (exp == 1)
			return base;
		int positiveExp = (exp < 0) ? exp * -1 : exp;
		double result = (positiveExp % 2 == 0) ? power(base, positiveExp/2)* power(base, positiveExp/2)
				: base * power(base, (positiveExp - 1));
		return exp < 0 ? 1 / result : result;
	}

}
