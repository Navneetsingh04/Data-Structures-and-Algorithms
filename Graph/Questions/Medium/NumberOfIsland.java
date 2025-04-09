/*
L.C: 200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/

// Time Complexity: O(N*M) 
// Space Complexity: O(N*M) for the visited array.

import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int first,second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
public class NumberOfIsland {
    static int n,m;
    public static int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(i,j,vis,grid);
                    // bfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(int i,int j,boolean vis[][],char[][] grid){
        if(i<0 || i>=n || j<0 || j>=m ||grid[i][j] == '0' || vis[i][j]){
            return;
        }
        vis[i][j] = true;
        dfs(i-1,j,vis,grid);  // up
        dfs(i+1,j,vis,grid);  // down
        dfs(i,j-1,vis,grid);  // left
        dfs(i,j+1,vis,grid);  // right
    }
    public static void bfs(int i,int j,boolean vis[][],char[][] grid){
        Queue<Pair> q = new LinkedList<>();
        vis[i][j] = true;
        q.add(new Pair(i,j));
        int[] delrow = {-1,1,0,0};
        int[] delcol = {0,0,-1,1};
        while(!q.isEmpty()){
            Pair p = q.poll(); 
            int row = p.first;
            int col = p.second;

            for(int k = 0;k<4;k++){
                int nrow = row+delrow[k];
                int ncol = col+delcol[k];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && grid[nrow][ncol] == '1' && !vis[nrow][ncol]){
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
    }    
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid)); 
    }
}
