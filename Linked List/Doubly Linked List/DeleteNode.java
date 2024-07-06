class Node {
    Node next;
    Node prev;
    int data;

    Node(int data, Node next, Node prev) {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }

    Node(int data) {
        this.next = null;
        this.prev = null;
        this.data = data;
    }
}
public class DeleteNode {
    public static Node converArrToLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev; 
            prev = temp;
        }
        return head;
    }
    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        head = head.next;
        head.prev = null;
        return head;
    }
    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node newtail = tail.prev;
        newtail.next = null;
        return head;
    }
    public static Node deleteNode(Node head,Node temp){
        if(temp == null){
            return head;
        }
        if(temp == head){
            return deleteHead(head);
        }
        Node prev = temp.prev;
        Node front = temp.next;
        // deleting the tail
        if(front == null){
            prev.next = null;
        }
        // deleting the middle Node
        else{
            prev.next = front;
            front.prev = prev;
        }
        temp.next = temp.prev = null;
        return head;
    }
    public static void main(String args[]) {
        int arr[] = new int[]{1, 2, 3, 4, 56, 8};
        Node head = converArrToLL(arr);
        System.out.print("Linked List before Deletion: ");
        printLL(head);
        head = deleteNode(head,head.next);
        System.out.print("Linked list after Deletion: ");
        printLL(head);
    }
}