Problem of the day: Insert a node in a BST

Question link: https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1

Question: Given a BST and a key K. If K is not present in the BST, Insert a new Node with a value equal to K into the BST. If K is already present in the BST, don't modify the BST.

Example 1:

Input:
     2
   /   \   1     3
K = 4
Output: 
1 2 3 4
Explanation: 
After inserting the node 4
Inorder traversal will be 1 2 3 4.

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= Number of nodes initially in BST <= 105
1 <= K <= 109
