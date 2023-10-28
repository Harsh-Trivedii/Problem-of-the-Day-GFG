//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class Bleak
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.is_bleak(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
     public static int countSetBits(int x) {
        int count = 0;
        while (x > 0) {
            x = x & (x - 1);
            count++;
        }
        return count;
    }

    public int is_bleak(int n) {
        int upperBound = 2 * (int) (Math.log(n) / Math.log(2));
        
        for (int x = n - upperBound; x < n; x++) {
            if (x + countSetBits(x) == n) {
                return 0; // n is not Bleak
            }
        }
        return 1; // n is Bleak
    }
}
