import java.util.Arrays;
import java.util.Scanner;

public class UnweightedGraphMatrixUserInput {
    int adjMatrix[][];
    int vertices;

    public UnweightedGraphMatrixUserInput(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }
    public void addEdge(int src,int dest){
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }
    public void display(){
        for(int row[] : adjMatrix){
            System.out.println(Arrays.toString(row));
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int v = s.nextInt();
        System.out.print("Enter number of edges: ");
        int e = s.nextInt();
        UnweightedGraphMatrixUserInput graph = new UnweightedGraphMatrixUserInput(v);

        System.out.println("Enter edges(src,dest)");
        for(int i = 0;i<e;i++){
            int src = s.nextInt();
            int dest = s.nextInt();
            graph.addEdge(src, dest);
        }
        graph.display();
        s.close();
    }
}
