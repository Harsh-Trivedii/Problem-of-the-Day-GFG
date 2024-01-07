//{ Driver Code Starts
import java.io.*;
import java.util.*;

class SplitArray {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends




class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        
        //the approach is going to be a pure binary search based
        
        //we know the minimum possible sum in the array is the
        //max of the array right.
        //so, we can make low as the maximum element of the array.
        //and the maximum sum possible could be the sum of array element
        //obviously.
        
        int low=Arrays.stream(arr).max().getAsInt();
        int high=Arrays.stream(arr).sum();
        
        int ans=0;
        
        while(low<=high)
        {
            int mid=(low+high)/2;
            
            if(isValidToSplit(mid,arr,K))
            {
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    
    //now lets write the isValid function
    static boolean isValidToSplit(int mid,int[] arr,int k)
    {
        int tot=1;          //tot represents total subarray
        int sum=0;
        
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            
            if(sum>mid)        //means we have to divide the array right.
            {
                sum=arr[i];
                tot++;           //since we have divided, so to number of subarray count will be increased by 1.
            }
        }
        
        return tot<=k;   //obviously total subarray as mentioned in the question, should be less then or equal to given k
    }
    
    
    
    
    
};
