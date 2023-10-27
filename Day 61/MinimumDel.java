//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class MinimumDel{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String S) {
        //your code here
        int n = S.length();
        
        // Create a 2D array to store the minimum number of deletions required
        // to make substrings of S palindrome.
        int[][] dp = new int[n][n];
        
        // Initialize the diagonal elements to 1 because each character is a palindrome by itself.
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        // Fill in the dp table using a bottom-up approach.
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (S.charAt(i) == S.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The minimum number of deletions needed is the total length of the string minus
        // the length of the longest palindromic subsequence.
        return n - dp[0][n - 1];

    }
}
