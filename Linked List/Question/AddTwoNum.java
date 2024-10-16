/*
L.c: 2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 
Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
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
public class AddTwoNum {
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
    public static Node addTwoNumber(Node head1,Node head2){
        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        int carry = 0;
        while(head1 != null || head2 != null){
            int sum = carry;
            if(head1 != null){
                sum += head1.data;
                head1 = head1.next;
            }
            if(head2 != null){
                sum += head2.data;
                head2 = head2.next;
            }
            Node newNode = new Node(sum%10);
            carry = sum/10;
            current.next = newNode;
            current = current.next;
        }
        if(carry>0){
            Node newNode = new Node(carry);
            current.next = newNode;
        }
        return dummyNode.next;
    }
    public static void main(String args[]){
        int arr1[] = new int[]{3,5};
        int arr2[] = new int[]{4,5,9,9};
        Node head1 = convertToLL(arr1);
        System.out.print("Linked List1: ");
        printLL(head1);
        Node head2 = convertToLL(arr2);
        System.out.print("Linked List2: ");
        printLL(head2);
        System.out.print("Linked list after Addtion: ");
        Node head = addTwoNumber(head1, head2);
        printLL(head);

    }
}
