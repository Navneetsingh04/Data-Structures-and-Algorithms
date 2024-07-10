/*
L.C: 82. Remove Duplicates from Sorted List II

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]
 
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
public class DeleteDuplicate {
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
    public static Node deleteDuplicate(Node head){
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;
        while(curr != null){
            boolean isDuplicate = false;
            while(curr.next != null && curr.data == curr.next.data){
                curr = curr.next;
                isDuplicate = true;
            }
            if(isDuplicate){
                prev.next = curr.next;
            }
            else{
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,1,2,3,3,4,4,5,6};
        Node head = convertToLL(arr);
        System.out.print("Linked list Before deletion of duplicate Node: ");
        print(head);
        head = deleteDuplicate(head);
        System.out.print("Linked list Before deletion of duplicate Node: ");
        print(head);
    }
}
