package gs;

import java.util.*; 

class MinimalStep 
{ 
  
// fucntion to return the minimal number of moves 
static int minimalSteps(String s, int n) 
{ 
  
    int []dp = new int[n]; 
      
    // initializing dp[i] to INT_MAX 
    for (int i = 0; i < n; i++) 
        dp[i] = Integer.MAX_VALUE; 
  
    // initialize both strings to null 
    String s1 = "", s2 = ""; 
      
    // base case 
    dp[0] = 1; 
  
    s1 += s.charAt(0); 
  
    for (int i = 1; i < n; i++) 
    { 
        s1 += s.charAt(i); 
  
        // check if it can be appended 
        s2 = s.substring(i + 1, i + 1); 
  
        // addition of character takes one step 
        dp[i] = Math.min(dp[i], dp[i - 1] + 1); 
  
        // appending takes 1 step, and we directly 
        // reach index i*2+1 after appending 
        // so the number of steps is stord in i*2+1 
        if (s1 == s2) 
            dp[i * 2 + 1] = Math.min(dp[i] + 1,  
                                   dp[i * 2 + 1]); 
    } 
    return dp[n - 1]; 
} 
  
// Driver Code 
public static void main(String args[]) 
{ 
  
    String s = "AAAABBBB"; 
    int n = s.length(); 
  
    // fucntion call to return minimal number of moves 
    System.out.println(minimalSteps(s, n)/2); 
} 
} 
