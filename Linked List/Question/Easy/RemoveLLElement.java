/*L.C: 203. Remove Linked List Elements

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:
Input: head = [], val = 1
Output: []

Example 3:
Input: head = [7,7,7,7], val = 7
Output: []
 
Constraints:
The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50
*/
public class RemoveLLElement {
    public static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node convertToLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            mover.next = newNode;
            mover = newNode;
        }
        return head;
    }

    public static Node removeNode(Node head, int data) {
        while (head != null && head.data == data) {
            head = head.next;
        }
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 6, 3, 4, 5, 6 };
        int data = 6;
        Node head = convertToLL(arr);
        printLL(head);
        removeNode(head, data);
        printLL(head);

    }
}
