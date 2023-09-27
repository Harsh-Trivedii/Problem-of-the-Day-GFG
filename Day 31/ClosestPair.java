//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class ClosestPair {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        // code here4
        int minDiff = Integer.MAX_VALUE;
        int res1 = -1, res2 = -1; // Elements from arr and brr forming the closest pair

        int i = 0, j = m - 1; // Initialize pointers for the first and last elements in brr

        while (i < n && j >= 0) {
            int sum = arr[i] + brr[j];
            int diff = Math.abs(sum - x);

            // Check if the current pair has a smaller difference
            if (diff < minDiff) {
                minDiff = diff;
                res1 = arr[i];
                res2 = brr[j];
            }

            // If the sum is less than x, increment the pointer for arr
            if (sum < x) {
                i++;
            }
            // If the sum is greater than x, decrement the pointer for brr
            else {
                j--;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(res1);
        result.add(res2);
        return result;
    }
}
