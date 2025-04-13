
// Kahn's Algorithm for Topological Sorting in a Directed Acyclic Graph (DAG)
// This algorithm uses the concept of in-degree to find the topological order of nodes in a graph.

// Time complexity: O(V + E) 
// Space complexity: O(V)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgorithm {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[] : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        int indegree[] = new int[V];
        for(int i = 0;i<V;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            
            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int V = 6;
        int[][] edges = { {5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1} };
        ArrayList<Integer> result = topoSort(V, edges);
        System.out.println("Topological Sort: " + result);
    }
}
