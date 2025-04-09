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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity: O(n^2)
// Space Complexity: O(n)

public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;    
        boolean vis[] = new boolean[n];
        int count = 0;
        for(int i= 0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected,vis,i,n);
                // bfs(isConnected,vis,i,n);
                count++;
            }
        }
        return count;
    }
    public static void dfs(int[][] isConnected,boolean vis[],int node,int n){
        vis[node] = true;
        for(int i = 0;i<n;i++){
            if(isConnected[node][i] == 1 && !vis[i]){
                dfs(isConnected,vis,i,n);
                vis[i] = true;
            }
        }
    }
    public static void bfs(int[][] isConnected,boolean vis[],int node,int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i = 0;i<n;i++){
                if(isConnected[curr][i] == 1 && !vis[i]){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
    }

    // Using Adjacency List
    // Time Complexity: O(n)+O(v+e)
    // Space Complexity: O(n)+
    public int findCircleNumI(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean vis[] = new boolean[n];
        int count = 0;
        for(int i= 0;i<n;i++){
            if(!vis[i]){
                dfs(adj,vis,i);
                count++;
            }
        }
        return count;
    }
    public static void dfs( List<List<Integer>> adj,boolean vis[],int node){
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                vis[it] = true;
                dfs(adj,vis,it);
            }
        }
    }
    
    public static void main(String[] args) {
        int [][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected)); 
    }
}
