import java.util.Arrays;
import java.util.Scanner;

public class WeightedGraphMatrixUserInput {
    int adjMatrix[][];
    int vertices;

    public WeightedGraphMatrixUserInput(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
        for(int i[] :  adjMatrix){
            Arrays.fill(i, 0);
        }
    }
    public void addEdge(int src,int dest,int weight){
        adjMatrix[src-1][dest-1] = weight;
        adjMatrix[dest-1][src -1] = weight;  
    }
    public void display(){
        for(int i[]: adjMatrix){
            System.out.println(Arrays.toString(i));
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int v = s.nextInt();
        System.out.print("Enter number of edges: ");
        int e = s.nextInt();
        
        WeightedGraphMatrixUserInput graph = new WeightedGraphMatrixUserInput(v);
        System.out.println("Enter edges (src dest weight): ");
        for(int i = 0;i<e;i++){
            int src = s.nextInt();
            int dest = s.nextInt();
            int weight = s.nextInt();
            graph.addEdge(src, dest, weight);
        }
        graph.display();
        s.close();
    }
}
