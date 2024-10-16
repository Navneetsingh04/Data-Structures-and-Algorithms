// import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueImplementation {
    public static void main(String args[]){
        Queue<Integer> q = new LinkedList<>();
        // Queue<Integer> q = new ArrayDeque<>();
        q.add(5);
        System.out.println("Size of Queue: "+q.size());
        // empty
        if(q.isEmpty() == true){
            System.out.println("Queue is empty");
        }
        else{
            System.out.println("Queue is not empty");
        }
        q.poll();
        System.out.println("Size of Queue: "+q.size());
        q.offer(10);
        System.out.println("Size of Queue: "+q.size());
        q.remove();
        System.out.println("Size of Queue: "+q.size());
        
        q.add(20);
        q.add(30);
        q.add(40);

        System.out.println("Front elment of the queue is "+q.peek());
        LinkedList<Integer> linkedList = (LinkedList<Integer>) q;
        System.out.println("Rear element of the queue is "+linkedList.getLast());

        // ArrayDeque<Integer> arrayDeque = (ArrayDeque<Integer>) q;
        // System.out.println("Rear element of the queue is "+arrayDeque.peekLast());

        System.out.println(q.contains(20));
    }
}
