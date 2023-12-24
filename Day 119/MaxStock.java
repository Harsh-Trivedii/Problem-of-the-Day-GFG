//{ Driver Code Starts
import java.io.*;
import java.util.*;

class MaxStock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends




class Solution {
    // Make a sepated class for data storage (value and index)
    private class Pair {
        int val;
        int ind;
        
        public Pair(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }
    public int buyMaximumProducts(int n, int k, int[] price) {
        List<Pair> list = new ArrayList<Pair>();
        
        for (int i=0; i<n; i++) {
            list.add(new Pair(price[i], i+1));
        }
        // sort values by value
        Collections.sort(list, (a, b) -> {
            return (a.val - b.val);
        });
        
        int shubhcode = 0;
        for (int i=0; i<n; i++) {
            Pair node = list.get(i);
            int q = k/node.val;
            // Here i am optimize that remaining/current_value is Quantity
            if (q > node.ind) {
                shubhcode += node.ind;
                k -= node.val*node.ind;
            } else {
                shubhcode += q;
                k -= node.val*q;
            }
            // shubhcode += q;
        }
        
        return shubhcode;
        
    }
}     
