//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Pattern
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        // code here
String r = "";
        Stack<Integer> st = new Stack<>();
        int num = 1;
        for(int p=0;p<S.length();p++){
            st.push(num);
            num++;
            if(S.charAt(p) == 'I'){
                while(!st.isEmpty()){
                    r += (char)(st.pop()+'0');    
                }
            }
        }
        st.push(num);
        while(!st.isEmpty()){
            r += (char)(st.pop()+'0');
        }
        return r;
    }
}
