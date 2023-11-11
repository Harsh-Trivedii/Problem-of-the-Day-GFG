//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        // Your code here
        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Boolean> visited = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            // If the character in str1 is already mapped but not to the same character in str2.
            if (map.containsKey(char1)) {
                if (map.get(char1) != char2) {
                    return false;
                }
            } else {
                // If the character in str1 is not mapped, but the character in str2 is already mapped.
                if (visited.containsKey(char2)) {
                    return false;
                }

                // Map the characters in str1 to str2.
                map.put(char1, char2);
                // Mark the character in str2 as visited.
                visited.put(char2, true);
            }
        }

        return true;
        
    }
}
