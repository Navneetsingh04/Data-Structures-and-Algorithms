class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class InsertAtHead {
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
    public static Node InsertHead(Node head,int value){
        Node newnode = new Node(value);
        newnode.next = head;
        return newnode;
    }
    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static void main(String args[]){
        int arr[] = new int[]{10,20,30,40,50};
        Node head = convertToLL(arr);
        head = InsertHead(head, 5);
        print(head);
    }
}
