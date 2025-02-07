/*
L.C:  92. Reverse Linked List II

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 
*/
public class ReverseLinkedListII {
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
    public static Node reverseBetween(Node head,int left,int right){
        if(head  == null || left == right){
            return head;
        }
        Node dummyNode = new Node(-1);
        dummyNode.next = head;
        Node prev = dummyNode;

        for(int i = 1;i<left;i++){
            prev = prev.next;
        }
        Node curr = prev.next;
        Node nextNode = curr.next;

        for(int i = 0;i<right-left;i++){
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
            nextNode = curr.next;
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int left = 2;
        int right = 4;

        Node head = convertToLL(arr);
        printLL(head);
        Node reverseLL = reverseBetween(head, left, right);
        printLL(reverseLL);
    }
}
