package gs;

public class MedianOfTwoSortedArrayBrute {

	public static void main(String[] args) {
		/*
		 * int arr1[] = { 1, 12, 15, 26, 38 }; int arr2[] = { 2, 13, 17, 30, 45 };
		 */
		int arr1[] = { 1, 3 };
		int arr2[] = { 2 };
		double median = findMedianSortedArrays(arr1, arr2);
		System.out.println(median);

	}

	public static double findMedianSortedArrays(int[] A, int[] B) {

		int sortedArray[] = merge(A, B, A.length, B.length);
		int length = sortedArray.length;
		double median;
		if (length % 2 == 0) {
			int index1 = length / 2;
			int index2 = index1 + 1;
			// index -1 because array index starts with o
			median = (sortedArray[index1 - 1] + sortedArray[index2 - 1]) / 2.0;
		} else {
			int index = (length / 2) + 1;
			median = sortedArray[index - 1];
		}

		return median;
		// System.out.println();
		/*
		 * for (int ii = 0; ii < sortedArray.length; ii++)
		 * System.out.print(sortedArray[ii] + " ");
		 */

	}

	private static int[] merge(int[] arr1, int[] arr2, int length, int length2) {
		int arr3[] = new int[length + length2];
		int k = 0, i = 0, j = 0;

		while (i < length && j < length2) {
			if (arr1[i] < arr2[j]) {
				arr3[k++] = arr1[i];
				i++;
			} else if (arr1[i] > arr2[j]) {
				arr3[k++] = arr2[j];
				j++;
			}
		}
		while (i < length)
			arr3[k++] = arr1[i++];
		while (j < length2)
			arr3[k++] = arr2[j++];

		/*
		 * for (int ii = 0; ii < arr3.length; ii++) System.out.print(arr3[ii] + " ");
		 */
		return arr3;
	}

}
