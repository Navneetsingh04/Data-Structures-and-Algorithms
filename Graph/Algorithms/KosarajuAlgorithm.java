
// Kosaraju's Algorithm for finding strongly connected components in a directed graph
// Time Complexity: O(V + E)
// Space Complexity: O(V + E) 

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgorithm {
    public static void dfs(int node,boolean vis[],List<List<Integer>> adj,Stack<Integer> st){
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,adj,st);
            }
        }
        st.push(node);
    }
    public static void dfs3(int node,boolean vis[],List<List<Integer>> adjT){
        vis[node] = true;
        for(int it : adjT.get(node)){
            if(!vis[it]){
                dfs3(it,vis,adjT);
            }
        }
    }
    public static int kosaraju(List<List<Integer>> adj) {
        int n = adj.size();
        boolean vis[] = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,adj,st);
            }
        }
        
        List<List<Integer>> transpose = new ArrayList<>();
        for(int i = 0;i<n;i++){
            transpose.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            vis[i] = false;
            for(int neighbor : adj.get(i)) {
                transpose.get(neighbor).add(i);
            }
        }
        
        int scc = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(!vis[node]){
                scc++;
                dfs3(node,vis,transpose);
            }
        }
        return scc;
    }
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(3);
        System.out.println("Number of strongly connected components: " + kosaraju(adj));
    }
}
