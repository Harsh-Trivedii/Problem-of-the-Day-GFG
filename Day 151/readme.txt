Problem of the day: Shortest Prime Path

Question link: https://www.geeksforgeeks.org/problems/shortest-prime-path--141631/1

Question: You are given two four digit prime numbers num1 and num2. Find the distance of the shortest path from Num1 to Num2 that can be attained by altering only single digit at a time such that every number that we get after changing a digit is a four digit prime number with no leading zeros.

Example 1:

Input:
num1 = 1033 
num2 = 8179
Output: 6
Explanation:
1033 -> 1733 -> 3733 -> 3739 -> 3779 -> 8779 -> 8179.
There are only 6 steps reuired to reach num2 from num1. 
and all the intermediate numbers are 4 digit prime numbers.
Example 2:

Input:
num1 = 1033 
num2 = 1033
Output:
0
Your Task:  
You don't need to read input or print anything. Your task is to complete the function solve() which takes two integers num1 and num2 as input parameters and returns the distance of the shortest path from num1 to num2. If it is unreachable then return -1.

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(n)

Constraints:
1000<=num1,num2<=9999
num1 and num2 are prime numbers.
