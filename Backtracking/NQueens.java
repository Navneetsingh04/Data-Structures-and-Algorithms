/*
L.C: 51. N-Queens

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:
1 <= n <= 9 
*/

// Time Complexity: O(N!*N)
// Space Complexity: O(N)
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    // public  boolean isSafe(int row,int col,char[][] board,List<List<String>> ans,int n){
    //     int dupRow = row;
    //     int dupCol = col;

    //     while(row >= 0 && col >= 0){
    //         if(board[row][col] == 'Q'){
    //             return false;
    //         }
    //         row--;
    //         col--;
    //     }
    //     col = dupCol;
    //     row = dupRow;
    //     while(col >= 0){
    //         if(board[row][col] == 'Q'){
    //             return false;
    //         }
    //         col--;
    //     }
    //     row = dupRow;
    //     col = dupCol;

    //     while(row<n && col >=0){
    //         if(board[row][col] == 'Q'){
    //             return false;
    //         }
    //         row++;
    //         col--;
    //     }
    //     return true;
    // }
    // public void solve(int col,char[][] board,List<List<String>> ans,int n){
    //     if(col == n){
    //         ans.add(construct(board));
    //         return;
    //     }
    //     for(int row = 0;row<n;row++){
    //         if(isSafe(row,col,board,ans,n)){
    //             board[row][col] = 'Q';
    //             solve(col+1,board,ans,n);
    //             board[row][col] = '.';
    //         }
    //     }
    // }
    // public List<String> construct(char[][] board){
    //     List<String> res = new ArrayList<>();
    //     for(char[] board1 : board) {
    //         String s = new String(board1);
    //         res.add(s);
    //     }
    //     return res;
    // }
    // public List<List<String>> solveNQueens(int n) {
    //     List<List<String>> ans = new ArrayList<>();
    //     char board[][] = new char[n][n];
    //     for(int i = 0; i < n; i++) {
    //         for(int j = 0;j<n;j++){
    //             board[i][j] = '.';
    //         }
    //     }
    //     solve(0,board,ans,n);
    //     return ans;
    // }

    // Approach 2: Using hashing
    
    public boolean isSafe(int row,int col,char[][] board,List<List<String>> ans,int n){
        int dupRow = row;
        int dupCol = col;

        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }
        col = dupCol;
        row = dupRow;
        while(col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }
        row = dupRow;
        col = dupCol;

        while(row<n && col >=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
    public void solve(int col,char[][] board,List<List<String>> ans,int leftRow[],int lowerDiagonal[],int upperDiagonal[],int n){
        if(col == n){
            ans.add(construct(board));
            return;
        }
        for(int row = 0;row<n;row++){
            if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[n-1+col-row] == 0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[n-1+col-row] = 1;
                solve(col+1,board,ans,leftRow,lowerDiagonal,upperDiagonal,n);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[n-1+col-row] = 0;
            }
        }
    }
    public List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for (char[] board1 : board) {
            String s = new String(board1);
            res.add(s);
        }
        return res;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0;j<n;j++){
                board[i][j] = '.';
            }
        }
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2*n-1];
        int lowerDiagonal[] = new int[2*n-1];
        solve(0,board,ans,leftRow,lowerDiagonal,upperDiagonal,n);
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        NQueens obj = new NQueens();
        List<List<String>> ans = obj.solveNQueens(n);
        System.out.println(ans);
    }
}
