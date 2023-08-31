Problem of the day: AVL Tree Deletion

Question: Given an AVL tree and N values to be deleted from the tree. Write a function to delete a given value from the tree. 
All the N values which needs to be deleted are passed one by one as input data by driver code itself, you are asked to return the root of modified tree after deleting the value.

Example 1:

Tree = 
        4
      /   \
     2     6
    / \   / \  
   1   3 5   7

N = 4
Values to be deleted = {4,1,3,6}

Input: Value to be deleted = 4
Output:
        5    
      /   \
     2     6
    / \     \  
   1   3     7

Input: Value to be deleted = 1
Output:
        5    
      /   \
     2     6
      \     \  
       3     7

Input: Value to be deleted = 3
Output:
        5    
      /   \
     2     6
            \  
             7

Input: Value to be deleted = 6
Output:
        5    
      /   \
     2     7


Expected Time Complexity: O(height of tree)
Expected Auxiliary Space: O(height of tree)

Constraints:
1 ≤ N ≤ 500
