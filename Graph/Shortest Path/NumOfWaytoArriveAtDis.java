/*
L.C: 1976. Number of Ways to Arrive at Destination

You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.


Example 1:
Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 -> 6
- 0 -> 4 -> 6
- 0 -> 1 -> 2 -> 5 -> 6
- 0 -> 1 -> 3 -> 5 -> 6
Example 2:

Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 

Constraints:
1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two intersections.
You can reach any intersection from any other intersection
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair{
    int node;
    long time;
    Pair(int node,long time){
        this.time = time;
        this.node = node;
    }
}
public class NumOfWaytoArriveAtDis {
    static int MOD = (int)1e9+7;
    public static int countPaths(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i= 0;i<n;i++){
            adjList.add(new ArrayList<>());
        } 
        for(int road[]: roads){
            int u = road[0];
            int v = road[1];
            int time = road[2];
            adjList.get(u).add(new Pair(v,time));
            adjList.get(v).add(new Pair(u,time));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Long.compare(x.time, y.time));
        long ans[] = new long[n];
        int pathCount[] = new int[n];
        Arrays.fill(ans,Long.MAX_VALUE);

        ans[0] = 0;
        pathCount[0] = 1;
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair p  = pq.poll();
            long currTime = p.time;
            int currNode = p.node;

            if(currTime > ans[currNode]) continue;

            for(Pair i: adjList.get(currNode)){
                int adjNode = i.node;
                long roadTime = i.time;

                if(currTime + roadTime < ans[adjNode]){
                    ans[adjNode] = currTime+roadTime;
                    pathCount[adjNode] = pathCount[currNode];
                    pq.add(new Pair(adjNode,ans[adjNode]));
                }
                else if(currTime + roadTime == ans[adjNode]){
                    pathCount[adjNode] = (pathCount[adjNode] + pathCount[currNode])%MOD;
                }
            }
        }
        return pathCount[n-1];
    }
    public static void main(String[] args) {
        int n = 7;
        int roads[][] = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        int ans = countPaths(n,roads);
        System.out.println(ans);
    }
}
