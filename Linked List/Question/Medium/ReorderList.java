/*
L.C: 143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 
Constraints:
The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
*/
public class ReorderList {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    } 
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
    public static void reoderList(Node head){
        if(head == null || head.next == null){
            return;
        }
        // find middle node
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // split list into two halves
        Node secondHead = slow.next;
        slow.next = null;  //terminate the 1st half

        // reverse the second half

        Node prev = null;
        Node curr = secondHead;

        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        secondHead = prev;

        // merg the two halves
        Node p1 = head;
        Node p2= secondHead;
        while(p2 != null){
            Node next1 = p1.next;
            Node next2 = p2.next;

            p1.next = p2;
            p2.next = next1;
            p1 = next1;
            p2 = next2;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        Node head = convertToLL(arr);
        printLL(head);
        reoderList(head);
        printLL(head);
    }
}
