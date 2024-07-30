import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
        while(!q.isEmpty()){
            int frontElement = q.peek();
            q.poll();

            st.push(frontElement);
        }
        while(!st.isEmpty()){
            int element = st.peek();
            st.pop();
            q.add(element);
        }
    }

    // Using Recurr sion
    public static void reverse(Queue<Integer> q){
        if(q.isEmpty()){
            return;
        }
        int element = q.peek();
        q.poll();
        reverse(q);
        q.add(element);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
    
        // reverseQueue(q);
        reverse(q);
        System.out.print("Printing Queue after Reversing: ");
        while(!q.isEmpty()){
            int element = q.peek();
            q.poll();
            System.out.print(element+" ");
        }
    }
}
