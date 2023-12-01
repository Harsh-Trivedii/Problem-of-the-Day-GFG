//{ Driver Code Starts

import java.util.*;
import java.io.*;
class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
class BST {
    public static Node root;
    BinarySearchTree() { 
        root = null; 
    }
    void insert(int key) {
       root = insertRec(root, key);
    }
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);
        return root;
    }
 
    public static void inorder()  {
       inorderRec(root);
    }
    public static void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data);
            inorderRec(root.right);
        }
    }
 
    // Driver Program to test above functions
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []a=new int[n];
            BinarySearchTree obj1=new BinarySearchTree();
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                obj1.insert(b);
            }
            //inorder();
            Solution obj=new Solution();
            boolean k=obj.isDeadEnd(root);
            if(k==true)
            System.out.println("1");
            else
            System.out.println("0");
        }       
    }
}


// } Driver Code Ends


/*class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }*/

//Function should return true if a deadEnd is found in the bst otherwise return false.
class Solution
{
    static boolean isDeadEnd(Node root)
    {
        return isDeadEndUtil(root, 1, Integer.MAX_VALUE);
    }
    
    static boolean isDeadEndUtil(Node root, int min, int max)
    {
        // Base case: Empty tree or leaf node
        if (root == null)
            return false;

        // Check if the current node's value is a dead end
        if (min == max)
            return true;

        // Recursively check left and right subtrees
        boolean left = isDeadEndUtil(root.left, min, root.data - 1);
        boolean right = isDeadEndUtil(root.right, root.data + 1, max);

        // Return true if either subtree has a dead end
        return left || right;
    }
}
