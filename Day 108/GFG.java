//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        final int MOD = 1000000007;
        
        // dp[i][0] represents the count of binary strings of length i ending with 0
        // dp[i][1] represents the count of binary strings of length i ending with 1
        long[][] dp = new long[n + 1][2];
        
        // Base cases
        dp[1][0] = 1; // Binary string of length 1 ending with 0
        dp[1][1] = 1; // Binary string of length 1 ending with 1
        
        // Fill the dp array using the recurrence relation
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD; // Append 0 to any string ending with 0 or 1
            dp[i][1] = dp[i - 1][0] % MOD; // Append 1 only to the strings ending with 0
        }
        
        // Sum the counts of binary strings of length n ending with 0 and 1
        return (dp[n][0] + dp[n][1]) % MOD;
    }
}
