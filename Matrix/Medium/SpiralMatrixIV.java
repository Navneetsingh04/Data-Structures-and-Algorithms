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
public class SpiralMatrixIV {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val; 
        }
    }
    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        
        int matrix[][] = new int[m][n];

        for(int i[] : matrix){
            Arrays.fill(i,-1);
        }
        int rStart = 0,cStart = 0;
        int rEnd = m-1,cEnd = n-1;

        while(head != null){

            for(int i = rStart;i<=cEnd  && head != null;i++){
                matrix[rStart][i] = head.val;
                head = head.next;
            }
            rStart++;
            for(int i = rStart;i <= rEnd  && head != null;i++){
                matrix[i][cEnd] = head.val;
                head = head.next;
            }
            cEnd--;
            for(int i = cEnd;i>=cStart  && head != null;i--){
                matrix[rEnd][i] = head.val;
                head = head.next;
            }
            rEnd--;
            for(int i = rEnd;i >= rStart && head != null;i--){
                matrix[i][cStart] = head.val;
                head = head.next;
            }
            cStart++;
        }
        return matrix;
    }

    public static ListNode createLinkedList(int[] arr){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(int val : arr){
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        int m = 3,n = 5;
        int arr[] = {3,0,2,6,8,1,7,9,4,2,5,5,0};

        ListNode head = createLinkedList(arr);
        int[][] ans = spiralMatrix(m, n, head);
        for(int[] row : ans){
            System.out.println(Arrays.toString(row));
        }
    }
}
