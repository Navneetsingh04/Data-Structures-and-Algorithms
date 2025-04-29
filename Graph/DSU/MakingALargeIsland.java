/*
L.C: 827. Making A Large Island

You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

Example 1:
Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.

Example 2:
Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.

Example 3:
Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.

Constraints:
n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] is either 0 or 1. 
*/

// Time Complexity: O(N^2)
// Space Complexity: O(N^2)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisjointSet(int n){
        for(int i= 0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }

    public void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}

public class MakingALargeIsland {
    public static boolean isValid(int newRow,int newCol,int n){
        return newRow >= 0 && newRow < n && newCol >= 0 && newCol <n;
    }
    public static int largestIsland(int[][] grid) {
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n*n);
        for(int row = 0;row<n;row++){
            for(int col = 0;col<n;col++){
                if(grid[row][col] == 0) continue;
                int delRow[] = {-1,0,+1,0};
                int delCol[] = {0,-1,0,+1};

                for(int i = 0;i<4;i++){
                    int newRow = row+delRow[i];
                    int newCol = col+delCol[i];

                    if(isValid(newRow,newCol,n)){
                        if(grid[newRow][newCol] == 1){
                            int nodeNo = row*n+col;
                            int adjNodeNo = newRow*n+newCol;
                            ds.unionBySize(nodeNo,adjNodeNo);
                        }
                    }
                }
            }
        }
        
        int mx = 0;
        for(int row = 0;row<n;row++){
            for(int col = 0;col<n;col++){
                if(grid[row][col] == 1) continue;
        
                int delRow[] = {-1,0,+1,0};
                int delCol[] = {0,-1,0,+1};

                Set<Integer> components = new HashSet<>();

                for(int i = 0;i<4;i++){
                    int newRow = row+delRow[i];
                    int newCol = col+delCol[i];

                    if(isValid(newRow,newCol,n)){
                        if(grid[newRow][newCol] == 1){
                            components.add(ds.findParent(newRow*n+newCol));
                        }
                    }
                }
                int sizeTotal = 0;
                for(int i : components){
                    sizeTotal += ds.size.get(i);
                }
                mx = Math.max(mx,sizeTotal+1);
            }
        }
        for(int celNo = 0;celNo < n*n;celNo++){
            mx = Math.max(mx,ds.size.get(ds.findParent(celNo)));
        }
        return mx;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {1,0},
            {0,1}
        };
        System.out.println(largestIsland(grid));
    }
}
