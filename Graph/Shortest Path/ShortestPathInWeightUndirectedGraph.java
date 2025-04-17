/*
Shortest Path in Weighted undirected graph

You are given a weighted undirected graph having n vertices numbered from 1 to n and m edges along with their weights. Find the shortest weight path between the vertex 1 and the vertex n,  if there exists a path, and return a list of integers whose first element is the weight of the path, and the rest consist of the nodes on that path. If no path exists, then return a list containing a single element -1.

The input list of edges is as follows - {a, b, w}, denoting there is an edge between a and b, and w is the weight of that edge.

Note: The driver code here will first check if the weight of the path returned is equal to the sum of the weights along the nodes on that path, if equal it will output the weight of the path, else -2. In case the list contains only a single element (-1) it will simply output -1. 

Examples :

Input: n = 5, m= 6, edges = [[1, 2, 2], [2, 5, 5], [2, 3, 4], [1, 4, 1], [4, 3, 3], [3, 5, 1]]
Output: 5
Explanation: Shortest path from 1 to n is by the path 1 4 3 5 whose weight is 5. 

Input: n = 2, m= 1, edges = [[1, 2, 2]]
Output: 2
Explanation: Shortest path from 1 to 2 is by the path 1 2 whose weight is 2. 

Input: n = 2, m= 0, edges = [ ]
Output: -1
Explanation: Since there are no edges, so no answer is possible.
Expected Time Complexity: O(m* log(n))
Expected Space Complexity: O(n+m)

Constraint:
2 <= n <= 106
0 <= m <= 106
1 <= a, b <= n 
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// Time Complexity: O(m*log(n))*O(n) for the priority queue
// Space Complexity: O(n+m)
class Pair{
    int distance,node;
    Pair(int distance,int node){
        this.distance = distance;
        this.node = node;
    }
}
public class ShortestPathInWeightUndirectedGraph {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(wt,v));
            adj.get(v).add(new Pair(wt,u));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int dist[] = new int[n+1];
        int parent[] = new int[n+1];
        Arrays.fill(dist,(int)1e9);
        dist[1] = 0;
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        pq.add(new Pair(0,1));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int dis = p.distance;
            int node = p.node;
            
            for(Pair it : adj.get(node)){
                int adjNode = it.node;
                int adjWt = it.distance;
                if(dis+adjWt < dist[adjNode]){
                    dist[adjNode] = dis+adjWt;
                    pq.add(new Pair(dis+adjWt,adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        
        if(dist[n] == (int) 1e9){
            List<Integer> ans = new ArrayList<>();
            ans.add(-1);
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        int node = n;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        
        path.add(0,dist[n]);
        return path;
    }
    public static void main(String[] args) {
        int n = 5, m= 6;
        int edges[][] = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        System.out.println(shortestPath(n, m, edges));
    }
}
