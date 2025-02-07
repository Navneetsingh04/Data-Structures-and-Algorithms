/*
L.C: 24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Explanation:
Example 2:
Input: head = []
Output: []
Example 3:
Input: head = [1]
Output: [1]
Example 4:
Input: head = [1,2,3]
Output: [2,1,3]

Constraints:
The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100 
*/

public class SwapNodesInPairs {
    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static Node convertLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    // public static Node swapPairs(Node head){
    // Node dummyNode = new Node(0);
    // dummyNode.next = head;
    // Node prev = dummyNode;
    // Node curr = head;
    // while(curr != null && curr.next != null){
    // Node nextNode = curr.next;
    // curr.next = nextNode.next;
    // nextNode.next = curr;
    // prev.next = nextNode;
    // prev = curr;
    // curr = curr.next;
    // }
    // return dummyNode.next;
    // }

    // using recurssion
    public static Node swapPairs(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node nextNode = head.next;
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        Node head = convertLL(arr);
        System.out.print("Original Linked List: ");
        printLL(head);
        head = swapPairs(head);
        System.out.print("Swapped Linked List: ");
        printLL(head);
    }
}
