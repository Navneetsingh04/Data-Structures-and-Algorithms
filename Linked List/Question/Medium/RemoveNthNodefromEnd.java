/*
L.C: 19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
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
public class RemoveNthNodefromEnd {
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
    public static Node removeNthNode(Node head,int n){
        Node fast = head;
        Node slow = head;
        for(int i = 0;i<n;i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5};
        Node head = convertToLL(arr);
        System.out.print("Linked List before Deletion: ");
        printLL(head);
        head = removeNthNode(head, 4);
        System.out.print("Linked List before Deletion: ");
        printLL(head);
    }
}
