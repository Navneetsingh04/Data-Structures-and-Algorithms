/*
L.C: 232. Implement Queue using Stacks

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal  queue (push, peek, pop, and empty).
 */
import java.util.Stack;
public class QueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // 1st Approach

    public void push(int data){
        while(!s1.isEmpty()){
            s2.push(s1.peek());
            s1.pop();
        }
        s1.push(data);
        while(!s2.isEmpty()){
            s1.push(s2.peek());
            s2.pop();
        }
    }
    public int pop(){
        int temp = s1.peek();
        s1.pop();
        return temp;
    }
    public int peek(){
        return s1.peek();
    }
    public boolean empty(){
        return s1.isEmpty() && s2.isEmpty();
    }

    // 2nd Approach

    // public void push(int data){
    //     s1.push(data);
    // }
    // public int pop(){
    //     int pop = -1;
    //     if(!s2.isEmpty()){
    //         pop = s2.peek();
    //     }
    //     else{
    //         while(!s1.isEmpty()){
    //             s2.push(s1.peek());
    //             s1.pop();
    //         }
    //         pop = s2.peek();
    //     }
    //     s2.pop();
    //     return pop;
    // }
    // public int peek(){
    //     int front = -1;
    //     if(!s2.isEmpty()){
    //         front = s2.peek();
    //     }
    //     else{
    //         while(!s1.isEmpty()){
    //             s2.push(s1.peek());
    //             s1.pop();
    //         }
    //         front = s2.peek();
    //     }
    //     return front;
    // }
    // public boolean empty(){
    //     return s1.isEmpty() && s2.isEmpty();
    // }

        public static void main(String args[]){
        QueueUsingStack obj = new QueueUsingStack();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());
        
    }
}
