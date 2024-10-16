class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class InsertBeforeValue{
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
    public static Node insertAthead(Node head,int data){
        Node newnode = new Node(data);
        newnode.next = head;
        return newnode; 
    }
    public static Node insertvalue(Node head,int value,int element){
        if(head == null){
            return null;
        }
        if(head.data == value){
            Node newnode = new Node(element);
            newnode.next = head;
            head = newnode;
            return head;
        }
        Node temp = head;
        while(temp.next != null){
            if(temp.next.data == value){
                Node newnode = new Node(element);
                newnode.next = temp.next;
                temp.next = newnode;
                break;
            }
            temp = temp.next;
        }
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
        head = insertAthead(head, 10);
        head = insertAthead(head, 20);
        head = insertAthead(head, 30);
        head = insertAthead(head, 40);
        head = insertAthead(head, 50);
        System.out.print("Linked list before Insert element before Value in LL: ");
        print(head);
        System.out.print("\nLinked list after inserting element before Value in LL: ");
        head = insertvalue(head, 20,2);
        print(head);
    }
}