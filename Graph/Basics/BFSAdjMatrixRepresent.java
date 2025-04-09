import java.util.Queue;
import java.util.LinkedList;
public class BFSAdjMatrixRepresent {
    public static void bfs(int[][] adjMatrix, int startVertex) {
        boolean[] visited = new boolean[adjMatrix.length];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[startVertex] = true;
        queue.add(startVertex);
        
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for(int i = 0;i<adjMatrix[vertex].length;i++){
                if(adjMatrix[vertex][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] adjMatrix = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 1, 0},
            {0, 1, 1, 0, 1},
            {0, 1, 0, 1, 0}
        };
        int startVertex = 0;
        bfs(adjMatrix, startVertex);
    }
}