//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class PalindromePartitioning{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String s)
    {
        // code here
        if (s.isEmpty())
            return 0;
        int n = s.length();
 
        // 2D array to store whether substring [i, j] is a
        // palindrome
        boolean[][] pal = new boolean[n][n];
 
        generatePalindrome(s, pal);
 
        // Array to store minimum cuts required to make
        // substring [i, n-1] palindromic
        int[] minCutDp = new int[n];
        Arrays.fill(minCutDp, Integer.MAX_VALUE);
 
        // There is no cut required for single character
        // as it is always palindrome
        minCutDp[0] = 0;
 
        // Iterate over the given string
        for (int i = 1; i < n; i++) {
 
            // Check if string 0 to i is palindrome.
            // Then minCut require will be 0.
            if (pal[0][i]) {
                minCutDp[i] = 0;
            }
            else {
                for (int j = i; j >= 1; j--) {
 
                    // If s[i] and s[j] are equal and the
                    // inner substring [i+1, j-1] is a
                    // palindrome or it has a length of 1
                    if (pal[j][i]) {
 
                        // Update the minimum cuts required
                        // if cutting at position 'j+1'
                        // results in a smaller value
                        if (minCutDp[j - 1] + 1
                            < minCutDp[i])
                            minCutDp[i]
                                = minCutDp[j - 1] + 1;
                    }
                }
            }
        }
 
        // Return the minimum cuts required for the entire
        // string 's'
        return minCutDp[n - 1];
    }
    
    static boolean generatePalindrome(String s,
                                      boolean[][] pal)
    {
        int n = s.length();
 
        // Initialize the palindrome matrix for single
        // characters
        for (int i = 0; i < n; i++) {
            pal[i][i] = true;
        }
 
        // Iterate over different lengths of substrings
        for (int len = 2; len <= n; len++) {
            // Iterate over the starting positions of
            // substrings of current length
            for (int i = 0; i <= n - len; i++) {
 
                // Calculate the ending position of the
                // substring
                int j = i + len - 1;
 
                // Check if the characters at the starting
                // and ending positions are equal and if the
                // substring between them is a palindrome or
                // a single character
                if (s.charAt(i) == s.charAt(j)
                    && (len == 2 || pal[i + 1][j - 1])) {
 
                    // Mark the substring from i to j as a
                    // palindrome
                    pal[i][j] = true;
                }
            }
        }
 
        return true;
    }
 
    
}
