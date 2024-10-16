class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class DeleteFirst {
    Node head;
    Node tail;
    public int deleteFirst(){
        if(head == null){
            return -1;
        }
        int data = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return data;
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
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        DeleteFirst obj = new DeleteFirst();
        obj.insertAtEnd(1);
        obj.insertAtEnd(2);
        obj.insertAtEnd(3);
        obj.insertAtEnd(4);
        obj.insertAtEnd(5);
        obj.insertAtEnd(6);
        System.out.println("Linked list Before Deletion");
        obj.print();
        obj.deleteFirst();
        System.out.println("Linked list After Deletion");
        obj.print();
    }
}
