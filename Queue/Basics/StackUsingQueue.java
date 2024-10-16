/*
L.C: 225. Implement Stack using Queues

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
*/
import java.util.ArrayDeque;
import java.util.Queue;
public class StackUsingQueue {
    // 1st Approach using single Queue

    Queue<Integer> q1 = new ArrayDeque<>();
    // public void push(int x){
    //     q1.add(x);
    //     for(int i = 0;i<q1.size()-1;i++){
    //         int top = q1.peek();
    //         q1.poll();
    //         q1.add(top);
    //     }
    // }
    // public int pop(){
    //     int temp = q1.peek();
    //     q1.poll();
    //     return temp;
    // }
    // public int top(){
    //     return q1.peek();
    // }
    // public boolean empty(){
    //     return q1.isEmpty();
    // }

    // 2nd Approach: using two queue

    Queue<Integer> q2 = new ArrayDeque<>();
    public void push(int x){
        q2.add(x);
        while(!q1.isEmpty()){
            q2.add(q1.peek());
            q1.poll();
        }
        while(!q2.isEmpty()){
            q1.add(q2.peek());
            q2.poll();
        }
    }
    public int pop(){
        int temp = q1.peek();
        q1.poll();
        return temp;
    }
    public int top(){
        return q1.peek();
    }
    public boolean empty(){
        return q1.isEmpty() && q2.isEmpty();
    }
    public static void main(String args[]){
        StackUsingQueue obj = new StackUsingQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);

        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
