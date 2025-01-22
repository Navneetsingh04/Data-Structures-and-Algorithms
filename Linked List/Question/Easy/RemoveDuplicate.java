/*
L.C: 83. Remove Duplicates from Sorted List

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class RemoveDuplicate {
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
    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static Node removeDuplicate(Node head){
        Node temp = head;
        while(temp != null && temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,1,2,3,3,4};
        Node head = convertToLL(arr);
        System.out.print("Linked list before removal of duplicate node: ");
        print(head);
        head = removeDuplicate(head);
        System.out.print("Linked list After removal of duplicate node: ");
        print(head);
    }
}
