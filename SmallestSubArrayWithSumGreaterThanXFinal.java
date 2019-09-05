package gs;

public class SmallestSubArrayWithSumGreaterThanXFinal {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4};
		int n = arr.length;
		int x = 6;
		int ans=smallestSubWithSum(arr, n, x);
		System.out.println(ans);

	}

	private static int smallestSubWithSum(int[] arr, int n, int x) {
		int curr_sum = 0, min_len = n + 1;
		int start = 0, end = 0;
		while (end < n) {
			while(curr_sum <= x && end<n) {
				if (curr_sum <= 0 && x > 0) 
	            { 
	                start = end; 
	                curr_sum = 0; 
	            }  //to handle negative integers
				curr_sum= curr_sum +arr[end++];
			}
			while(curr_sum > x && start <n) {
				if(end- start < min_len)
					min_len=end- start;
				
				curr_sum = curr_sum - arr[start++];
			}
			
		}
		return min_len;
	}

}
