Problem of the day: Leaf under budget
Question link: https://practice.geeksforgeeks.org/problems/leaf-under-budget/1
Question: Given a binary tree and a budget. Assume you are at the root of the tree(level 1), you need to maximise the count of leaf nodes you can visit in your budget if the cost of visiting a leaf node is equal to the level of that leaf node.

Example 1:

Input: 
                  10
                /    \
               8      2
             /      /   \
            3      3     6
                    \
                     4
and budget = 8
Output: 2
Explanation:
Cost For visiting Leaf Node 3: 3
Cost For visiting Leaf Node 4: 4
Cost For visiting Leaf Node 6: 3
In budget 8 one can visit Max 2 Leaf Nodes.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1<=N<=105
1<=budget<=104

Test Cases Passed: 
1120 /1120
