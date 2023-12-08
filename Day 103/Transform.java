//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }
            Solution ob = new Solution();
            int ans=ob.minNumber(a,n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minNumber(int arr[], int N)
    {
        // Step 1: Calculate the sum of the array
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        // Step 2: Check if the sum is a prime number
        if (isPrime(sum)) {
            return 0; // No need to insert any number
        }

        // Step 3: Find the minimum positive number to be inserted
        int diff = nextPrime(sum) - sum;
        return diff;
    }

    // Helper method to check if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Helper method to find the next prime number greater than a given number
    private int nextPrime(int num) {
        while (!isPrime(++num)) {
            // Keep incrementing until a prime number is found
        }
        return num;
    }
}
