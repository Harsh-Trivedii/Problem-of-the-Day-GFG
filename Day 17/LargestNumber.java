//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class LargestNumber{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java





class Solution {

    static String findLargest(int d, int s) {
        // Base case
        if (s == 0) {
            if (d == 1) {
                return "0"; // 0 is a valid result for d=1 and s=0
            } else {
                return "-1"; // Cannot form a number with more than one digit and s=0
            }
        }
        // If s is greater than 9 times d, then it is
        // impossible to form a d-digit number whose sum of
        // digits is s.
        if (s > 9 * d) {
            return "-1"; // Return as a string
        }
        // Initialize an empty string to store the result.
        StringBuilder result = new StringBuilder();
        // Loop through each digit of the number.
        for (int i = 0; i < d; i++) {
            // If s is greater than or equal to 9, then add
            // 9 to the result and subtract 9 from s.
            if (s >= 9) {
                result.append('9');
                s -= 9;
            } else {
                result.append(Integer.toString(s));
                s = 0;
            }
            if (s == 0 && i < d - 1) {
                result.append(String.join("", Collections.nCopies(d - i - 1, "0")));
                break;
            }
        }
        return result.toString();
    }
}



