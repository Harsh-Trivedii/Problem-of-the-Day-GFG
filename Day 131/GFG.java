//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java


//User function Template for Java

class Solution
{
    public int fiboo(int  n ,int  modulo) {
        int  a= 0 ; 
        int  b= 1;
        while( n >= 0 ) {
            int  c= ((a % modulo) +(b % modulo)) % modulo;
            a=b;
            b=c;
            n--;
        }
        return b;
    }
    public int TotalWays(int N)
    {
        // Code here
        int  modulo =1000000007; 
        int n  =  fiboo(N,modulo) ;
         long m = ((long) n * n) % modulo;
        return (int) m; 
        
    }
}
