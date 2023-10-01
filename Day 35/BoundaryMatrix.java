//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class BoundaryMatrix
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        // code here 
        ArrayList<Integer> result=new ArrayList<Integer>();
      
        
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                result.add(matrix[0][i]);
            }
        } else if (m == 1) {
            for (int i = 0; i < n; i++) {
                result.add(matrix[i][0]);
            }
        } else {
            // Traverse the top boundary
            for (int i = 0; i < m; i++) {
                result.add(matrix[0][i]);
            }

            // Traverse the right boundary
            for (int i = 1; i < n; i++) {
                result.add(matrix[i][m - 1]);
            }

            // Traverse the bottom boundary (if it exists)
            if (n > 1) {
                for (int i = m - 2; i >= 0; i--) {
                    result.add(matrix[n - 1][i]);
                }
            }

            // Traverse the left boundary (if it exists)
            if (m > 1) {
                for (int i = n - 2; i >= 1; i--) {
                    result.add(matrix[i][0]);
                }
            }
        }
        
        return result;
    }
}
