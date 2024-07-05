class Node{
    Node next;
    int data;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class InsertAtPosition {
    Node head;
    Node tail;
    public void insertAtBeginning(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
    }
    public void insertAtEnd(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            tail = node;
        }
    }
    public void insertAtposition(int data,int index){
        if(index == 0){
            insertAtBeginning(data);
            return;
        }
        Node temp = head;
        for(int i = 1;i<index;i++){
            if(temp == null){
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            temp = temp.next;
        }
        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;
    }
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        InsertAtPosition list = new InsertAtPosition();
        list.insertAtEnd(12);
        list.insertAtEnd(9);
        list.insertAtEnd(7);
        list.insertAtEnd(4);
        list.insertAtEnd(10);
        list.insertAtEnd(15);
        list.insertAtposition(18, 3);
        list.insertAtposition(20, 5);
        list.print();
    }
}
