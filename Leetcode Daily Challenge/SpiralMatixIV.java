/*
L.C: 2326. Spiral Matrix IV

You are given two integers m and n, which represent the dimensions of a matrix.

You are also given the head of a linked list of integers.
Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise), starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.

Return the generated matrix.

Example 1:

Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
Explanation: The diagram above shows how the values are printed in the matrix.
Note that the remaining spaces in the matrix are filled with -1.

Example 2:
Input: m = 1, n = 4, head = [0,1,2]
Output: [[0,1,2,-1]]
Explanation: The diagram above shows how the values are printed from left to right in the matrix.
The last space in the matrix is set to -1.
 
Constraints:

1 <= m, n <= 105
1 <= m * n <= 105
The number of nodes in the list is in the range [1, m * n].
0 <= Node.val <= 1000
*/

import java.util.Arrays;

public class SpiralMatixIV {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            next = null;
        }
    }
    public static ListNode createLinkedList(int values[]){
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for(int i = 1;i<values.length;i++){
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }
    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for (int i[]: ans) {
            Arrays.fill(i, -1);
        }
        int startingRow = 0;
        int endingCol = n - 1;
        int endingRow = m - 1;
        int startingCol = 0;
      
        while (head != null) {
            // printing the starting row
            for (int i = startingCol; i <= endingCol && head != null; i++) {
                ans[startingRow][i] =  head.val;
                head = head.next;
            }
            startingRow++;
            // printing the ending column
            for (int i = startingRow; i <= endingRow && head != null; i++) {
                ans[i][endingCol] =  head.val;
                head = head.next;
            }
            endingCol--;    
            // printing the ending row
            for (int i = endingCol; i >= startingCol  && head != null; i--) {
                ans[endingRow][i] = head.val;
                head = head.next;
            }
            endingRow--;
            // printing the starting column
            for (int i = endingRow; i >= startingRow && head != null; i--) {
                ans[i][startingCol] =  head.val;
                head = head.next;
            }
            startingCol++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int m = 3;
        int n = 5;
        int arr[] = {3,0,2,6,8,1,7,9,4,2,5,5,0};
        ListNode head = createLinkedList(arr);
        int ans[][] = spiralMatrix(m, n, head);
        for(int i[] : ans){
            System.out.print(Arrays.toString(i));
        }
    }
}
