//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class BintoBST {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            Node rootA = g.binaryTreeToBST(root);
            printInorder(rootA);
            System.out.println();
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

/*Structure of the node class is
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */


class Solution {
    // Convert binary tree to BST
    Node binaryTreeToBST(Node root) {
        // Step 1: Traverse the binary tree and store values in a list
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);

        // Step 2: Sort the values
        values.sort(null);

        // Step 3: Build a new BST using the sorted values
        return buildBST(values, 0, values.size() - 1);
    }

    // In-order traversal to populate the values list
    void inorderTraversal(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, values);
        values.add(node.data);
        inorderTraversal(node.right, values);
    }

    // Build BST from sorted values
    Node buildBST(List<Integer> values, int start, int end) {
        if (start > end) {
            return null;
        }

        // Find the middle index
        int mid = (start + end) / 2;

        // Create the root node using the middle value
        Node root = new Node(values.get(mid));

        // Recursively build left and right subtrees
        root.left = buildBST(values, start, mid - 1);
        root.right = buildBST(values, mid + 1, end);

        return root;
    }
}
 
