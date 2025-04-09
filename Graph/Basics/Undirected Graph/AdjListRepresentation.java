import java.util.ArrayList;
import java.util.List;

public class AdjListRepresentation {
    List<List<Integer>> adjList;
    public AdjListRepresentation(int vertices){
        adjList = new ArrayList<>();
        for(int i = 0;i<vertices;i++){
            adjList.add(new ArrayList<>());
        }
    }
    public void addEdge(int src,int dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }
    public void display(){
        for(int i = 0;i<adjList.size();i++){
            System.out.println(i+" -> "+adjList.get(i));
        }
    }
    public static void main(String[] args) {
        AdjListRepresentation graph = new AdjListRepresentation(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.display();
    }
}
