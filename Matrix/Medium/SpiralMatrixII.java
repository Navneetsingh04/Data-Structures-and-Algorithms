/*
L.C: 59. Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:
Input: n = 1
Output: [[1]]
 
Constraints:
1 <= n <= 20 
*/
import java.util.Arrays;

public class SpiralMatrixII {
    public static int[][] spiralMatrix(int n){
        int matrix[][] = new int[n][n];
        int count = 1;
        for(int i = 0;i<(n+1)/2;i++){
            // left to right filling
            for(int j = i;j<n-i;j++){
                matrix[i][j] = count++;
            }
            // top to bottom filling
            for(int j = i+1;j<n-i;j++){
                matrix[j][n-i-1] = count++;
            }
            // right to left filling
            for(int j = i+1;j<n-i;j++){
                matrix[n-i-1][n-j-1] = count++;
            }
            // bottom to up
            for(int j = i+1;j<n-i-1;j++){
                matrix[n-j-1][i] = count++;
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        int n = 5;
        int ans[][] = spiralMatrix(n);
        for(int i[] : ans){
            System.out.println(Arrays.toString(i)+" ");
        }
    }
}
