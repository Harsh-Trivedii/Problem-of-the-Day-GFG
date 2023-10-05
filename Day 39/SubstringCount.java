//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class SubstringCount
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    long substrCount(String S, int K) {
        return atMostK(S, K) - atMostK(S, K - 1);
    }

    private long atMostK(String S, int K) {
        long count = 0;
        int left = 0;
        int[] freq = new int[26];
        int distinctCount = 0;

        for (int right = 0; right < S.length(); right++) {
            if (freq[S.charAt(right) - 'a'] == 0) {
                distinctCount++;
            }
            freq[S.charAt(right) - 'a']++;

            while (distinctCount > K) {
                freq[S.charAt(left) - 'a']--;
                if (freq[S.charAt(left) - 'a'] == 0) {
                    distinctCount--;
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
