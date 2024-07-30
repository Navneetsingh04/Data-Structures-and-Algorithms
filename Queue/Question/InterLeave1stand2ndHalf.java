import java.util.ArrayDeque;
import java.util.Queue;

public class InterLeave1stand2ndHalf {
    public static void interLeave(Queue<Integer> first){
        Queue<Integer> second = new ArrayDeque<>();
        // push first half of queue in second queue
        int size = first.size();
        for(int i = 0;i<size/2;i++){
            int temp = first.peek();
            first.poll();
            second.add(temp);
        }

        // merg both the halves in original queue
        for(int i = 0;i<size/2;i++){
            int temp = second.peek();
            second.poll();
            first.add(temp);

            temp = first.peek();
            first.poll();
            first.add(temp);
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);

        interLeave(q);
        while(!q.isEmpty()){
            int element = q.peek();
            q.poll();
            System.out.print(element+" ");
        }
    }
}