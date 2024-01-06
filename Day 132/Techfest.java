//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Techfest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long sumOfPowers(long a, long b) {
        // Generate primes up to b using the Sieve of Eratosthenes
        ArrayList<Integer> primes = generatePrimes((int) b);

        // Calculate the sum of powers for each number between a and b
        long sum = 0;
        for (long i = a; i <= b; i++) {
            sum += calculateSumOfPowers(i, primes);
        }

        return sum;
    }

    private static ArrayList<Integer> generatePrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    private static long calculateSumOfPowers(long num, ArrayList<Integer> primes) {
        long sum = 0;

        for (int prime : primes) {
            if (prime * prime > num) {
                break;
            }

            int count = 0;
            while (num % prime == 0) {
                num /= prime;
                count++;
            }

            sum += count;
        }

        if (num > 1) {
            sum++;
        }

        return sum;
    }
}
        
