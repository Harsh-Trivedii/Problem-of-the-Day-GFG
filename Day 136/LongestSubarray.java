//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution {
    int longSubarrWthSumDivByK(int a[], int n, int k) {
        // Create a prefix sum array to store the cumulative sum
        int[] prefixSum = new int[n];

        // Initialize the prefix sum array
        prefixSum[0] = a[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + a[i];

        // Initialize variables to store the result and the remainder
        int maxLen = 0;
        int mod = 0;

        // Create a HashMap to store the remainder and its corresponding index
        HashMap<Integer, Integer> modIndexMap = new HashMap<>();

        // Traverse the prefix sum array
        for (int i = 0; i < n; i++) {
            // Calculate the remainder when the current prefix sum is divided by K
            mod = (prefixSum[i] % k + k) % k;

            // If the remainder is 0, update maxLen to the current index + 1
            if (mod == 0)
                maxLen = i + 1;

            // If the remainder is not present in the HashMap, add it along with the index
            if (!modIndexMap.containsKey(mod))
                modIndexMap.put(mod, i);

            // If the remainder is present in the HashMap, update maxLen based on the difference
            else
                maxLen = Math.max(maxLen, i - modIndexMap.get(mod));
        }

        // Return the result
        return maxLen;
    }
}



//{ Driver Code Starts.

// Driver class
class LongestSubarray {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}



// } Driver Code Ends
