/* 
L.C: 52. N-Queens II

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:
Input: n = 1
Output: 1
 
Constraints:
1 <= n <= 9
*/ 
public class NqueensII {
    static int queens[];
    private static boolean isValidMove(int row,int col){
        for(int i = 0;i<row;i++){
            int pRow = i;
            int pCol = queens[i];
            if(pCol == col || Math.abs(col - pCol) == Math.abs(row - pRow)){
                return false;
            }
        }
        return true;
    }
    private static int solve(int level, int n){
        if(level == n){
            return 1;
        }
        int ans = 0;
        for(int col = 0;col<n;col++){
            if(isValidMove(level,col)){
                queens[level] = col;
                ans += solve(level+1,n);
                queens[level] = -1; 
            }
        }
        return ans;
    }
    public static int totalNQueens(int n) {
        queens = new int[n+1];
        return solve(0,n);
    }
    public static void main(String[] args) {
        int n = 8;
        System.out.println(totalNQueens(n));
    }
}
