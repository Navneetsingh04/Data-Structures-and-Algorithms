/*
L.C: 785. Is Graph Bipartite?

There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

Example 1:
Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.

Example 2:
Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 
Constraints:
graph.length == n
1 <= n <= 100
0 <= graph[u].length < n
0 <= graph[u][i] <= n - 1
graph[u] does not contain u.
All the values of graph[u] are unique.
If graph[u] contains v, then graph[v] contains u. 
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    // BFS approach
    // Time Complexity: O(V+E)
    // Space Complexity: O(V)
    static int n;
    public static boolean bfs(int start,int[][] graph,int color[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i : graph[node]){
                if(color[i] == -1){
                    color[i] = 1-color[node];
                    q.add(i);
                }
                else if(color[i] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartite(int[][] graph) {
        n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0;i<n;i++){
            if(color[i] == -1){
                if(!bfs(i,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }
    // DFS approach
    // Time Complexity: O(V+E) 
    // Space Complexity: O(V)
    public static boolean dfs(int start,int col,int[][] graph,int color[]){
        color[start] = col;
        for(int i : graph[start]){
            if(color[i] == -1){
                if(!dfs(i,1-col,graph,color)){
                    return false;
                }
            }
            else if(color[i] == col){
                return false;
            }
        }
        return true;
    }
    public static boolean isBipartiteI(int[][] graph) {
        n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0;i<n;i++){
            if(color[i] == -1){
                if(!dfs(i,0,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(graph)); 
        System.out.println(isBipartiteI(graph));
    }
}
