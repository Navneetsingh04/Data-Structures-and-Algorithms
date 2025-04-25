
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair{
    int distance,node;
    Pair(int distance,int node){
        this.distance=distance;
        this.node=node;
    }
}
public class PrimsAlgorithmI {
    public static int prims(int V,int E,List<List<int[]>> adj){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        boolean[] visited = new boolean[V];
        int parent[] = new int[V];
        Arrays.fill(parent,-1);

        List<int[]> mstEdges = new ArrayList<>();
        pq.add(new Pair(0,0));
        int sum = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int wt = p.distance;

            if(visited[node]) continue;
            visited[node] = true;
            sum += wt;

            if(parent[node] != -1){
                mstEdges.add(new int[]{parent[node],node});
            }

            for(int edge[] : adj.get(node)){
                int adjNode = edge[0];
                int eWt = edge[1];
                if(!visited[adjNode]){
                    pq.add(new Pair(eWt,adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        for (int[] edge : mstEdges) {
            System.out.println(edge[0] + " - " + edge[1]);
        }
        return sum;
    }
    public static void main(String[] args) {
        int V = 5, E = 6;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new int[]{1, 2});
        adj.get(1).add(new int[]{0, 2});
        
        adj.get(0).add(new int[]{3, 6});
        adj.get(3).add(new int[]{0, 6});
        
        adj.get(1).add(new int[]{2, 3});
        adj.get(2).add(new int[]{1, 3});
        
        adj.get(1).add(new int[]{3, 8});
        adj.get(3).add(new int[]{1, 8});
        
        adj.get(1).add(new int[]{4, 5});
        adj.get(4).add(new int[]{1, 5});
        
        adj.get(2).add(new int[]{4, 7});
        adj.get(4).add(new int[]{2, 7});

        System.out.println("Minimum Spanning Tree Weight: " + prims(V, E, adj));
    }
}
