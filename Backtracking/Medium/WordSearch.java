/*
L.C: 79. Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 
Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
*/
public class WordSearch{
    int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    int n,m;
    public boolean find(char[][] board,int i,int j,int index,String word){
        if(index == word.length()) return true;
        if(i<0 || j<0 ||i>=n || j>=m || board[i][j] == '#') return false;
        if(board[i][j] != word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = '#';

        for(int d[] : dir){
            int newI = i+d[0];
            int newJ = j+d[1];

            if(find(board, newI, newJ, index+1, word)){
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
    public boolean  exist(char[][] board,String word){
        n = board.length;
        m = board[0].length;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == word.charAt(0) && find(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        WordSearch obj = new WordSearch();
        System.out.println(obj.exist(board, word));
    }
}