/*
Shortest Distance in a Binary Maze

Given a n * m matrix grid where each element can either be 0 or 1. You need to find the shortest distance between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1. 

If the path is not possible between source cell and destination cell, then return -1.

Note : You can move into an adjacent cell if that adjacent cell is filled with element 1. Two cells are adjacent if they share a side. In other words, you can move in one of the four directions, Up, Down, Left and Right. The source and destination cell are based on the zero based indexing. The destination cell should be 1.

Example 1:

Input:
grid[][] = {{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}}
source = {0, 1}
destination = {2, 2}
Output:
3
Explanation:
1 1 1 1
1 1 0 1
1 1 1 1
1 1 0 0
1 0 0 1
The highlighted part in the matrix denotes the 
shortest path from source to destination cell.
Example 2:

Input:
grid[][] = {{1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 1, 0, 1}}
source = {0, 0}
destination = {3, 4}
Output:
-1
Explanation:
The path is not possible between source and 
destination, hence return -1.
Your Task:

You don't need to read or print anything. Your task is to complete the function shortestPath() which takes the a 2D integer array grid, source cell and destination cell as an input parameters and returns the shortest distance between source and destination cell.

Expected Time Complexity: O(n * m)
Expected Space Complexity: O(n * m)

Constraints:

1 ≤ n, m ≤ 500
grid[i][j] == 0 or grid[i][j] == 1
The source and destination cells are always inside the given matrix. 
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
public class ShortestDistInBinaryMaze {
    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1]){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        Queue<Tuple> queue = new LinkedList<>();
        int dest[][] = new int[n][m];
        for(int i[] : dest){
            Arrays.fill(i,(int)1e9);
        }
        dest[source[0]][source[1]] = 0;
        queue.add(new Tuple(0,source[0],source[1]));
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};
        
        while(!queue.isEmpty()){
            Tuple t = queue.poll();
            int dis = t.first;
            int row = t.second;
            int col = t.third;
            
            for(int i = 0;i<4;i++){
                int newRow = delRow[i] + row;
                int newCol = delCol[i] + col;
                
                if(newRow >= 0 && newRow <n && newCol >= 0 && newCol <m
                && grid[newRow][newCol] == 1 && dis+1 < dest[newRow][newCol]){
                    dest[newRow][newCol] = 1+dis;
                    if(newRow == destination[0] && newCol == destination[1]){
                        return dis+1;
                    }
                    queue.add(new Tuple(1+dis,newRow,newCol));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [][] grid = {
            {1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}
        };
        int[] source = {0, 1};
        int[] destination = {2, 2};
        int result = shortestPath(grid, source, destination);
        System.out.println(result); 
    }
}
