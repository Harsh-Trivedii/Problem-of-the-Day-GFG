//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class FirstBit {
    
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//taking testcases
		while(t-->0){
			int n=sc.nextInt();//input n
			Solution ob=new Solution();
			System.out.println(ob.getFirstSetBit(n));//calling method
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
            
        // Your code here
        String bin=Integer.toBinaryString(n);
        // int binary=Integer.valueOf(bin);
        for(int i=(bin.length()-1);i>=0;i--)
        {
            if(bin.charAt(i)=='1')
            {
                int result=bin.length()-i;
                return result;
            }
        }
        return 0;
            
    }
}
