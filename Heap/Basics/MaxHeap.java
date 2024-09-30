import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(4);
        pq.add(1);
        pq.add(6);
        pq.add(2);
        pq.add(3);
        pq.add(5);

        System.out.println("Max-Heap: "+pq);
        System.out.println("Top element: "+pq.peek());
        System.out.println("Removing top Element: "+pq.poll());
        System.out.println("Size of max-Heap: "+pq.size());
        System.out.println("Top element: "+pq.peek());
    }
}
