import java.util.ArrayList;
import java.util.List;

public class WeightedGraphList {
    List<List<int []>> adjList;

    public WeightedGraphList(int vertices){
        adjList = new ArrayList<>();
        for(int i = 0;i<vertices;i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src,int dest,int weight){
        adjList.get(src).add(new int[]{dest,weight});
        adjList.get(dest).add(new int[]{src,weight});
    }

    public void display(){
        for(int i = 0;i<adjList.size();i++){
            System.out.print(i+" -> ");
            for(int edge[] : adjList.get(i)){
                System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        WeightedGraphList graph = new WeightedGraphList(3);
        graph.addEdge(0, 1, 5);
        graph.addEdge(1, 2, 10);
        graph.display();
    }
}
