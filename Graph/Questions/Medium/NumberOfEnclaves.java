/*
L.C: 1020. Number of Enclaves

You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Example 1:
Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

Example 2:
Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1. 
*/

// time complexity: O(n*m)
//space complexity: O(n*m) 
import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int row,col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
public class NumberOfEnclaves {
    static int n,m;
    public static int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        boolean vis[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i= 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i == 0  || j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1){
                        vis[i][j] = true;
                        q.add(new Pair(i,j));
                    }
                }
            }
        }
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;

            for(int i = 0;i<4;i++){
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];
                if(nrow >= 0 && nrow < n && ncol>=0 && ncol <m 
                && !vis[nrow][ncol]  && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow,ncol));
                    vis[nrow][ncol] = true;
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    // DFS approach
    // time complexity: O(n*m)
    //space complexity: O(n*m)
    public static void dfs(int row,int col,boolean vis[][],int grid[][],int delRow[],int delCol[]){
        vis[row][col] = true;
        for(int i = 0;i<4;i++){
            int nrow = row+delRow[i];
            int ncol = col+delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
            && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                dfs(nrow,ncol,vis,grid,delRow,delCol);
            }
        }
    }
    public static int numEnclavesI(int grid[][]){
        n = grid.length;
        m = grid[0].length;
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};
        boolean vis[][] = new boolean[n][m];
        // tarverse 1st row and last row
        for(int j = 0;j<m;j++){
            if(!vis[0][j] && grid[0][j] == 1){
                dfs(0,j,vis,grid,delRow,delCol);
            }
            if(!vis[n-1][j] && grid[n-1][j] == 1){
                dfs(n-1,j,vis,grid,delRow,delCol);
            }
        }
        // tarverse 1st and last column
        for(int i = 0;i<n;i++){
            if(!vis[i][0] && grid[i][0] == 1){
                dfs(i,0,vis,grid,delRow,delCol);
            }
            if(!vis[i][m-1] && grid[i][m-1] == 1){
                dfs(i,m-1,vis,grid,delRow,delCol);
            }
        }
        int count = 0;
        for(int  i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };
        System.out.println(numEnclaves(grid)); 
        System.out.println(numEnclavesI(grid));
    }
}
