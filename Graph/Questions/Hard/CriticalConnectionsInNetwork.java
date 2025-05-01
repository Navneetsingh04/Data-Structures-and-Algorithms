/*
L.C: 1192. Critical Connections in a Network

There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

Example 1:
Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.

Example 2:
Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
 
Constraints:
2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections.
*/

// Time Complexity: O(V + E)
// Space Complexity: O(V + E) 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInNetwork {
    static int timer = 1;
    static List<List<Integer>> bridges;
    public static void dfs(int node,int parent,boolean vis[], List<List<Integer>> adj,
    int timeIn[],int low[]){
        vis[node] = true;
        timeIn[node] = low[node] = timer;
        timer++;

        for(int it : adj.get(node)){
            if(it == parent) continue;
            if(!vis[it]){
                dfs(it,node,vis,adj,timeIn,low);
                low[node] = Math.min(low[node],low[it]);
                if(low[it] > timeIn[node]){
                    bridges.add(Arrays.asList(it,node));
                }
            }
            else{
                low[node] = Math.min(low[node],low[it]);
            }
        }
    }
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> it : connections){
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        int timeIn[] = new int[n];
        int low[] = new int[n];

        bridges = new ArrayList<>();
        dfs(0,-1,vis,adj,timeIn,low);
        return bridges;
    }
    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        System.out.println("Critical Connections: " + criticalConnections(n, connections));
    }
}
