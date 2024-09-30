/*
L.c : 54. Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
[1,2,3,4,5,6,12,18,24,30,29,28,27,26,25,19,13,7,8,9,10,11,17,23,22,21,20,14,15,16]
Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */

import java.util.ArrayList;
import java.util.List;
public class SpiralPrint {
    public static List<Integer> spiralPrint(int matrix[][]){
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int total = row*col;

        int startingrow = 0;
        int endingcol = col-1;
        int endingrow = row-1;
        int startingcol = 0;
        int count = 0;
        while(count<total){
            // print Strting row
            for(int i = startingcol;i<=endingcol && count<total;i++){
                ans.add(matrix[startingrow][i]);
                count++;
            }
            startingrow++;
            // print ending column
            for(int i = startingrow;i<=endingrow && count<total;i++){
                ans.add(matrix[i][endingcol]);
                count++;
            }
            endingcol--;
            // print ending row
            for(int i = endingcol;i>=startingcol && count<total;i--){
                ans.add(matrix[endingrow][i]);
                count++;
            }
            endingrow--;
            // printing  starting column
            for(int i = endingrow;i>=startingrow && count<total;i--){
                ans.add(matrix[i][startingcol]);
                count++;
            }
            startingcol++;
        }
        return ans;

    }
    public static void main(String[] args) {
        // int matrix[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        // int matrix[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int matrix[][] = new int[][]{{1,2,3,4,5,6},{7,8,9,10,11,12},
        {13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30}};
        List<Integer>  result = spiralPrint(matrix);
        System.out.print(result+" ");

    }
}
