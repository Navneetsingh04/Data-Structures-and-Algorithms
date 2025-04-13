/*
Directed Graph Cycle

Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.

Examples:
Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 0], [2, 3]]
Output: true

Explanation: The diagram clearly shows a cycle 0 → 2 → 0
Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]

Output: false
Explanation: no cycle in the graph

Constraints:
1 ≤ V, E ≤ 105
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Using BFS (Kahn's Algorithm)
// time complexity: O(V + E)
// space complexity: O(V + E)
public class DetectCycleInDirectedGraph {
    public static boolean isCyclic(int V, int[][] edges) {
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
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            
            for(int i : adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
            if(count == V) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}};
        System.out.println(isCyclic(V, edges));
    }
}
