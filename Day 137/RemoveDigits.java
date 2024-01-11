//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class RemoveDigits {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends

class Solution {
    public String removeKdigits(String S, int K) {
        int n = S.length();
        
        // If K is equal to the length of the string, return "0"
        if (K == n) {
            return "0";
        }

        Deque<Character> stack = new LinkedList<>();

        // Iterate through each digit in the string
        for (char digit : S.toCharArray()) {
            // While K is greater than 0 and the current digit is less than the top of the stack
            while (K > 0 && !stack.isEmpty() && stack.peekLast() > digit) {
                stack.pollLast();
                K--;
            }
            stack.offerLast(digit);
        }

        // Remove remaining K digits from the end if necessary
        while (K > 0) {
            stack.pollLast();
            K--;
        }

        // Build the result string from the deque
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pollFirst());
        }

        // Remove leading zeros
        int i = 0;
        while (i < result.length() && result.charAt(i) == '0') {
            i++;
        }

        // If the resulting string is empty, return "0"; otherwise, return the result
        return (i == result.length()) ? "0" : result.substring(i);
    }
}
