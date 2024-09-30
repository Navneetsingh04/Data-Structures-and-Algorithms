/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 
Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
 */
// Time compexity : O(n^2)

public class RotateImage {
    public static void rotateImage(int mat[][]) {
        if (mat.length != mat[0].length) {
            System.out.println("Matrix should be a Square Matrix");
        } 
        else {
            int n = mat.length;
            // Transpose the matrix
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
            // Reverse each row of the transposed matrix
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<n/2 ; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[i][n-j-1];
                    mat[i][n-j-1] = temp;
                }
            }
            System.out.println("Printing the Rotated Image");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int mat[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage(mat);
    }
}
