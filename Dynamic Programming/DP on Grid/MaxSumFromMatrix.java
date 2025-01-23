/*
You have been given an N*M matrix filled with integer numbers, find the maximum sum that can be obtained from a path starting from any cell in the first row to any cell in the last row.

From a cell in a row, you can move to another cell directly below that row, or diagonally below left or right. So from a particular cell (row, col), we can move in three directions i.e.

Down: (row+1,col)
Down left diagonal: (row+1,col-1)
Down right diagonal: (row+1, col+1)
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 50
1 <= N <= 100
1 <= M <= 100
-10^4 <= matrix[i][j] <= 10^4

Where 'T' is the number of test cases.
Where 'N' is the number of rows in the given matrix, and 'M' is the number of columns in the given matrix.
And, matrix[i][j] denotes the value at (i,j) cell in the matrix.

Time Limit: 1sec
Input 1 :
2
4 4
1 2 10 4
100 3 2 1
1 1 20 2
1 2 2 1
3 3
10 2 3
3 7 2
8 1 5
Output 1 :
105
25
 */

import java.util.* ;
public class MaxSumFromMatrix {
	public static int solveUsingMem(int i,int j,int[][] matrix,int dp[][]){
		if(j<0 || j>=matrix[0].length) return (int) -1e9;
		if(i == 0) return matrix[0][j];
		if(dp[i][j] != -1) return dp[i][j];
		int up = matrix[i][j]+solveUsingMem(i-1, j, matrix, dp);
		int ld = matrix[i][j]+solveUsingMem(i-1, j-1, matrix, dp);
		int rd = matrix[i][j]+solveUsingMem(i-1, j+1, matrix, dp);
		
		return dp[i][j] = Math.max(up,Math.max(ld,rd));
	}
	public static int solveUsingTab(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int dp[][] = new int[n][m];
		for(int i[]: dp){
			Arrays.fill(i,-1);
		}
		for(int j = 0;j<m;j++){
			dp[0][j] = matrix[0][j];
		}
		for(int i = 1;i<n;i++){
			for(int j = 0;j<m;j++){
				int up = matrix[i][j]+dp[i-1][j];
				int ld = matrix[i][j];
				int rd = matrix[i][j];
				if(j-1 >= 0){
					ld += dp[i-1][j-1];
				} 
				else{
					ld += (int) -1e9;
				}
				if(j+1 < m){
					rd += dp[i-1][j+1];
				}
				else{
					rd += (int) -1e9;
				}
				dp[i][j] = Math.max(up,Math.max(ld,rd));
			}
		}
		int maxi = (int) -1e9;
		for(int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
        }
		return maxi;
	}
	public static int spaceOptimization(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int prev[] = new int[m];
		int curr[] = new int[m];

		for(int j = 0;j<m;j++){
			prev[j] = matrix[0][j];
		}
		for(int i = 1;i<n;i++){
			for(int j = 0;j<m;j++){
				int up = matrix[i][j]+prev[j];
				int ld = matrix[i][j];
				int rd = matrix[i][j];
				if(j-1 >= 0){
					ld += prev[j-1];
				} 
				else{
					ld += (int) -1e9;
				}
				if(j+1 < m){
					rd += prev[j+1];
				}
				else{
					rd += (int) -1e9;
				}
				curr[j] = Math.max(up,Math.max(ld,rd));
			}
			int[] temp = prev;
            prev = curr;
            curr = temp;

		}
		int maxi = (int) -1e9;
		for(int j = 0; j < m; j++) {
            maxi = Math.max(maxi, prev[j]);
        }
		return maxi;
	}
	public static int getMaxPathSum(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int dp[][] = new int[n][m];
		for(int i[]: dp){
			Arrays.fill(i,-1);
		}
		int maxi = (int) -1e9;
		for(int j = 0; j < m; j++) {
            maxi = Math.max(maxi, solveUsingMem(n - 1, j, matrix, dp));
        }
		return maxi;
	}
    public static void main(String[] args) {
        int[][] matrix = {
            {2, 3, 4},
            {6, 5, 7},
            {4, 1, 8}
        };
        // System.out.println("Maximum sum form Matrix is: "+getMaxPathSum(matrix));
        // System.out.println("Maximum sum form Matrix is: "+solveUsingTab(matrix));
		System.out.println("Maximum sum form Matrix is: "+spaceOptimization(matrix));
    }
}

