/*
L.C: 36. Valid Sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
*/

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    // Time Complexity: O(1)

    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0;i<9;i++){
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            for(int j = 0;j<9;j++){
                if(board[i][j] != '.'){
                    if(rowSet.contains(board[i][j])) return false;
                    rowSet.add(board[i][j]);
                }
                if(board[j][i] != '.'){
                    if(colSet.contains(board[j][i])) return false;
                    colSet.add(board[j][i]);
                }
            }
        }

        // validate 3x3 matrix

        for(int i = 0;i<9;i += 3){
            for(int j = 0;j<9;j += 3){
                Set<Character> set = new HashSet<>();
                for(int row = i;row<i+3; row++){
                    for(int col = j ;col < j+3;col++){
                        if(board[row][col] != '.'){
                            if(set.contains(board[row][col])) return false;
                            set.add(board[row][col]);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValidSudokuI(char[][] board) {
       boolean[][] rows = new boolean[9][9];
       boolean[][] cols = new boolean[9][9];
       boolean[][] box = new boolean[9][9];

       for(int i = 0;i<9;i++){
        for(int j = 0;j<9;j++){
            char c = board[i][j];
            if(c == '.') continue;

            int num = c-'1';
            int boxIndex = (i/3)*3+(j/3);

            if(rows[i][num] || cols[j][num] || box[boxIndex][num]) return false;

            rows[i][num] = true;
            cols[j][num] = true;
            box[boxIndex][num] = true;
            }
        }
       return true;
    }
    public static void main(String[] args) {
    char[][]  board = 
        {{'5','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }
}
