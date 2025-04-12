/*
L.C: 130. Surrounded Regions

You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Example 2:
Input: board = [["X"]]
Output: [["X"]]

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'. 
*/

import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int row,col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
public class SurroundedRegions {
    static int n,m;
    public static void dfs(int row,int col,boolean vis[][],char board[][],int delRow[],int delCol[]){
        vis[row][col] = true;
        for(int i = 0;i<4;i++){
            int nrow = row+delRow[i];
            int ncol = col+delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
            && !vis[nrow][ncol] && board[nrow][ncol] == 'O'){
                dfs(nrow,ncol,vis,board,delRow,delCol);
            }
        }
    }
    public static char[][] solve(char board[][]){
        n = board.length;
        m = board[0].length;
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};
        boolean vis[][] = new boolean[n][m];
        // tarverse 1st row and last row
        for(int j = 0;j<m;j++){
            if(!vis[0][j] && board[0][j] == 'O'){
                dfs(0,j,vis,board,delRow,delCol);
            }
            if(!vis[n-1][j] && board[n-1][j] == 'O'){
                dfs(n-1,j,vis,board,delRow,delCol);
            }
        }
        // tarverse 1st and last column
        for(int i = 0;i<n;i++){
            if(!vis[i][0] && board[i][0] == 'O'){
                dfs(i,0,vis,board,delRow,delCol);
            }
            if(!vis[i][m-1] && board[i][m-1] == 'O'){
                dfs(i,m-1,vis,board,delRow,delCol);
            }
        }
        for(int  i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        return board;
    }

    // BFS approach
    // Time complexity: O(n*m)
    // Space complexity: O(n*m) 

    public static void solveI(char board[][]){
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int  i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(board[i][j] == 'O'){
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
                && !vis[nrow][ncol]  && board[nrow][ncol] == 'O'){
                    q.add(new Pair(nrow,ncol));
                    vis[nrow][ncol] = true;
                }
            }
        }
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        solve(board);
        for (char[] row : board) {
            System.out.println(row);
        }
    }
}
