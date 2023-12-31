//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] coins = IntArray.input(br, N);
            
            Solution obj = new Solution();
            boolean res = obj.isPossible(N, coins);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends






class Solution {
    
    public static boolean isPossible(int N, int[] coins) {
        int sum=0;
        for(int i:coins) sum += i;
        int dp[][] = new int[N][sum+1];
        for(int[] arr:dp) Arrays.fill(arr, -1);
        return f(0,0,N, coins, dp)==1;
    }
    
    public static int f(int i, int t, int n, int a[], int dp[][]){
        if(t!=0 && (t%20==0 || t%24==0 || t==2024)) return 1;
        if(i>=n) return 0;
        if(dp[i][t] != -1) return dp[i][t];
        
        int pick = f(i+1, t+a[i], n, a, dp);
        if(pick == 1) return 1;
        int nonpick = f(i+1, t, n, a, dp);
        return dp[i][t] = pick | nonpick;
    }
}
        
