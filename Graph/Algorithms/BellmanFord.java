// Time Complexity: O(V*E)
// Space Complexity: O(V+E)
import java.util.Arrays;
public class BellmanFord {
    public static int[] bellmanFord(int V, int[][] edges, int src) {
        int dist[] = new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[src] = 0;
        for(int i = 0;i<V-1;i++){
            for(int edge[]: edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dist[u] != 1e8 && dist[u]+wt < dist[v]){
                    dist[v] = dist[u]+wt;
                }
            }
        }
        // nth relaxtation to check the -ve cycle weight
        for(int it[] : edges){
            int u = it[0];
            int v = it[1];
            int wt = it[2];
            if(dist[u] != 1e8 && dist[u]+wt < dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 5;
        int edges[][] = {{0,1,-1},{0,2,4},{1,2,3},{1,3,2},{1,4,2},{3,2,5},{3,1,1},{4,3,-3}};
        int src = 0;
        int dist[] = bellmanFord(V,edges,src);
        System.out.println(Arrays.toString(dist));
    }
}
