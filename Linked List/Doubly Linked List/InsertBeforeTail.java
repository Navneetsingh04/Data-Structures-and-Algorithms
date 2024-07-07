class Node{
    Node next;
    Node prev;
    int data;

    Node(int data,Node next,Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class InsertBeforeTail {
    public static Node convertToLL(int arr[]){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i = 1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev;
            prev = temp;
        }
        return head;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static Node insertBeforetail(Node head,int data){
        if(head.next == null){
            return insertBeforetail(head, data);
        }
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        Node prev = tail.prev;
        Node newNode = new Node(data,tail,prev);
        prev.next = newNode;
        tail.prev = newNode;
        return head;
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,5,8,7,9};
        Node head = convertToLL(arr);
        System.out.print("Linked List before Inserting elemnt before tail of LL: ");
        printLL(head);
        head = insertBeforetail(head, 4);
        System.out.print("Linked List After Inserting element before tail of LL: ");
        printLL(head);
    }
}