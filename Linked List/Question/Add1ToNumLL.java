/*
Add 1 to a number represented as linked list

A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

Example 1:
Input:
LinkedList: 4->5->6
Output: 457
Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457.

Example 2:
Input:
LinkedList: 1->2->3
Output: 124 

Note: The head represents the left-most digit of the number.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 1021
 */

class Node{
    Node next;
    int data;
    Node(int data,Node next){
        this.next = next;
        this.data = data;
    }
    Node(int data){
        this.next = null;
        this.data = data;
    }
}
public class Add1ToNumLL {
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
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static int addHelpher(Node temp){
        if(temp == null){
            return 1;
        }
        int carry = addHelpher(temp.next);
        temp.data += carry;
        if(temp.data < 10){
            return 0;
        }
        temp.data = 0;
        return 1;
    }
    public static Node addOne(Node head){
        int carry = addHelpher(head);
        if(carry == 1){
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
    public static void main(String args[]){
        int arr[] = new int[]{9,9,9};
        Node head = convertToLL(arr);
        head = addOne(head);
        printLL(head);
    }
}
