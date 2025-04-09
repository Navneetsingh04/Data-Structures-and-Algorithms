import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
    public static List<Integer> bfsOfGraph(int vetices,List<List<Integer>> adj){
        boolean vis[] = new boolean[vetices+1];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> bfs = new ArrayList<>();
        queue.add(1);
        vis[1] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            bfs.add(node);
            for(Integer i : adj.get(node)){
                if(!vis[i]){
                    vis[i] = true;
                    queue.add(i);
                }
            }
        }
        return bfs;
    }
    public static void main(String[] args) {
        // List<List<Integer>> adj = List.of(
        //     List.of(1, 2),
        //     List.of(0, 3),
        //     List.of(0, 3),
        //     List.of(1, 2)
        // );
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(0));
        adj.add(Arrays.asList(2,6));
        adj.add(Arrays.asList(1,3,4));
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(2,5));
        adj.add(Arrays.asList(4,8));
        adj.add(Arrays.asList(1,7,9));
        adj.add(Arrays.asList(6,8));
        adj.add(Arrays.asList(5,7));
        adj.add(Arrays.asList(6));
        int vertices = 9;
        System.out.println(bfsOfGraph(vertices, adj));
    }
}
