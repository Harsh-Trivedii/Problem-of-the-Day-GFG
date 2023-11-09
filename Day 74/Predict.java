//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Predict
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int arr[][] = new int[N][N];
            
            for(int i = 0; i < N; i++)
            {
                int k = 0;
                String str[] = read.readLine().trim().split("\\s+");
                for(int j = 0; j < N; j++){
                  arr[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            
            System.out.println(new Solution().columnWithMaxZeros(arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int columnWithMaxZeros(int arr[][], int N)
    {
        // code here 
         int maxZeros = 0; // Initialize the maximum number of zeros to 0.
        int columnIndex = -1; // Initialize the column index to -1 (no valid column yet).

        for (int j = 0; j < N; j++) {
            int zerosInColumn = 0; // Initialize the count of zeros in the current column.

            for (int i = 0; i < N; i++) {
                if (arr[i][j] == 0) {
                    zerosInColumn++;
                }
            }

            // If the current column has more zeros than the previous maximum, update the maximum and column index.
            if (zerosInColumn > maxZeros) {
                maxZeros = zerosInColumn;
                columnIndex = j;
            }
        }

        // If the maximum number of zeros is 0, return -1 as specified.
        if (maxZeros == 0) {
            return -1;
        }

        return columnIndex;

    }
}
