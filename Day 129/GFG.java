//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        int n = S.length();
        int count[] = {0, 0, 0}; // To store the count of characters 0, 1, and 2
        int start = 0; // Start pointer of the substring
        int minLength = Integer.MAX_VALUE; // To store the minimum length of the substring

        for (int end = 0; end < n; end++) {
            // Increment the count for the current character
            count[S.charAt(end) - '0']++;

            // Check if the current substring contains all three characters
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // Update the minimum length
                minLength = Math.min(minLength, end - start + 1);

                // Decrement the count for the start character and move the start pointer
                count[S.charAt(start) - '0']--;
                start++;
            }
        }

        // If minLength is still Integer.MAX_VALUE, no substring containing all three characters exists
        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
    }
}
