/*
L.C: 221. Maximal Square

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

Example 2:
Input: matrix = [["0","1"],["1","0"]]
Output: 1

Example 3:
Input: matrix = [["0"]]
Output: 0

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.
*/
public class MaximalSquare {
    public static int maxi = 0;
    public static int solve(char matrix[][],int i,int j,int row,int col){
        if(i >= row || j >= col){
            return 0;
        }
        // exploring all three direction
        int right = solve(matrix, i, j+1, row, col);
        int diagnol = solve(matrix, i+1, j+1, row, col);
        int down = solve(matrix, i+1, j, row, col);
        
        // check can we build square form current position
        if(matrix[i][j] == '1'){
            int ans = 1+Math.min(right,Math.min(diagnol,down));
            maxi =  Math.max(maxi, ans);
            return ans;
        }
        else{
            return 0;
        }
    }
    public static int maximalSquare(char matrix[][]){
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = 0;
        maxi = 0;
        solve(matrix,i,j,row,col);
        return maxi*maxi;
    }
    public static void main(String[] args) {
        char matrix[][] = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println("Maximal Square Area is: "+maximalSquare(matrix));
    }
}
