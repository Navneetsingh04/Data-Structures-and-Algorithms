class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class InsertAtEnd {
    Node head;
    Node tail;
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
        InsertAtEnd end = new InsertAtEnd();
        end.insertAtEnd(12);
        end.insertAtEnd(1);
        end.insertAtEnd(5);
        end.insertAtEnd(18);
        end.insertAtEnd(7);
        end.insertAtEnd(20);
        end.print();
    }
}
