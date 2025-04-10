/*
L.C: 542. 01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two cells sharing a common edge is 1.

Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 
Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
*/
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)
// Approach: BFS
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first,second,near;
    Pair(int first,int second,int near){
        this.first = first;
        this.second = second;
        this.near = near;
    }
}
public class Matrix01 {
    static int n,m;
    public static int[][] updateMatrix(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        boolean vis[][] =  new boolean[n][m];
        int dis[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i= 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = true;
                }
                else{
                    vis[i][j] = false;
                }
            }
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;
            int step = p.near;
            dis[row][col] = step;
            int delRow[] = {-1,0,+1,0};
            int delCol[] = {0,+1,0,-1};
            for(int i= 0;i<4;i++){
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];
                if(nrow >= 0 && nrow <n && ncol >= 0 && ncol <m
                && !vis[nrow][ncol]){
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow,ncol,step+1));
                }
            }
        }
        return dis;
    }
    public static void main(String[] args) {
        int mat[][] = {{1,0,1},{1,1,0},{1,0,0}};
        int ans[][] = updateMatrix(mat);
        for(int i= 0;i<ans.length;i++){
            for(int j = 0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
