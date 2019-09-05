package gs;

import java.util.*;
import java.util.Collections;
import java.util.PriorityQueue;
 // https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0
//Almost correct, fails in some case in geeks practice
public class MedianOfStreamOfNumbers {
//	static PriorityQueue<Integer> smallBucket = new PriorityQueue<Integer>(Collections.reverseOrder());
//	static PriorityQueue<Integer> BigBucket = new PriorityQueue<Integer>();

	public static void main(String[] args) {
		// int arr[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			arr[i] = tmp;
		}
		PriorityQueue<Integer> smallBucket = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> BigBucket = new PriorityQueue<Integer>();

		for (int i = 0; i < arr.length; i++) {
			int median;
			int smallBucSize = smallBucket.size();
			int largeBucSize = BigBucket.size();

			if (smallBucSize == 0 && largeBucSize == 0)
				smallBucket.add(arr[i]);

			if (smallBucket.size() > 0) {
				int max1 = smallBucket.peek();
				if (arr[i] < max1) {
					smallBucket.add(arr[i]);
				} else if (arr[i] > max1 && largeBucSize == 0)
					BigBucket.add(arr[i]);
			}
			if (BigBucket.size() > 0) {
				int min1 = BigBucket.peek();
				if (arr[i] > min1) {
					BigBucket.add(arr[i]);
				}
			}

			int smallBucSizeNew = smallBucket.size();
			int largeBucSizeNew = BigBucket.size();
			int diff = Math.abs(smallBucSizeNew - largeBucSizeNew);
			if (diff > 1 && smallBucSizeNew > largeBucSizeNew) {
				int tmp = smallBucket.poll();
				BigBucket.add(tmp);
			} else if (diff > 1 && smallBucSizeNew < largeBucSizeNew) {
				int tmp = BigBucket.poll();
				smallBucket.add(tmp);
			}
			// System.out.println(smallBucket+ "" + BigBucket);
			int smallBucSizeFinal = smallBucket.size();
			int largeBucSizeFinal = BigBucket.size();
			if (smallBucSizeFinal == largeBucSizeFinal)
				median = (smallBucket.peek() + BigBucket.peek()) / 2;
			else if (smallBucSizeFinal > largeBucSizeFinal)
				median = smallBucket.peek();
			else
				median = BigBucket.peek();
			System.out.println(median);
		}
	}

}
