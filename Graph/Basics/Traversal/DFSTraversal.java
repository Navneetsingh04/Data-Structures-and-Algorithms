import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class DFSTraversal {
    public static void dfs(int node,boolean visited[],List<List<Integer>> adjList, List<Integer> ans){
        visited[node] = true;
        ans.add(node);
        for(int it : adjList.get(node)){
            if(!visited[it]){
                dfs(it, visited, adjList, ans);
            }
        }
    }
    public static List<Integer> dfsOfGraph(int v,List<List<Integer>> adjList){
        boolean visited[] = new boolean[v];
        visited[0] = true;
        List<Integer> ans = new ArrayList<>();
        dfs(0, visited, adjList, ans);
        return ans;
    }
    public static void main(String[] args) {
        int v = 8;
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(1,2));
        adj.add(Arrays.asList(0,4,5));
        adj.add(Arrays.asList(0,3,6));
        adj.add(Arrays.asList(2,7));
        adj.add(Arrays.asList(1));
        adj.add(Arrays.asList(1));
        adj.add(Arrays.asList(2,7));
        adj.add(Arrays.asList(3,6));
        System.out.println("DFS Traversal of the graph is: ");
        System.out.println(dfsOfGraph(v, adj));
        // Output: [0, 1, 4, 5, 2, 3, 7, 6]
    }
}
