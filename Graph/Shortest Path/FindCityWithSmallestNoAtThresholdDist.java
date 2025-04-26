/*
L.C: 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance

There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

Example 1:
Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
Output: 3
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -> [City 1, City 2] 
City 1 -> [City 0, City 2, City 3] 
City 2 -> [City 0, City 1, City 3] 
City 3 -> [City 1, City 2] 
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.

Example 2:
Input: n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
Output: 0
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 2 for each city are:
City 0 -> [City 1] 
City 1 -> [City 0, City 4] 
City 2 -> [City 3, City 4] 
City 3 -> [City 2, City 4]
City 4 -> [City 1, City 2, City 3] 
The city 0 has 1 neighboring city at a distanceThreshold = 2.
 
Constraints:
2 <= n <= 100
1 <= edges.length <= n * (n - 1) / 2
edges[i].length == 3
0 <= fromi < toi < n
1 <= weighti, distanceThreshold <= 10^4
All pairs (fromi, toi) are distinct. 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
public class FindCityWithSmallestNoAtThresholdDist {

    // Approach 1: Using Floyd-Warshall Algorithm
    // Time Complexity: O(n^3)
    // Space Complexity: O(n^2)
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];
        for(int i[] : dist){
            Arrays.fill(i,(int)1e9);
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            dist[u][v] = cost;
            dist[v][u] = cost;
        }

        for(int i = 0;i<n;i++) dist[i][i] = 0;
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(dist[i][k] != 1e9 && dist[k][j] != 1e9){
                        dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }

        int countCity = n;
        int cityNo = -1;

        for(int city = 0;city<n;city++){
            int count = 0;
            for(int adjCity = 0;adjCity <n;adjCity++){
                if(dist[city][adjCity] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= countCity){
                countCity = count;
                cityNo = city;
            }
        }
        return cityNo;
    }

    // Approach 2: Using Dijkstra's Algorithm
    // Time Complexity: O(n^2 + e*log(n))
    // Space Complexity: O(n^2 + e)

    public static int[] dijkstra(int n,List<List<int[]>> graph,int src){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int dist[] = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        pq.add(new int[]{src,0});

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int node = curr[0];
            int cost = curr[1];

            for(int i[] : graph.get(node)){
                int adjNode = i[0];
                int wt = i[1];
                if(cost+wt < dist[adjNode]){
                    dist[adjNode] = cost+wt;
                    pq.add(new int[]{adjNode,dist[adjNode]});
                }
            }
        }
        return dist;
    }

    public static int findTheCityDijkstra(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            graph.get(u).add(new int[]{v,cost});
            graph.get(v).add(new int[]{u,cost});
        }
        int cityCount = n;
        int cityNo = -1;

        for(int i = 0;i<n;i++){
            int dist[] = dijkstra(n,graph,i);
            int count = 0;
            for(int j = 0;j<n;j++){
                if(j != i && dist[j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= cityCount){
                cityCount = count;
                cityNo = i;
            }
        }
        return cityNo;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1, 2}, {0, 2, 4}, {1, 2, 1}, {1, 3, 7}, {2, 3, 3}, {3, 4, 1}};
        int distanceThreshold = 4;
        System.out.println(findTheCity(n, edges, distanceThreshold)); 
        System.out.println(findTheCityDijkstra(n, edges, distanceThreshold));
    }
}
