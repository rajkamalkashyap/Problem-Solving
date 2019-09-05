package gs;

public class SecondSmallest {

	public static void main(String args[]) {

		
		  
		  /*int arr1[]= {2,4,5,6,78,9,3}; 
		  int n1=arr1.length;*/ 
		  /*double x=(double)1/(double)3;
		  
		  String s=Double.toString(x); 
		  System.out.println(s); 
		  String s1=s.substring(2,18); 
		  System.out.println(s1);*/
		  
		 

		
		  
		 /* String s = "123412341234", ans = ""; 
		  for (int i = 0; i < s.length(); i++) {
		  
		  char c = s.charAt(i);
		  int xx = ans.indexOf(c); 
		  if (xx >= 0) break; 
		  else ans = ans + c; }
		  System.out.println(ans);*/
		  
		 

		int arr[] = { 12, 13, 1, 10, 34, 1 };
		int n = arr.length, first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] < first) {
				second = first;
				first = arr[i];
			} else if (arr[i] < second && arr[i] != first) {
				second = arr[i];
			}
		}
		System.out.println(second);
	}
}
