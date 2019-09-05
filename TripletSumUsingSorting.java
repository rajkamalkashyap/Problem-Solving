package gs;

import java.util.Arrays;
// https://www.youtube.com/watch?v=QiocLLg2otc
// https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
// https://github.com/coach4dev/IsTripletExistInArrayWithGivenSum/blob/master/TripletWithGivenSumExist/Program.cs
public class TripletSumUsingSorting {
	public static void main(String args[]) {
		int arr[] = { 1, 9, 7, 6, 3, 5, 2, 8 };
		// int first = 0, sec = 0, third = 0;
		int flg = 0;
		int sum = 10;
		int n = arr.length;
		//Arrays.sort(arr);
		boolean ans = isTripletSumExists(arr, n, sum);
		System.out.println(ans);
	}

	private static boolean isTripletSumExists(int[] arr, int n, int sum) {
		if (arr == null || n < 3)
            return false;
		Arrays.sort(arr);
		for (int i = 0; i < n - 2; i++) {
			int left = i + 1;
			int right = n - 1;
			while (left < right) {
				if (arr[i] + arr[left] + arr[right] == sum)
					return true;
				else if (arr[i] + arr[left] + arr[right] > sum)
					right--;
				else if(arr[i] + arr[left] + arr[right] < sum)
					left++;
			}
		}
		return false;
	}
}
