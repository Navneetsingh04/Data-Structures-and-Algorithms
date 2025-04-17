/*
L.C: 1091. Shortest Path in Binary Matrix

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

Example 1:
Input: grid = [[0,1],[1,0]]
Output: 2

Example 2:
Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 
Constraints:
n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Time complexity O(n*m)
// Space complexity O(n*m)

class Tuple{
    int first,second,third;
    Tuple(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
public class ShortestPathInBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1;
        Queue<Tuple> queue = new LinkedList<>();
        int dest[][] = new int[n][m];
        for(int i[] : dest){
            Arrays.fill(i,(int)1e9);
        }
        int src[] = {0,0};
        int des[] = {n-1,m-1};
        dest[src[0]][src[1]] = 1;
        queue.add(new Tuple(1,src[0],src[1]));
        int[] delRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] delCol = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int dis = t.first;
            int row = t.second;
            int col = t.third;
            if(row == des[0] && col == des[1]){
                return dis;
            }
            for(int i = 0;i<8;i++){
                int newRow = delRow[i] + row;
                int newCol = delCol[i] + col;
                
                if(newRow >= 0 && newRow <n && newCol >= 0 && newCol <m
                && grid[newRow][newCol] == 0 && dis+1 < dest[newRow][newCol]){
                    dest[newRow][newCol] = 1+dis;
                    queue.add(new Tuple(1+dis,newRow,newCol));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {0, 0, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid)); 
    }
}
