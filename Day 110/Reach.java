//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class Reach
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthPoint(n);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int nthPoint(int n)
    {
        final int MOD = 1000000007;
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        // Calculate ways for each point starting from the 2nd point
        for (int i = 2; i <= n; i++) {
            // You can reach the current point from the previous two points
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        // The result is the number of ways to reach the Nth point
        return dp[n];
    }
}
