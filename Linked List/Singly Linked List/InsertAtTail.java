class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        this.next= null;
    }
}
public class InsertAtTail {
    public static Node convertToLL(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static Node insertTail(Node head,int value){
        if(head == null){
            return new Node(value);
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newnode = new Node(value);
        temp.next = newnode;
        return head;
    }
    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static void main(String args[]){
        // int arr[] = new int[]{10,20,30,40,50};
        // Node head = convertToLL(arr);
        Node head = null;
        head = insertTail(head, 5);
        insertTail(head, 10);
        insertTail(head, 15);
        insertTail(head, 20);
        insertTail(head, 25);
        print(head);
    }
}
