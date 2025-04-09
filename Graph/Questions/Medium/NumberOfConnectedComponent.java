/*
Number of Connected Components in an Undirected Graph

There is an undirected graph with n nodes. There is also an edges array, where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.
The nodes are numbered from 0 to n - 1.
Return the total number of connected components in that graph.

Example 1:
Input: n=3 edges=[[0,1], [0,2]]
Output: 1

Example 2:
Input: n=6 edges=[[0,1], [1,2], [2,3], [4,5]]
Output: 2

Constraints:
1 <= n <= 100
0 <= edges.length <= n * (n - 1) / 2
 
*/
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

// Time Complexity: O(n + e) where n is the number of nodes and e is the number of edges.
// Space Complexity: O(n + e) for the adjacency list and O(n) for the visited array.

public class NumberOfConnectedComponent {
    public static int countComponents(int n,int edges[][]){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean vis[] = new boolean[n];
        int count = 0;

        for(int i = 0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,adj,vis);
            }
        }
        return count;
    }
    public static void dfs(int node,List<List<Integer>> adj,boolean vis[]){
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                vis[it] = true;
                // dfs(it,adj,vis);
                bfs(it,adj,vis);
            }
        }
    }
    public static void bfs(int node,List<List<Integer>> adj,boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        vis[node] = true;
        q.add(node);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int it : adj.get(curr)){
                if(!vis[it]){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
    }
    public static void main(String[] args) {
        int n = 10;
        int[][] edges = {{0, 1}, {0, 2},{1,3}, {2, 3}, {4, 5},{4,6}, {5, 6}, {7, 8}};
        System.out.println(countComponents(n, edges)); 
    }
}
