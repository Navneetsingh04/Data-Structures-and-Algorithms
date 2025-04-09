public class ConnectedComponentsOfGraph {
    static boolean[] visited;
    static int count = 0;
    public static void dfs(int[][] graph, int vertex) {
        visited[vertex] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[vertex][i] == 1 && !visited[i]) {
                dfs(graph, i);
            }
        }
    }
    public static int countConnectedComponents(int[][] graph) {
        visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(graph, i);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 1, 0},
            {0, 1, 1, 0, 1},
            {0, 1, 0, 1, 0}
        };
        System.out.println("Number of connected components: " + countConnectedComponents(graph));
    }
}
