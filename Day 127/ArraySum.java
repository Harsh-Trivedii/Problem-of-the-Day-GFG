//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class ArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public boolean canPair(int[] nums, int k) {
        // Check if the length of the array is even
        if (nums.length % 2 != 0) {
            return false;
        }

        // Create a frequency map to store the count of remainders when divided by k
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Populate the frequency map
        for (int num : nums) {
            int remainder = (num % k + k) % k; // Handle negative numbers
            frequencyMap.put(remainder, frequencyMap.getOrDefault(remainder, 0) + 1);
        }

        // Iterate through the array again to check if each pair can be formed
        for (int num : nums) {
            int remainder = (num % k + k) % k; // Handle negative numbers

            // If the current remainder is 0, check if it has even frequency
            if (remainder == 0) {
                if (frequencyMap.getOrDefault(remainder, 0) % 2 != 0) {
                    return false;
                }
            } else {
                // For non-zero remainders, check if the complement remainder exists
                int complement = k - remainder;
                if (!frequencyMap.containsKey(complement) || frequencyMap.get(complement) != frequencyMap.get(remainder)) {
                    return false;
                }
            }
        }

        return true;
    }
}
