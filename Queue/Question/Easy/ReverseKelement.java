import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
public class ReverseKelement {
    public static void reverseKelement(Queue<Integer> q,int k){
        Stack<Integer> st  = new Stack<>();
        if(k > q.size() || k == 0){
            return;
        }
        // Push first k element in the stack
        for(int i = 0;i<k;i++){
            int frontElement = q.peek();
            q.poll();
            st.push(frontElement);
        }
        // push all k element int he queue
        while(!st.isEmpty()){
            int temp = st.peek();
            st.pop();
            q.add(temp);
        }
        // pop and push first (n-k) elements into queue again
        int n = q.size();
        for(int i = 0;i<(n-k);i++){
            int temp = q.peek();
            q.poll();
            q.add(temp);
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
        int n = 3;
        reverseKelement(q, n);
        System.out.print("Printing queue after Reversing first "+n+" element: ");
        while(!q.isEmpty()){
            int element = q.peek();
            q.poll();
            System.out.print(element+" ");
        }
    }
}