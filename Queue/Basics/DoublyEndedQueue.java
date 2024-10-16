import java.util.ArrayDeque;
import java.util.Deque;

public class DoublyEndedQueue {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(10);
        dq.push(20);
        System.out.println("Front element of deque: "+dq.peek());
        System.out.println("Front element of deque: "+dq.getFirst());
        System.out.println("Last element of deque: "+dq.getLast());
        dq.poll();
        // System.out.println("Front element of deque: "+dq.getFirst());
        // System.out.println("Last element of deque: "+dq.getLast());

        dq.addFirst(4);
        dq.addLast(40);
        System.out.println("Front element of deque: "+dq.getFirst());
        System.out.println("Last element of deque: "+dq.getLast());
        
    }
}
