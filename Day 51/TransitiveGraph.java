//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class TransitiveGraph{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void dfs(int v, int p, ArrayList<ArrayList<Integer>> adj, int[][] arr)
    {
        if(arr[p][v]==1)
            return;
        
        arr[p][v]=1;
        
        for(int a : adj.get(v)){
            dfs(a,p,adj,arr);
        }
    }
    static ArrayList<ArrayList<Integer>> transitiveClosure(int n, int graph[][])
    {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(i!=j && graph[i][j]==1)
                    adj.get(i).add(j);
        
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++)
        {
            if(arr[i][i]==0)
            {
                dfs(i,i,adj,arr);
            }
        }
        adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            for(int j=0;j<n;j++)
                adj.get(i).add(arr[i][j]);
        }
                
        return adj;
    }
}
