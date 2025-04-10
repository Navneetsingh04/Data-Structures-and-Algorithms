/*
Detect Cycle in Undirected Graph

Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle or not.
*/

// Time Complexity: O(V + E)
// Space Complexity: O(V + E)

import java.util.ArrayList;
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
public class DetectCycleUndirectedGraph {
    public static boolean bfs(int src,int V, List<List<Integer>> adjList,boolean vis[]){
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.first;
            int parent = p.second;
            
            for(int i : adjList.get(node)){
                if(!vis[i]){
                    vis[i] = true;
                    q.add(new Pair(i,node));
                }
                else if(parent != i){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(int node,int parent,List<List<Integer>> adjList,boolean vis[]){
        vis[node] = true;
        for(int i : adjList.get(node)){
            if(!vis[i]){
               if(dfs(i,node,adjList,vis)){
                   return true;
               }
            }
            else if(i != parent){
                return true;
            }
        }
        return false;
    }
    public static boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i[] : edges){
            adjList.get(i[0]).add(i[1]);
            adjList.get(i[1]).add(i[0]);
        }
        for(int i = 0;i<V;i++){
            if(!vis[i]){
                if(bfs(i,V,adjList,vis)) return true;
                // if(dfs(i,-1,adjList,vis)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {1, 3}, {3, 4}};
        System.out.println(isCycle(V, edges)); 
    }
}
