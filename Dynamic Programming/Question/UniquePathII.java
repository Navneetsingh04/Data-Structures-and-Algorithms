/*
L.C: 63. Unique Paths II

You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Example 2:
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1

Constraints:
m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
*/

import java.util.Arrays;
public class UniquePathII {
    public static int solveUsingMem(int n,int m,int[][] obstacleGrid,int[][] dp){
        if(n < 0 || m < 0) return 0;
        if(obstacleGrid[n][m] == 1) return 0;
        if(n == 0 && m == 0) return 1;
        if(dp[n][m] != -1) return dp[n][m];
        int up = solveUsingMem(n-1,m,obstacleGrid,dp);
        int left = solveUsingMem(n,m-1,obstacleGrid,dp);
        
        dp[n][m] = left+up;
        return dp[n][m];
    }
    public static int solveUsingTab(int n,int m,int[][] obstacleGrid){
        int[][] dp = new int[n][m]; 
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                    int up = 0;
                    int left = 0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[n-1][m-1];
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        // int ans = solveUsingMem(n-1,m-1,obstacleGrid,dp);
        int ans = solveUsingTab(n,m,obstacleGrid);
        return ans;
    }
    public static void main(String[] args) {
        int arr[][] = {{0,0,0},{0,1,0},{0,0,0}};
        int ans = uniquePathsWithObstacles(arr);
        System.out.println(ans);
    }
}
