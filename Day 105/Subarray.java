//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Subarray {
	public static void main (String[] args) {
		//code
			//code
			
		//taking input using class Scanner
		Scanner scan = new Scanner(System.in);
		
		//taking total number of testcases
		int t = scan.nextInt();
		while(t>0)
		{
		    //taking total count of elements
		    int n = scan.nextInt() ;
		    
		    //Declaring and Initializing an array of size n
		    int arr[] = new int[n];
		    
		    //adding elements to the array
		    for(int i = 0; i<n;i++)
		    {
		        arr[i] = scan.nextInt();
		    }
		    
		    t--;
		    
		     //calling the method findSum
		     //and print "YES" or "NO" based on the result
		     System.out.println(new Solution().findsum(arr,n)==true?"Yes":"No");
		}
	}
	
	
}
// } Driver Code Ends


class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[], int n) {
        // Your code here
        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            // If prefix sum becomes 0 at any index or if the prefix sum is already in the set,
            // then there is a subarray with 0 sum.
            if (prefixSum == 0 || set.contains(prefixSum)) {
                return true;
            }

            // Add the current prefix sum to the set.
            set.add(prefixSum);
        }

        // If no subarray with 0 sum is found, return false.
        return false;
    }
}
