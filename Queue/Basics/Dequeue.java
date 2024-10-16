public class Dequeue {
    int arr[];
    int size;
    int front;
    int rear;

    Dequeue(int size){
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }
    public void pushFront(int data){
        if((front == 0 && rear == size-1) || (rear == front-1)){
            System.out.println("OverFlow");
        }
        // empty case -> single element
        else if(front == -1 && rear == -1){
            front++;
            rear++;
            arr[front] = data;
        }
        // circular case   
        else if(front == 0 && rear != size-1){
            front = size-1;
            arr[front] = data;
        }
        // normal flow
        else{
            front--;
            arr[front] = data;
        }
    }
    public void pushBack(int data){
        // overflow
        if((front == 0 && rear == size-1) || (rear == front-1)){
            System.out.println("OverFlow");
        }
        // Empty case -> single element
        else if(front == -1 && rear == -1){
            front++;
            rear++;
            arr[rear] = data;
        }
        // circular Nature
        else if(rear == size-1 && front != 0){
            rear = 0;
            arr[rear] = data;
        }
        // normal flow
        else{
            rear++;
            arr[rear] = data;
        }
    }
    public void popFront(){
        if(front == -1 && rear == -1){
            System.out.println("UnderFlow");
            return;
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
    public void popBack(){
        // underflow
        if(front == -1 && rear == -1){
            System.out.println("UnderFlow");
            return;
        }
        // single case->empty case
        else if(front == rear){
            arr[rear] = -1;
            front = -1;
            rear = -1;
        }
        // circular case
        else if(rear == 0){
            arr[rear] = -1;
            rear = size-1;
        }
        // normal flow
        else{
            arr[rear] = -1;
            rear--;
        }
    }
    public static void main(String[] args) {
        
    }
}
