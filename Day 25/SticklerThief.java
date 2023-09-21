//{ Driver Code Starts
import java.util.*;
import java.io.*;

class SticklerThief
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    int dp[];
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(arr, n, 0);
    }
    
    int helper(int arr[], int n, int idx){
        if(idx >= n)return 0;
        if(dp[idx] != -1)return dp[idx];
        int take = arr[idx] + helper(arr, n, idx+2);
        int notTake = helper(arr, n, idx+1);
        
        return dp[idx] = Math.max(take, notTake);
    }
}
