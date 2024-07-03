class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class DeleteHead {
    public static Node convertArr2LL(int arr[]){
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
    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static Node removeHead(Node head){
        if(head == null){
            return head;
        }
        head = head.next;
        return head;  
    }
    public static void main(String args[]){
        // int arr[] = new int[]{1,2,3,4,5};
        // Node head = convertArr2LL(arr);
        Node head = null;
        head = insertAthead(head, 10);
        head = insertAthead(head, 20);
        head = insertAthead(head, 30);
        head = insertAthead(head, 40);
        head = insertAthead(head, 50);
        System.out.print("Linked list Before deletion: ");
        print(head);
        head = removeHead(head);
        System.out.print("\nLinked list After deletion: ");
        print(head);
    }
}
