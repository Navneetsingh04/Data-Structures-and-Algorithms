/*
L.C: 73. Set Matrix Zeroes

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.
Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
*/
public class SetMatrixZero {
    // Time complexity : O(n*m)
    // spcace complexity: O(n)+O(m);
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row[] = new int[n];
        int col[] = new int[m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int matrix[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        for(int[] matrix1 : matrix) {
            for (int j = 0; j<matrix[0].length; j++) {
                System.out.print(matrix1[j] + " ");
            }
            System.out.println();
        }
    }
}
