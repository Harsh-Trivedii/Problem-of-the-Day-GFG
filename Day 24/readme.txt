Problem of the day: Rotate Bits

Question link: https://practice.geeksforgeeks.org/problems/rotate-bits4524/1

Question: Given an integer N and an integer D, rotate the binary representation of the integer N by D digits to the left as well as right and return the results in their decimal representation after each of the rotation.
Note: Integer N is stored using 16 bits. i.e. 12 will be stored as 0000000000001100.

Example 1:

Input:
N = 28, D = 2
Output:
112
7
Explanation: 
28 in Binary is: 0000000000011100
Rotating left by 2 positions, it becomes 0000000001110000 = 112 (in decimal).
Rotating right by 2 positions, it becomes 0000000000000111 = 7 (in decimal).

Expected Time Complexity: O(1).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <  216
1 <= D <= 105
