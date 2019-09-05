package gs;

import java.util.HashMap;

public class LengthOfCycleInArray {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 0, 4, 1 };
		int startIndex = 0;
		int len = findLengthOfCycle(arr, startIndex);
		System.out.println(len);

	}

	private static int findLengthOfCycle(int[] arr, int startIndex) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int count = 1;
		int index = startIndex;
		// while same key comes in map again,keep putting and counting the number

		// of cycle

		while (!hm.containsKey(index)) {
		if (index > arr.length)
				return -1;
			hm.put(index, count);
			count++;
			index = arr[index];
		}

		return count - hm.get(index); // total no of hops - total number of hops for that key

	}

}
