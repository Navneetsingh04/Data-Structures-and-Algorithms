import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalsAlgorithm {
    public static int kruskalsMST(int V, int[][] edges) {
        List<int[]> adjEdge = new ArrayList<>();
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adjEdge.add(new int[]{wt,u,v});
        }
        Collections.sort(adjEdge,(x,y) -> x[0]- y[0]);
        
        int parent[] = new int[V];
        int rank[] = new int[V];
        for(int i= 0;i<V;i++){
            parent[i] = i;
        }
        
        int mstWt = 0;
        
        for(int i[] : adjEdge){
            int wt = i[0];
            int u = i[1];
            int v = i[2];
            
            int pu = find(u,parent);
            int pv = find(v,parent);
            
            if(pu != pv){
                mstWt += wt;
                union(pu,pv,parent,rank);
            }
        }
        return mstWt;
    }
    
    public static int find(int x,int parent[]){
        if(parent[x] != x){
            parent[x] = find(parent[x],parent);
        }
        return parent[x];
    }
    
    public static void union(int x,int y,int parent[],int rank[]){
        if(rank[x] < rank[y]){
            parent[x] = y;
        }
        else if(rank[x] > rank[y]){
            parent[y] =x;
        }
        else{
            parent[y] = x;
            rank[x]++;
        }
    }
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
        {0, 1, 10},
        {0, 2, 6},
        {0, 3, 5},
        {1, 3, 15},
        {2, 3, 4}
    };

    int mstCost = kruskalsMST(V, edges);
    System.out.println("MST Cost: " + mstCost);
    }
}
