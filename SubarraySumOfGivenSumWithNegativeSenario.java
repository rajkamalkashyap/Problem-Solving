package DS;

import java.util.HashMap;

//Find subarray with given sum | Set 2 (Handles Negative Numbers)
//Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
//Ouptut: Sum found between indexes 2 and 4
class AZ5 {
	public static void main(String[] args) {
		int arr[] = { 10, 2, -2, -20, 10 };
		int n = arr.length;
		int sum = -12;

		subArraySum(arr, n, sum);

	}

//Function to print subarray with sum as given sum
	static void subArraySum(int arr[], int n, int sum) {
//create an empty map

		HashMap<Integer, Integer> map = new HashMap<>();
//Maintains sum of elements so far
		int curr_sum = 0;

		for (int i = 0; i < n; i++) {
//add current element to curr_sum
			curr_sum = curr_sum + arr[i];

//if curr_sum is equal to target sum
//we found a subarray starting from index 0
//and ending at index i
			if (curr_sum == sum) {
				System.out.println("Sum found between indexes 0 to" + i);
				return;
			}

//If curr_sum - sum already exists in map
//we have found a subarray with target sum
			if (map.containsKey(curr_sum - sum)) {
				System.out.println("Sum found between indexes " + (map.get(curr_sum - sum) + 1) + " to " + i);
				return;
			}
			map.put(curr_sum, i);

		}

//If we reach here, then no subarray exists
		System.out.println("No subarray with given sum exists");

	}

}
