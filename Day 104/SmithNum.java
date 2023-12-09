//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class SmithNum {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.smithNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static int smithNum(int n) {
        // Check if the number is prime
        if (isPrime(n)) {
            return 0; // Prime numbers cannot be Smith numbers
        }

        // Function to calculate the sum of digits of a number
        int digitSum = getDigitSum(n);

        // Get the prime factors of the number
        ArrayList<Integer> primeFactors = getPrimeFactors(n);

        // Calculate the sum of digits of prime factors
        int primeFactorsSum = 0;
        for (int factor : primeFactors) {
            primeFactorsSum += getDigitSum(factor);
        }

        // Check if the number is a Smith number
        return (digitSum == primeFactorsSum) ? 1 : 0;
    }

    // Function to check if a number is prime
    static boolean isPrime(int num) {
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

    // Function to calculate the sum of digits of a number
    static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // Function to get the prime factors of a number
    static ArrayList<Integer> getPrimeFactors(int num) {
        ArrayList<Integer> factors = new ArrayList<>();

        // Divide by 2 until it's not divisible by 2
        while (num % 2 == 0) {
            factors.add(2);
            num /= 2;
        }

        // Check odd factors starting from 3
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }

        // If the remaining number is a prime greater than 2
        if (num > 2) {
            factors.add(num);
        }

        return factors;
    }
}
