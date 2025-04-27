import java.util.ArrayList;
import java.util.List;

public class EulerCircuitAndPath {
    public static void dfs(List<Integer>[] adj,int node,boolean vis[]){
        vis[node] = true;
        for(int it : adj[node]){
            int adjNode = it;
            if(!vis[adjNode]){
                dfs(adj,adjNode,vis);
            }
        }
    }
    public static boolean isConnected(int V,List<Integer>[] adj){
        int nonZeroNode = -1;
        for(int i= 0;i<V;i++){
            if(adj[i].size() > 0){
                nonZeroNode = i;
                break;
            }
        }
        
        if(nonZeroNode == -1) return true;
        
        // starting DFS with nonZeroNode
        boolean vis[] = new boolean[V];
        dfs(adj,nonZeroNode,vis);
        
        // check if all non-zero degree node are connected
        
        for(int i= 0;i<V;i++){
            if(!vis[i] && adj[i].size() > 0){
                return false;
            } 
        }
        return true;
    }
    
    public static void isEulerCircuit(int V, List<Integer>[] adj) {
        if(!isConnected(V,adj)){
            System.out.println("Graph is not Eulerian");
            return;
        }
        // count odd Degree nodes
        int oddDegree = 0;
        for(int i= 0;i<V;i++){
            if(adj[i].size()%2 != 0){
                oddDegree++;
            }
        }
        if(oddDegree > 2){
            System.out.println("Graph is not Eulerian");
            return;
        }
        if(oddDegree == 2){
            System.out.println("Graph has an Euler Path (Semi-Eulerian)");
            return;
        }
        //if(oddDegree == 0)
        System.out.println("Graph has an Euler Circuit (Eulerian)");
    }
    public static void main(String[] args) {
        // Test Case 1: Graph with Eulerian Path
        int V = 3;
        List<Integer>[] adj = new ArrayList[V];
        for(int i = 0;i<V;i++){
            adj[i] = new ArrayList<>();
        }

        adj[0].add(1); adj[1].add(0);
        adj[1].add(2); adj[2].add(1);
        
        System.out.println("Test Case 1:");
        isEulerCircuit(V, adj);

        // Test Case 2: Disconnected Graph
        V = 4;
        adj = new ArrayList[V];
        for(int i = 0;i<V;i++){
            adj[i] = new ArrayList<>();
        }

        adj[0].add(1); adj[1].add(0);
        adj[2].add(3); adj[3].add(2);
        
        System.out.println("\nTest Case 2:");
        isEulerCircuit(V, adj);

        // Test Case 3: Eulerian Circuit
        V = 3;
        adj = new ArrayList[V];
        for(int i = 0;i<V;i++){
            adj[i] = new ArrayList<>();
        }

        adj[0].add(1); adj[1].add(0);
        adj[1].add(2); adj[2].add(1);
        adj[2].add(0); adj[0].add(2);
        
        System.out.println("\nTest Case 3:");
        isEulerCircuit(V, adj);
    }
}
