//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			insertion llist = new insertion(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.insertionSort(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }}
// } Driver Code Ends


//User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    public static Node insertionSort(Node head_ref)
    {
        //code here
            if (head_ref == null || head_ref.next == null) {
            return head_ref; // Already sorted or empty list
        }
        
        Node sortedList = null; // Head of the sorted linked list
        
        while (head_ref != null) {
            Node current = head_ref;
            head_ref = head_ref.next;
            
            if (sortedList == null || current.data < sortedList.data) {
                // Insert at the beginning of the sorted list
                current.next = sortedList;
                sortedList = current;
            } else {
                // Search for the correct position to insert in the sorted list
                Node temp = sortedList;
                while (temp.next != null && temp.next.data < current.data) {
                    temp = temp.next;
                }
                
                // Insert after temp in the sorted list
                current.next = temp.next;
                temp.next = current;
            }
        }
        
        return sortedList;
    }
}
