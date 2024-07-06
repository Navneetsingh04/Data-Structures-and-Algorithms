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
public class DeleteKthElement {
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

    public static Node removeKthElement(Node head, int k) {
        if (head == null) {
            return null;
        }
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            if (cnt == k) break;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bound");
            return head;
        }
        Node prev = temp.prev;
        Node front = temp.next;
        // single element
        if (prev == null && front == null) {
            return null;
        }
        // head
        else if (prev == null) {
            return deleteHead(head);
        }
        // Tail
        else if (front == null) {
            return deleteTail(head);
        }
        prev.next = front;
        front.prev = prev;
        temp.next = null;
        temp.prev = null;
        return head;
    }

    public static void main(String args[]) {
        int arr[] = new int[]{1, 2, 3, 4, 56, 8};
        Node head = converArrToLL(arr);
        System.out.print("Linked List before Deletion: ");
        printLL(head);
        head = removeKthElement(head, 5);
        System.out.print("Linked list after Deletion: ");
        printLL(head);
    }
}
