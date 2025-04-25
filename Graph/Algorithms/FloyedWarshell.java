// Time Complexity: O(V^3)

public class FloyedWarshell {
    public static void floyedWarshell(int dist[][]){
        int n = dist.length;

        // Step 1: Replace -1 with a Infinity and set diagonal elements to 0
        for(int i= 0;i<n;i++){
            for(int j =0;j<n;j++){
                if(dist[i][j] == -1){
                    dist[i][j] = (int)1e8;
                }
                if(i == j) dist[i][j] = 0;
            }
        }

        // Step 2: Apply the floyed warshell algorithm
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j= 0;j<n;j++){
                    if(dist[i][k] != 1e8 && dist[k][j] != 1e8){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Step 3: Convert 'infinite' values back to -1 to indicate no path

        for(int i= 0;i<n;i++){
            for(int j =0;j<n;j++){
                if(dist[i][j] == (int)1e8){
                    dist[i][j] = -1;
                }
            }
        }
    }
    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
          int[][] dist = {
            {0, 4, -1, 5, -1},
            {-1, 0, 1, -1, 6},
            {2, -1, 0, 3, -1},
            {-1, -1, 1, 0, 2},
            {1, -1, -1, 4, 0}
        };

        floyedWarshell(dist);
        System.out.println("Shortest distance matrix:");
        printMatrix(dist);
    }
}
