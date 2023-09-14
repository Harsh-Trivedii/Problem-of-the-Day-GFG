//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class PerfectSum
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution {

    static int MOD = 1000000007;

    public int perfectSum(int arr[], int n, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= arr[i]; j--) {
                dp[j] = (dp[j] + dp[j - arr[i]]) % MOD;
            }
        }

        return dp[sum];
    }
}
