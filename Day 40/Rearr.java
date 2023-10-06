//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node odd)
    {
       if(odd.next == null || odd.next.next == null) return;
        Node curr = odd;
        int cnt = 1;
        while(curr.next!=null){
            curr = curr.next;
            cnt++;
        }
       Node first = odd;
       Node prev = null;
       Node second = first.next;
       while(first.next != null && second.next != null){
           first.next = second.next;
           first = second.next;
           second.next = prev;
           prev = second;
           second = first.next;
       }
       if(cnt%2 == 0){
            second.next = prev;
       }
       else{
            first.next = prev;
       }
    }
}
