//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class FrogJump implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        // add your code here
         int MOD = 1000000007;
        long[] count = new long[n+1];
  
        // Initialize base values. There is one way to
        // cover 0 and 1 distances and two ways to
        // cover 2 distance
        count[0] = 1;
          if(n >= 1)
            count[1] = 1;
        if(n >= 2)
              count[2] = 2;
  
        // Fill the count array in bottom up manner
        for (int i=3; i<=n; i++)
            count[i] = (count[i-1] + count[i-2] + count[i-3]) % MOD;
  
        return count[n];
    }
    
}

