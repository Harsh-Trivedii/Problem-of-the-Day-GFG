//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Sequence
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution{
    static int numberSequence(int m, int n)
    {
        // code here
        if(n==0)
        return 0;
        
        if(n==1)
        return m;
        
        int sum=0;
        for(int i=1;i<=m;i++){
            sum+=numberSequence(i/2,n-1);
        }
        return sum;
    }
}
