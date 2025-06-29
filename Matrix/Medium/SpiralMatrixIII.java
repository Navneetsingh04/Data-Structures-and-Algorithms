/*
L.C: 885. Spiral Matrix III

You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.

You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.

Return an array of coordinates representing the positions of the grid in the order you visited them.

Example 1:
Input: rows = 1, cols = 4, rStart = 0, cStart = 0
Output: [[0,0],[0,1],[0,2],[0,3]]

Example 2:
Input: rows = 5, cols = 6, rStart = 1, cStart = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 

Constraints:
1 <= rows, cols <= 100
0 <= rStart < rows
0 <= cStart < cols 
*/

// Time Complexity: O(Max(n,m)^2);
// Space Complexity: O(n*m)

import java.util.Arrays;

public class SpiralMatrixIII {
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int size = rows*cols;
        int matrix[][] = new int[size][2];
        int directions[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int steps = 0;
        int dirIndex = 0;
        matrix[0] = new int[]{rStart,cStart};
        int count = 1;
        while(count < size){
            if(dirIndex == 0 || dirIndex == 2){
                steps++;
            }
            for(int i = 0;i<steps;i++){
               rStart += directions[dirIndex][0];
               cStart += directions[dirIndex][1];
                if(rStart >= 0 && rStart < rows && cStart >=0 && cStart < cols){
                    matrix[count++] = new int[]{rStart,cStart};
                }
            }
            dirIndex = (dirIndex+1)%4;
        }
        return matrix;
    }
    public static void main(String[] args) {
        int rows = 5, cols = 6, rStart = 1, cStart = 4;
        int ans[][] = spiralMatrixIII(rows, cols, rStart, cStart);
        for(int i[] : ans){
            System.out.print(Arrays.toString(i));
        }
    }
}
