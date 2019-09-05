package gs;

public class IsPowerOfTen {

	public static void main(String[] args) {
		boolean ans=isPowerOf10(100);
		System.out.println(ans);
	}

	public static boolean isPowerOf10(int x) {
		for (int i = 1; i <= x; i *= 10) {
			if (i == x) {
				return true;
			}

			if (i > Integer.MAX_VALUE / 10) {
				return false;
			}
		}
		return false;
	}
}
