/*
Topological sort

Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the topological sort for the given graph.

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.

Examples:

Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]
Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5,2]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
[4, 5, 0, 1, 2, 3]
[5, 2, 4, 0, 1, 3]
Constraints:
2  ≤  V  ≤  103
1  ≤  E = edges.size()  ≤  (V * (V - 1)) / 2 
*/

// Time Complexity: O(V + E)
// Space Complexity: O(V + E) 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoSort {
    public static void dfs(int node, boolean vis[], Stack<Integer> st,List<List<Integer>> adj){
        vis[node] = true;
        for(int i : adj.get(node)){
            if(!vis[i]){
                dfs(i,vis,st,adj);
            }
        }
        st.push(node);
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[] : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i= 0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,st,adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            int node = st.pop();
            ans.add(node);
        }
        return ans;
    }
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{3, 0}, {1, 0}, {2, 0}};
       System.out.println(topoSort(V, edges));
    }
}
