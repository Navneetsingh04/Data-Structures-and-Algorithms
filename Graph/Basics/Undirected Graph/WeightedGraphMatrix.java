import java.util.Arrays;

public class WeightedGraphMatrix {
    int adjMatrix[][];
    int vertices;
    int edges;
    public WeightedGraphMatrix(int vertices,int edges){
        this.vertices = vertices;
        this.edges = edges;
        adjMatrix = new int[vertices][edges];
        for(int row[] : adjMatrix){
            Arrays.fill(row,0);
        }
    }
    public void addEdge(int src,int dest,int weight){
        adjMatrix[src][dest] = weight;
        adjMatrix[dest][src] = weight;
    }
    public void display(){
        for(int row[] : adjMatrix){
            System.out.println(Arrays.toString(row));
        }
    }
    public static void main(String[] args) {
        WeightedGraphMatrix graph = new WeightedGraphMatrix(3,3);
        graph.addEdge(0, 1, 5);
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 2);
        graph.display();
    }
}
