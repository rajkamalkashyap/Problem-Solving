package gs;

public class JosephusProblem {
	static int josephus(int n, int k) {
		if (n == 1)
			return 1;
		else
			/*
			 * The position returned by josephus(n - 1, k) is adjusted because the recursive
			 * call josephus(n - 1, k) considers the original position k%n + 1 as position 1
			 */
			return (josephus(n - 1, k) + k - 1) % n + 1;
	}

	// Driver Program to test above function
	public static void main(String[] args) {
		int n = 7;
		int k = 3;
		System.out.println("The chosen place is " + josephusIterative(n, k));
	}

	static int josephusIterative(int n, int k) {

		int a = 1;
		for (int i = 1; i <= n; i++) {
			a = (a + k - 1) % i + 1;
			System.out.println(a);
		}
		return a;
	}
}
