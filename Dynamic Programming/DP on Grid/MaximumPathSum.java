/*
L.C: 64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200
*/
import java.util.Arrays;
public class MaximumPathSum {
    public static int solveUsingMem(int n,int m,int[][] grid,int dp[][]){
        if(n == 0 && m == 0) return grid[n][m];
        if(n < 0 || m < 0) return Integer.MAX_VALUE;
        if(dp[n][m] != -1) return dp[n][m];
        int up = solveUsingMem(n-1,m,grid,dp);
        int left = solveUsingMem(n,m-1,grid,dp);
        dp[n][m] =  grid[n][m]+Math.min(up,left);
        return dp[n][m];
    }
    public static int solveUsingTab(int n,int m,int[][] grid){
        int dp[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i == 0 &&  j == 0) dp[i][j] = grid[i][j];
                else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i>0) up = dp[i-1][j]+grid[i][j];
                    if(j>0) left = dp[i][j-1]+grid[i][j];
                    dp[i][j] = Math.min(left,up);
                }
            }
        }
        return dp[n-1][m-1];
    }
    public static int solveUsingSO(int n,int m,int[][] grid){
        int prev[] = new int[m];
        for(int i = 0;i<n;i++){
            int curr[] = new int[m];
            for(int j = 0;j<m;j++){
                if(i == 0 &&  j == 0) curr[j] = grid[i][j];
                else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i>0) up = prev[j]+grid[i][j];
                    if(j>0) left = curr[j-1]+grid[i][j];
                    curr[j] = Math.min(left,up);
                }
            }
            prev = curr;
        }
        return prev[m-1];
    }
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n+1][m+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        int ans = solveUsingMem(n-1,m-1,grid,dp);
        // int  ans = solveUsingTab(n,m,grid);
        // int ans = solveUsingSO(n,m,grid);
        return ans;
    }
    public static void main(String[] args) {
        int arr[][] = {{1,3,1},{1,5,1},{4,2,1}};
        int ans = minPathSum(arr);
        System.out.println(ans);
    }
}
