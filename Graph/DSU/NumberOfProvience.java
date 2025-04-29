/*
L.C: 547. Number of Provinces

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 
Constraints:
1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i] 
*/

// Time Complexity: O(N^2) 
// Space Complexity: O(N) 

public class NumberOfProvience {
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;    
        int parent[] = new int[n];
        int size[] = new int[n];

        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        } 

        for(int i= 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(isConnected[i][j] == 1){
                    union(i,j,parent,size);
                }
            }
        }

        int count = 0;
        for(int i= 0;i<n;i++){
            if(parent[i] == i){
                count++;
            }
        }
        return count;   
    }

    public static int find(int x,int parent[]){
        if(parent[x] != x){
            parent[x] = find(parent[x],parent);
        } 
        return parent[x];
    }

    public static void union(int u,int v,int parent[],int size[]){
        int pu = find(u,parent);
        int pv = find(v,parent);

        if(pu == pv) return;

        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
    public static void main(String[] args) {
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected)); 
    }
}
