/*
L.C: 62. Unique Paths

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 
Constraints:

1 <= m, n <= 100
*/

import java.util.Arrays;

public class UniquePath {
     public static int solveUsingMem(int i,int j,int dp[][]){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int up = solveUsingMem(i-1,j,dp);
        int left = solveUsingMem(i,j-1,dp);
        dp[i][j] = up+left;
        return dp[i][j];
    }
    public static int solveUsingTab(int m,int n){
        int dp[][] = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }
                else{
                    int left = 0;
                    int up = 0;
                    if(i>0){
                        up = dp[i-1][j];
                    }
                    if(j>0){
                        left = dp[i][j-1];
                    }
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solveUsingMem(m-1,n-1,dp);
    }
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        // System.out.println(uniquePaths(m, n));
        System.out.println(solveUsingTab(m, n));

    }
}
