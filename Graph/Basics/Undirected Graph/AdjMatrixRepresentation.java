import java.util.Arrays;

public class AdjMatrixRepresentation {
    int adjMatrix[][];
    int vertices;
    public AdjMatrixRepresentation(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }
    public void addEdge(int src,int des){
        adjMatrix[src][des] = 1;
        adjMatrix[des][src] = 1;  // undirected graph
    }
    public void display(){
        for(int i[] : adjMatrix){
            System.out.println(Arrays.toString(i));
        }
    }
    public static void main(String[] args) {
        AdjMatrixRepresentation graph = new AdjMatrixRepresentation(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.display();
    }
}
