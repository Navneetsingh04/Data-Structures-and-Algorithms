class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class DeleteLast {
    Node head;
    Node tail;
    int size;

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
        size++;
    }
    public int deleteLast(){
        if(head == null){
            throw new IllegalStateException("List is empty");
        }
        // if only one element in the list
        if(head == tail){
            int data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        }
        Node secondLast = get(size-2);
        int data = tail.data;
        tail = secondLast;
        tail.next = null;
        size--;
        return data;
    }
    public Node get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        Node node = head;
        for(int i = 0;i<index;i++){
            node = node.next;
        }
        return node;
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
        DeleteLast obj = new DeleteLast();
        obj.insertAtEnd(1);
        obj.insertAtEnd(2);
        obj.insertAtEnd(3);
        obj.insertAtEnd(10);
        obj.print();
        obj.deleteLast();
        obj.print();
    }
}
