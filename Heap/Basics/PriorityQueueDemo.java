import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3);
        pq.add(1);
        pq.add(2);
        pq.add(5);
        pq.add(4);
        
        System.out.println("Priority Queue: "+pq);
        System.out.println("Peek: "+pq.peek());
        pq.poll();
        System.out.println("Prority Queue after removing top element: "+pq);
        System.out.println("Does priority Queue conatins 3?: "+pq.contains(5));
        System.out.println("Size of queue: "+pq.size());

        // removing all elements from the queue
        pq.clear();
        System.out.println("Is queue is Empty: "+pq.isEmpty());
    }
}
