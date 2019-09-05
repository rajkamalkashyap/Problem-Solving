package gs;

import java.util.Scanner;

public class MinInSortedRotatedArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test = 0; test < t; test++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				int tmp = sc.nextInt();
				arr[i] = tmp;
			}
			int low = 0, high = arr.length - 1;
			int ans = solve(arr, low, high);
			System.out.println(ans);
		}
	}

	private static int solve(int[] a, int low, int high) {
		int mid = (high + low) / 2;

		if (high < low)
			return a[0];
		if (low == high)
			return a[low];
		if (a[mid + 1] < a[mid] && mid < high)
			return a[mid + 1];
		if (a[mid - 1] > a[mid] && mid > low)
			return a[mid];

		// if (a[mid - 1] < a[mid] && a[mid + 1] > a[mid]) {
		if (a[high] < a[mid] && a[high] < a[low])
			return solve(a, mid + 1, high);
		else
			return solve(a, low, mid - 1);
		// }

	}

}
