/*
Articulation Point - I

Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) disconnects the graph into 2 or more components and return it in sorted manner.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.

Example 1:
Input:
Output:{1,4}
Explanation: Removing the vertex 1 will
discconect the graph as-
Removing the vertex 4 will disconnect the
graph as-
 
*/ 
// Time Complexity: O(V + E)
// Space Complexity: O(V + E)

import java.util.ArrayList;
import java.util.List;

public class ArticulationPointI {
    static int timer = 0;
    public static void dfs(int node,int parent,boolean vis[],int timeIn[],int low[],
                    int mark[],List<List<Integer>> adj){
        vis[node] = true;
        timeIn[node] =  low[node] = timer;
        timer++;
        int child = 0;    
        for(int it : adj.get(node)){
            if(it == parent) continue;
            if(!vis[it]){
                dfs(it,node,vis,timeIn,low,mark,adj);
                low[node] = Math.min(low[node],low[it]);
                if(low[it] >= timeIn[node] && parent != -1){
                    mark[node] = 1;
                }
                child++;
            }
            else{
                low[node] = Math.min(low[node],timeIn[it]);
            }
        }
        if(child > 1 && parent == -1){
            mark[node] = 1;
        }
    }
    public static List<Integer> articulationPoints(int V,List<List<Integer>> adj) {
        boolean vis[] = new boolean[V];
        int timeIn[] = new int[V];
        int low[] = new int[V];
        int mark[] = new int[V];
        
        for(int i= 0;i<V;i++){
            if(!vis[i]){
                dfs(i,-1,vis,timeIn,low,mark,adj);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i= 0;i<V;i++){
            if(mark[i] == 1){
                ans.add(i);
            }
        }
        if(ans.size() == 0){
            ans.add(-1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(4);
        adj.get(4).add(1);
        adj.get(4).add(3);
        adj.get(3).add(4);
        adj.get(4).add(2);
        adj.get(2).add(4);
        adj.get(2).add(3);
        adj.get(3).add(2);

        System.out.println(articulationPoints(V, adj));
    }
}
