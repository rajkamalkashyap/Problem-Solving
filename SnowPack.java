package gs;

// https://www.geeksforgeeks.org/trapping-rain-water/
public class SnowPack {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0 };
		// int arr[] = {3, 0, 0, 2, 0, 4};

		// left 0 1 3 3 3 3 3 4 4 4 4 4
		// right 4 4 4 4 4 4 4 4 3 3 3 0
		//
		int n = arr.length;
		int left[] = new int[n];
		int right[] = new int[n];
		left[0] = arr[0];
		right[n - 1] = arr[n - 1];
		for (int i = 1; i < n; i++) {
			if (arr[i] >= left[i - 1])
				left[i] = arr[i];
			else
				left[i] = left[i - 1];

		}
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] >= right[i + 1])
				right[i] = arr[i];
			else
				right[i] = right[i + 1];
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int mn = Math.min(left[i], right[i]);
			sum = sum + (mn - arr[i]);
		}
		System.out.println(sum);
		

	}

}
