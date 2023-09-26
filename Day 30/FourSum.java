//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> quadruples = new ArrayList<>();
        
        // Sort the input array
        Arrays.sort(arr);
        
        // Iterate through the array to select the first two elements
        for (int i = 0; i < arr.length - 3; i++) {
            // Skip duplicates for the first element of the quadruple
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < arr.length - 2; j++) {
                // Skip duplicates for the second element of the quadruple
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }
                
                int left = j + 1;  // Initialize left pointer
                int right = arr.length - 1;  // Initialize right pointer
                
                while (left < right) {
                    int currentSum = arr[i] + arr[j] + arr[left] + arr[right];
                    
                    if (currentSum == k) {
                        // Found a valid quadruple, add to the result list
                        ArrayList<Integer> quadruple = new ArrayList<>();
                        quadruple.add(arr[i]);
                        quadruple.add(arr[j]);
                        quadruple.add(arr[left]);
                        quadruple.add(arr[right]);
                        quadruples.add(quadruple);
                        
                        // Move pointers to avoid duplicates
                        while (left < right && arr[left] == arr[left + 1]) {
                            left++;
                        }
                        while (left < right && arr[right] == arr[right - 1]) {
                            right--;
                        }
                        
                        left++;
                        right--;
                    } else if (currentSum < k) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return quadruples;
    }
}
