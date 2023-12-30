//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    // Function to return the name of the candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // HashMap to store the count of votes for each candidate.
        Map<String, Integer> voteCount = new HashMap<>();

        // Iterate through the array to count the votes for each candidate.
        for (String candidate : arr)
        {
            voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        }

        // Variables to store the winner and the maximum count of votes.
        String winner = "";
        int maxVotes = 0;

        // Iterate through the HashMap to find the winner.
        for (Map.Entry<String, Integer> entry : voteCount.entrySet())
        {
            String candidate = entry.getKey();
            int votes = entry.getValue();

            // Update the winner if the current candidate has more votes or is lexicographically smaller.
            if (votes > maxVotes || (votes == maxVotes && candidate.compareTo(winner) < 0))
            {
                winner = candidate;
                maxVotes = votes;
            }
        }

        // Return the result in the required format.
        String[] result = {winner, String.valueOf(maxVotes)};
        return result;
    }
}
