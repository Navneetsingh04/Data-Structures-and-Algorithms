/*
L.C: 733. Flood Fill

You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:
Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation:
The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.

Constraints:
m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n 
*/

import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int first,second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
public class FloodFill {
    static int n,m;
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        n = image.length;
        m = image[0].length;
        boolean vis[][] = new boolean[n][m];
        int initialColor = image[sr][sc];
        if (initialColor != color) {
            bfs(image, vis, sr, sc, color, initialColor);
        }
        return image;
    }
    public static void bfs(int[][] image, boolean vis[][],int sr, int sc, int color,int  initialColor){
        Queue<Pair> q = new LinkedList<>();
        vis[sr][sc] = true;
        q.add(new Pair(sr,sc));
        image[sr][sc] = color;
        int dir[][] =  {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            Pair node =  q.poll();
            int first = node.first;
            int second = node.second;

            for(int d[] : dir){
                int nrow = first + d[0];
                int ncol = second + d[1];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                && image[nrow][ncol] ==  initialColor){
                    q.add(new Pair(nrow,ncol));
                    image[nrow][ncol] = color;
                    vis[nrow][ncol] = true;
                }
            }
        }
    }
    public static int[][] floodFilldfs(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];
        int ans[][] = image;
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};
        dfs(image,sr,sc,ans,color,delRow,delCol,initialColor);
        return ans;
    }
    public static void dfs(int[][] image, int sr, int sc,int ans[][], int color,int delRow[],int delCol[], int initialColor){
        ans[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i= 0;i<4;i++){
            int nrow = sr+delRow[i];
            int ncol = sc+delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
            && image[nrow][ncol] == initialColor && ans[nrow][ncol] != color ){
                dfs(image,nrow,ncol,ans,color,delRow,delCol,initialColor);
            }
        }
    }
    public static void main(String[] args) {
        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        // int[][] result = floodFill(image, sr, sc, color);
        int[][] result = floodFilldfs(image, sr, sc, color);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
