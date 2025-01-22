/*
Flattening a Linked List

Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
Note: The flattened list will be printed using the bottom pointer instead of next pointer.

Note: All linked lists are sorted and the resultant linked list should also be sorted

Examples: 

Input:    5 -> 10 -> 19 -> 28
          |    |     |     |
          V    V     V     V
          7    20    22   35
          |          |     |
          V          V     V
          8         50     40
          |                |
          V                V
          30               45

Output: 5->7->8->10->19->20->22->28->30->35->40->45->50

Input:    3 -> 10 -> 7 -> 14
          |    |     |    |
          V    V     V    V
          9    47    15   22
          |               |        
          V               V      
          17             30

Output: 3->7->9->10->14->15->17->22->30->47   
 */
class  Node{
    Node next;
    Node bottom;
    int data;
    Node(Node next,Node bottom,int data){
        this.data = data;
        this.next = next;
        this.bottom = bottom;
    }

    Node(int data){
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}

public class FlatteningLL {

    public static Node merge(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node res = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            } else {
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
        }

        if (list1 != null) {
            res.bottom = list1;
        } 
        else {
            res.bottom = list2;
        }
        return dummy.bottom;
    }

    public static Node flattenLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        head.next = flattenLL(head.next);
        head = merge(head, head.next);
        return head;
    }

    public static Node push(Node head, int data) {
        Node newNode = new Node(data);
        newNode.bottom = head;
        head = newNode;
        return head;
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        head = push(head, 30);
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 5);

        head.next = push(head.next, 20);
        head.next = push(head.next, 10);

        head.next.next = push(head.next.next, 50);
        head.next.next = push(head.next.next, 22);
        head.next.next = push(head.next.next, 19);

        head.next.next.next = push(head.next.next.next, 45);
        head.next.next.next = push(head.next.next.next, 40);
        head.next.next.next = push(head.next.next.next, 35);
        head.next.next.next = push(head.next.next.next, 28);

        head = flattenLL(head);
        System.out.print("Linked list after flattening: ");
        printLL(head);
    }

}
