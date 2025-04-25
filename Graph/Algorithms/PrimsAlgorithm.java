/*
Given a weighted, undirected, and connected graph with V vertices and E edges, your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph. The graph is represented by an adjacency list, where each element adj[i] is a vector containing vector of integers. Each vector represents an edge, with the first integer denoting the endpoint of the edge and the second integer denoting the weight of the edge.

Input:
3 3
0 1 5
1 2 3
0 2 1
 
Output: 4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.
Input: 
2 1
0 1 5

Output: 5 

Explanation: Only one Spanning Tree is possible which has a weight of 5.
Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
The graph is connected and doesn't contain self-loops & multiple edges. 
*/

// Time Complexity: O(ElogE) 
// Space Complexity: O(V) 

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
class Pair{
    int node,distance;
    public Pair(int distance,int node){
        this.node = node;
        this.distance = distance;
    }
}
public class PrimsAlgorithm {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x,y) -> x.distance - y.distance);
        
        boolean vis[] = new boolean[V];
        pq.add(new Pair(0,0));
        int sum = 0;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int wt = p.distance;
            int node = p.node;
            
            if(vis[node]) continue;
            vis[node] = true;
            sum += wt;
            
            for(int edge[] : adj.get(node)){
                int adjNode = edge[0];
                int adjWt = edge[1];
                if(!vis[adjNode]){
                    pq.add(new Pair(adjWt,adjNode));
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int V = 3, E = 3;
        List<List<int[]>> adj = Arrays.asList(
            Arrays.asList(new int[]{1, 5}, new int[]{2, 1}),
            Arrays.asList(new int[]{0, 5}, new int[]{2, 3}),
            Arrays.asList(new int[]{0, 1}, new int[]{1, 3})
        );
        int result = spanningTree(V, E, adj);
        System.out.println(result); 
    }
}
