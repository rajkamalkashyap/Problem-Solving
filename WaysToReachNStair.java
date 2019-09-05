package gs;

public class WaysToReachNStair {

	static int possibleWaysRecursive(int n) {
		if (n == 1 || n == 0)
			return 1;
		else if (n == 2)
			return 2;

		else
			return possibleWaysRecursive(n - 3) + possibleWaysRecursive(n - 2) + possibleWaysRecursive(n - 1);
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println("Recursive:" + possibleWaysRecursive(n));

		System.out.println("Dynamic:" + possibleWaysDynamic(n));
	}

	public static int possibleWaysDynamic(int n) {
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		res[2] = 2;

		for (int i = 3; i <= n; i++)
			res[i] = res[i - 1] + res[i - 2] + res[i - 3];

		return res[n];
	}
}
