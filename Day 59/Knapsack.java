//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Knapsack{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
         int[] dp = new int[W + 1];
        
        // Initialize dp array with zeros
        Arrays.fill(dp, 0);
        
        // Iterate through each item
        for (int i = 0; i < N; i++) {
            // Update dp array for all weights from wt[i] to W
            for (int j = wt[i]; j <= W; j++) {
                // Choose the maximum of two possibilities:
                // 1. Include the current item
                // 2. Exclude the current item
                dp[j] = Math.max(dp[j], dp[j - wt[i]] + val[i]);
            }
        }
        
        // Maximum value will be at dp[W]
        return dp[W];
    }
}
