public class Dijkstra {
    public static void dijkstra(int graph[][],int source){
        int n = graph.length;
        boolean vis[] = new boolean[n];
        int distance[] = new int[n];
        for(int i = 0;i<n;i++){
            vis[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        // dustance of self loop is zero
        distance[source] = 0;
        for(int i = 0;i<n;i++){
            int u = findMinDistance(distance,vis);
            vis[u] = true;
            for(int v = 0;v<n;v++){
                if(!vis[v] && graph[u][v] != 0 && (distance[u]+graph[u][v] < distance[v])){
                    distance[v] = distance[u]+graph[u][v];
                }
            }
        }
        for(int i = 0;i<n;i++){
            // System.out.println("Distance from source to "+i+" is "+distance[i]);
            System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
        }
    }
    public static int findMinDistance(int distance[],boolean vis[]){
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int i = 0;i<distance.length;i++){
            if(!vis[i] && distance[i] < min){
                min = distance[i];
                min_index = i;
            }
        }
        return min_index;
    }
    public static void main(String[] args) {
        int graph[][] = new int[][]{
            {0, 0, 1, 2, 0, 0, 0},
            {0, 0, 2, 0, 0, 3, 0},
            {1, 2, 0, 1, 3, 0, 0},
            {2, 0, 1, 0, 0, 0, 1},
            {0, 0, 3, 0, 0, 2, 0},
            {0, 3, 0, 0, 2, 0, 1},
            {0, 0, 0, 1, 0, 1, 0}
        };
        int source = 0;
        System.out.println("Dijkstra's Algorithm: ");
        dijkstra(graph, source);
    }
}
