package gs;

public class SmallestSubArrayWithSumGreaterThanXFinal {

	public static void main(String[] args) {
		/*int arr[] = {1,2,3,4};
		int n = arr.length;
		int x = 6;*/
		
		/*int arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
	    int x = 280;*/
		
		int arr[] = {- 8, 1, 4, 2, -6}; 
	    int x = 6; 
		//int ans=smallestSubWithSum(arr, n, x);
		int ans=subArrayExceedsSum(arr, x);
		System.out.println(ans);
		/*if(ans == n+1)
			System.out.println("Not possible");
		else*/
		//System.out.println(ans-1);

	}
	
	public static int subArrayExceedsSum(int arr[], int target) {
		int i = 0, j = 0, length = Integer.MAX_VALUE, size = arr.length;

		if (target <= 0)
			return 0;

		if (size < 1)
			return -1;

		int currsum = arr[0];
		while (true) {
			if (currsum >= target) {
				if (i == j)
					return (1);
				else {
					if (j - i + 1 < length)
						length = j - i + 1;
					currsum -= arr[i];
					i++;
					//System.out.println("Len:"+length+" "+currsum);
				}
			}	
			else {
				j++;
				if (j == size)
					break;
				else
					currsum += arr[j];
				
				//for negative senario
				if (currsum <= 0 && target > 0) 
	            { 
	                i = j; 
	                currsum = 0; 
	            }
				//System.out.print("currsum:"+currsum+" ");
			}
			
		}
		
		if (length == Integer.MAX_VALUE)
			return -1;

		return length;
	}
	
	/*private static int smallestSubWithSum(int[] arr, int n, int x) {
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
			if(curr_sum<x)
				return -1;
			//System.out.println("chec:"+curr_sum);
			while(curr_sum > x && start <n) {
				if(end- start < min_len)
					min_len=end- start;
				
				curr_sum = curr_sum - arr[start++];
			}
			
		}
		return min_len;
	}*/
	
}
