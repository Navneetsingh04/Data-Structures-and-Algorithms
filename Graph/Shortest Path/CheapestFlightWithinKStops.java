/*
L.C: 787. Cheapest Flights Within K Stops

There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Example 1:
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

Example 2:

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.

Example 3:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 
Constraints:
1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair{
    int first,second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Tuple{
    int first,second,third;
    Tuple(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
// Time complexity O(n*m) 
// Space complexity O(n*m)
public class CheapestFlightWithinKStops {
    // method 1: using class Pair and Tuple
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i= 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        int dist[] = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int stops = t.first;
            int node = t.second;
            int cost = t.third;

            if(stops > k) continue;
            for(Pair p : adj.get(node)){
                int adjNode = p.first;
                int eWt = p.second;

                if(cost+eWt < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost+eWt;
                    q.add(new Tuple(stops+1,adjNode,cost+eWt));
                }
            }
        }
        if(dist[dst] == 1e9) return -1;
        return dist[dst];
    }

    // method 2: Using arraylist and queue
    public static int findCheapestPriceI(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int it[] : flights){
            adj.get(it[0]).add(new int[]{it[1],it[2]});  // [neighbor,cost]
        }
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0,src,0});  //{stops,node,cost}
        int dist[] = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int stops = curr[0];
            int node = curr[1];
            int cost = curr[2];

            if(stops > k) continue;

            for(int i[] : adj.get(node)){
                int adjNode = i[0];
                int edgeWt = i[1];

                if(cost+edgeWt < dist[adjNode]){
                    dist[adjNode] = edgeWt+cost;
                    q.add(new int[]{stops+1,adjNode,cost+edgeWt});
                }
            }
        }
        return dist[dst] == 1e9 ? -1 : dist[dst];
    }
    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(findCheapestPrice(n,flights,src,dst,k));
        System.out.println(findCheapestPriceI(n,flights,src,dst,k));

    }

}
