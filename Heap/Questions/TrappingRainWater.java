/*
L.C: 407. Trapping Rain Water II

Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.


Example 1:
Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.

Example 2:
Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10
 
Constraints:
m == heightMap.length
n == heightMap[i].length
1 <= m, n <= 200
0 <= heightMap[i][j] <= 2 *  
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWater {
     public static int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int n = heightMap.length;
        int m = heightMap[0].length;
        PriorityQueue<int[]> boundry = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        boolean[][] visited = new boolean[n][m];
        for (int row = 0; row < n; row++) {
            boundry.offer(new int[]{heightMap[row][0], row, 0});
            visited[row][0] = true;
            boundry.offer(new int[]{heightMap[row][m - 1], row, m - 1});
            visited[row][m - 1] = true;
        }
        for (int col = 0; col < m; col++) {
            boundry.offer(new int[]{heightMap[0][col], 0, col});
            visited[0][col] = true;
            boundry.offer(new int[]{heightMap[n - 1][col], n - 1, col});
            visited[n - 1][col] = true;
        }

        int water = 0;
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        while (!boundry.isEmpty()) {
            int[] cell = boundry.poll();
            int height = cell[0];
            int i = cell[1];
            int j = cell[2];

            for (int[] dr : dir) {
                int k = i + dr[0];
                int l = j + dr[1];

                if (k >= 0 && k < n && l >= 0 && l < m && !visited[k][l]) {
                    water += Math.max(height - heightMap[k][l], 0);
                    boundry.offer(new int[]{Math.max(height, heightMap[k][l]), k, l});
                    visited[k][l] = true;
                }
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int heightMap[][] = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        System.out.println(trapRainWater(heightMap));
    }
}
