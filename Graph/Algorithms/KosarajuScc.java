// Time complexity O(V+E)
// Space complexity O(V+E)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajuScc{
    static List<List<Integer>> kosaraju(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<V;i++){
            if(!vis[i]){
                dfs1(i, adj, vis, st);
            } 
        }
        List<List<Integer>> transpose = new ArrayList<>();

        for(int i = 0;i<V;i++){
            transpose.add(new ArrayList<>());
        } 
        for(int i = 0;i<V;i++){
            vis[i] = false;
            for(int neighbor : adj.get(i)){
                transpose.get(neighbor).add(i);
            }
        }

        List<List<Integer>> sccs = new ArrayList<>();

        while(!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                List<Integer> scc = new ArrayList<>();
                dfs2(node, transpose, vis, scc);
                sccs.add(scc);
            }
        }
        return sccs;
    }

    static void dfs1(int node, List<List<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) dfs1(neighbor, adj, vis, st);
        }
        st.push(node);
    }

    static void dfs2(int node, List<List<Integer>> adj, boolean[] vis, List<Integer> scc) {
        vis[node] = true;
        scc.add(node);
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) dfs2(neighbor, adj, vis, scc);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(4);

        List<List<Integer>> sccs = kosaraju(V, adj);
        for (List<Integer> scc : sccs) {
            System.out.println(scc);
        }
    }
}
