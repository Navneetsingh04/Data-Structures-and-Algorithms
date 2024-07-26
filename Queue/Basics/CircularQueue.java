public class CircularQueue {
    int arr[];
    int size;
    int front;
    int rear;

    public CircularQueue(int size){
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }
    public void push(int data){
        // overflow
        // Empty case -> single element
        // circular Nature
        // normal flow
        if((front == 0 && rear == size-1) || (rear == front-1)){
            System.out.println("OverFlow");
        }
        else if(front == -1 && rear == -1){
            front++;
            rear++;
            arr[rear] = data;
        }
        else if(rear == size-1 && front != 0){
            rear = 0;
            arr[rear] = data;
        }
        else{
            rear++;
            arr[rear] = data;
        }
    }
    public void pop(){
        // underflow
        // Empty case -> single element
        // circular Nature
        // normal flow

        if((front == -1 && rear == -1)){
            System.out.println("underFlow");
        }
        else if(front == rear){
            arr[front] = -1;
            front = -1;
            rear = -1;
        }
        else if(front == size-1){
            arr[front] = -1;
            front = 0;
        }
        else{
            arr[front] = -1;
            front++;
        }
    }
    public void print(){
        System.out.print("Printing Queue: ");
        for(int i = 0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.print();
        q.push(10);
        q.print();
        q.push(20);
        q.print();
        q.push(30);
        q.print();
        q.push(40);
        q.print();
        q.push(50);
        q.print();
        q.push(60);
        q.print();
        q.pop();
        q.pop();
        q.pop();
        q.print();
        q.push(70);
        q.print();
        q.push(80);
        q.print();
        q.push(90);
        q.print();
        q.push(100);
        q.print();
    }
}
