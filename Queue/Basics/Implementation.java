public class Implementation {
    int arr[];
    int size;
    int front;
    int rear;

    public Implementation(int size){
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = -1;

    }
    public void push(int data){
        // check full
        if(rear ==  size-1){
            System.out.println("Queue OverFlow");
        }
        else if(front == -1 && rear == -1){
            // empty
            front++;
            rear++;
            arr[rear] = data;
        }
        else{
            rear++;
            arr[rear] = data;
        }
    }

    public void pop(){
        // underFlow
        if(front == -1 && rear == -1){
            System.out.println("Queue UnderFlow");
        }
        else if(front == rear){
            // empty case -> single element
            arr[rear] = -1;
            front = -1;
            rear = -1;
        }
        else{
            arr[front] = -1;
            front++;
        }
    }
    public boolean isEmpty(){
        return front == -1 && rear == -1;
    }
    public int getSize(){
        if(front == -1 && rear == -1){
            return 0;
        }
        else{
            return rear-front+1;
        }
    }
    public int getFront(){
        if(front == -1){
            System.out.println("No element in the Queue");
            return -1;
        }
        else{
            return arr[front];
        }
    }
    public int getRear(){
        if(rear == -1){
            System.out.println("No elment in the queue");
            return -1;
        }
        else{
            return arr[rear];
        }
    }
    public void print(){
        System.out.print("Printing Queue: ");
        for(int i = 0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
       Implementation queue = new Implementation(5);
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);
        queue.push(50);
        queue.print();
        System.out.println("size of the queue: "+queue.getSize());
        System.out.println(queue.isEmpty());
        queue.pop();
        queue.push(60);
        queue.print();

        System.out.println("Front element of the queue: "+queue.getFront());
        System.out.println("size of the queue: "+queue.getSize());
        queue.pop();
        queue.print();
        System.out.println("Rear element of the queue: "+queue.getRear());

    }
}