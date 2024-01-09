//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class SearchPattern
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> search(String pat, String txt)
    {
        ArrayList<Integer> result = new ArrayList<>();

        int M = pat.length();
        int N = txt.length();

        for (int i = 0; i <= N - M; i++) {
            int j;

            // Check for pattern match at the current index
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;

            // If the pattern is present at the current index
            if (j == M)
                result.add(i + 1); // Adding 1 to convert to one-based indexing
        }

        // If no occurrences are found, return -1
        if (result.isEmpty())
            result.add(-1);

        return result;
    }
}
