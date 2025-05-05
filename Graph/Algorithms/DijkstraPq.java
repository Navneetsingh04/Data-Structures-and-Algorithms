// Time Complexity: O(ElogV)
// Space Complexity: O(V+E)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair{
    int distance,node;
    Pair(int distance,int node){
        this.distance = distance;
        this.node = node;
    }
}
public class DijkstraPq {
    public static int[] dijkstra(int V, int[][] edges, int src) {
        
        List<List<Pair>> adj = new ArrayList<>();
        for(int i= 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(wt,v));
            adj.get(v).add(new Pair(wt,u));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance-y.distance);
        int dist[] =  new int[V];
        
        Arrays.fill(dist,(int) 1e9);
        dist[src] = 0;
        pq.add(new Pair(0,src));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int dis = p.distance;
            int node = p.node;
            
            for(Pair i : adj.get(node)){
                int edgeWeight = i.distance;
                int adjNode = i.node;
                
                if(dis+edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 5;
        int edges[][] = {{0,1,2},{0,2,4},{1,2,1},{1,3,7},{2,3,3},{3,4,1}};
        int src = 0;
        int dist[] = dijkstra(V,edges,src);
        System.out.println(Arrays.toString(dist));
    }
}