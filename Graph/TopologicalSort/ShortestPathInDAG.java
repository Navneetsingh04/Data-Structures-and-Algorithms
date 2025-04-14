/*
Shortest path in Directed Acyclic Graph

Given a Directed Acyclic Graph of V vertices from 0 to n-1 and a 2D Integer array(or vector) edges[ ][ ] of length E, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

Examples :
Input: V = 4, E = 2, edges = [[0,1,2], [0,2,1]]
Output: [0, 2, 1, -1]
Explanation: Shortest path from 0 to 1 is 0->1 with edge weight 2. Shortest path from 0 to 2 is 0->2 with edge weight 1. There is no way we can reach 3, so it's -1 for 3.

Input: V = 6, E = 7, edges = [[0,1,2], [0,4,1], [4,5,4], [4,2,2], [1,2,3], [2,3,6], [5,3,1]]
Output: [0, 2, 3, 6, 1, 5]

Explanation: Shortest path from 0 to 1 is 0->1 with edge weight 2. Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3. Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6. Shortest path from 0 to 4 is 0->4 with edge weight 1.Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.

Constraint:
1 <= V <= 100
1 <= E <= min((N*(N-1))/2,4000)
0 <= edgesi,0, edgesi,1 < n
0 <= edgei,2 <=10^5 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Pair{
    int first,second;
    Pair(int first,int second){
        this.first =first;
        this.second = second;
    }
}
public class ShortestPathInDAG {
    public static void topoSort(int node, List<List<Pair>> adj,boolean vis[],
    Stack<Integer> stack){
        vis[node] = true;
        for(int i = 0;i<adj.get(node).size();i++){
            int v = adj.get(node).get(i).first;
            if(!vis[v]){
                topoSort(v,adj,vis,stack);
            }
        }
        stack.add(node);
    }

    public static int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i= 0;i<V;i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i = 0;i<E;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<V;i++){
            if(!vis[i]){
                topoSort(i,adj,vis,stack);
            }
        }
        
        int dist[] =  new int[V];
        Arrays.fill(dist,(int)1e9);
        
        dist[0] = 0;
        while(!stack.isEmpty()){
            int node = stack.pop();
            for(int i = 0;i<adj.get(node).size();i++){
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                
                if(dist[node]+wt < dist[v]){
                    dist[v] = wt+dist[node];
                }
            }
        }
        for(int i = 0; i < V; i++){
            if(dist[i] == (int)1e9){
                dist[i] = -1;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][] edges = {
            {0, 1, 1},
            {1, 2, 2},
            {2, 3, 3},
            {3, 4, 2}
        };
        int V = 5;
        int E = edges.length;
        System.out.println("Shortest Path in DAG: ");
        System.out.println(Arrays.toString(shortestPath(V, E, edges)));

    }
}
