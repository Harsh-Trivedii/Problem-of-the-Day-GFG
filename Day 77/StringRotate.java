//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class StringRotate {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String a, String b)
    {
        // Your code here
        int n = a.length();
        
        // Check if lengths of both strings are equal
        if (n != b.length())
            return false;
        
        // Check if 'b' can be obtained by rotating 'a' clockwise by 2 places
        String clockwiseRotation = a.substring(n - 2) + a.substring(0, n - 2);
        if (clockwiseRotation.equals(b))
            return true;
        
        // Check if 'b' can be obtained by rotating 'a' anti-clockwise by 2 places
        String anticlockwiseRotation = a.substring(2) + a.substring(0, 2);
        return anticlockwiseRotation.equals(b);
    }
    
}
