/*
Number Of Islands II

You are given a n,m which means the row and column of the 2D matrix and an array of  size k denoting the number of operations. Matrix elements is 0 if there is water or 1 if there is land. Originally, the 2D matrix is all 0 which means there is no land in the matrix. The array has k operator(s) and each operator has two integer A[i][0], A[i][1] means that you can change the cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many island are there in the matrix after each operation.You need to return an array of size k.

Example 1:

Input: n = 4
m = 5
k = 4
A = {{1,1},{0,1},{3,3},{3,4}}

Output: 1 1 2 2

Input: n = 4
m = 5
k = 4
A = {{0,0},{1,1},{2,2},{3,3}}

Output: 1 2 3 4
*/

// Time complexity O(log(n*m))
// Space complexity O(n*m)
import java.util.ArrayList;
import java.util.List;
class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();

    DisjointSet(int n){
        for(int i = 0;i<n;i++){
            parent.add(i);
            rank.add(0);
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

    public void unionByRank(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        }
        else{
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_v,rank.get(ulp_u)+1);
        }
    }
}

public class NumberOfIslandsII {
    public static boolean isValid(int adjRow,int adjCol,int n,int m){
        return adjRow >=0 && adjRow < n && adjCol >= 0 && adjCol < m;
    }
    public static List<Integer> numOfIslands(int n, int m, int[][] operators) {
        DisjointSet ds = new DisjointSet(n*m);
        int vis[][] = new int[n][m];
        int count = 0;

        List<Integer> ans = new ArrayList<>();

        for(int it[] : operators){
            int row = it[0];
            int col = it[1];

            if(vis[row][col] == 1){
                ans.add(count);
                continue;
            }
            vis[row][col] = 1;
            count++;

            int dRow[] = {-1,0,+1,0};
            int dCol[] = {0,+1,0,-1};

            for(int i = 0;i<4;i++){
                int adjRow = row+dRow[i];
                int adjCol = col+dCol[i];
                if(isValid(adjRow,adjCol,n,m)){
                    if(vis[adjRow][adjCol] == 1){
                        int nodeNo = row*m+col;
                        int adjNodeNo = adjRow*m+adjCol;
                        if(ds.findParent(nodeNo) != ds.findParent(adjNodeNo)){
                            count--;
                            ds.unionByRank(nodeNo,adjNodeNo);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int operators[][] = {{1,1},{0,1},{3,3},{3,4}};
        System.out.println(numOfIslands(n,m,operators));
    }
}
