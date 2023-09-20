//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class RotateBits
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    
    ArrayList<Integer> rotate(int N, int D) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int binaryLength = 16; // Assuming N is stored using 16 bits
        
        // Ensure D is in the range [0, binaryLength)
        D = D % binaryLength;
        
        // Convert N to binary string
        String binaryN = Integer.toBinaryString(N);
        while (binaryN.length() < binaryLength) {
            binaryN = "0" + binaryN;
        }
        
        // Perform left rotation
        String leftRotatedBinary = binaryN.substring(D) + binaryN.substring(0, D);
        int leftRotatedDecimal = Integer.parseInt(leftRotatedBinary, 2);
        result.add(leftRotatedDecimal);
        
        // Perform right rotation
        String rightRotatedBinary = binaryN.substring(binaryLength - D) + binaryN.substring(0, binaryLength - D);
        int rightRotatedDecimal = Integer.parseInt(rightRotatedBinary, 2);
        result.add(rightRotatedDecimal);
        
        return result;
    }
}
