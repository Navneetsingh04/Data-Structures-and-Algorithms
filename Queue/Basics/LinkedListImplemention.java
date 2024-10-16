public class LinkedListImplemention {
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node front;
    Node rear;

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(rear == null){
            front = rear = newNode;
            System.out.println(data+" enqueued to the queue");
            return;
        }
        rear.next = newNode;
        rear = newNode;
        System.out.println(data+" enqueued to the queue");
    }
    public int dequeue(){
        if(front == null){
            System.out.println("Queue underflow");
            return -1;
        }
        int deque = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        return deque;
    }
    public int peek(){
        if(front == null){
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }
    public boolean isEmpty(){
        return front == null;
    }
    public void print(){
        if(front == null){
            System.out.println("Queue is empty");
        }
        Node temp = front;
        System.out.print("Element of queue is: ");
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedListImplemention queue = new LinkedListImplemention();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Front element is: " + queue.peek());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.print();
        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.print();
    }
}
