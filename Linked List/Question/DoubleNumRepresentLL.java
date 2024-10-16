/*
L.C 2816. Double a Number Represented as a Linked List

You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.

Example 1:
Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.

Example 2:
Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 
 
Constraints:

The number of nodes in the list is in the range [1, 104]
0 <= Node.val <= 9
The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.
 */
class Node{
    Node next;
    int data;
    Node(Node next,int data){
        this.next = next;
        this.data = data;
    }
    Node(int data){
        this.next = null;
        this.data = data;
    }
}
public class DoubleNumRepresentLL {
    public static Node push(Node head,int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return head;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println("null");
    }
    public static void solve(Node head,int carry[]){
        if(head == null) return;
        solve(head.next,carry);
        int product = 2*head.data+carry[0];
        head.data = product%10;
        carry[0] = product/10;

    }
    public static Node doubleIt(Node head) {
        int carry[] = new int[1];
        carry[0] = 0;
        solve(head,carry);
        if(carry[0] != 0){
            Node carryNode = new Node(carry[0]);
            carryNode.next = head;
            head = carryNode;
        }
        return head;
    }
    public static void main(String args[]){
        Node head = null;
        head = push(head, 9);
        head = push(head, 9);
        head = push(head, 9);
        System.out.print("Linked list before Double: ");
        printLL(head);
        head = doubleIt(head);
        System.out.print("Linked list After Double: ");
        printLL(head);
    }
}
