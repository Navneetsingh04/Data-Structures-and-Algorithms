/* 
L.C: 147. Insertion Sort List

Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
 

Constraints:

The number of nodes in the list is in the range [1, 5000].
-5000 <= Node.val <= 5000
*/
public class InsertionSortList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            next = null;
        }
    }
    public ListNode convertToLL(int arr[]){
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for(int i = 1;i<arr.length;i++){
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    public ListNode insertionSortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head.next;   // Start from 2nd Node
        head.next = null;  // 1st node is already in sorted portion

        while(curr != null){
            ListNode prev = dummy;
            ListNode next = curr.next;
            while(prev.next != null && prev.next.val < curr.val){
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        InsertionSortList list = new InsertionSortList();
        int arr[] = {4,2,1,3};
        ListNode head = list.convertToLL(arr);
        ListNode sorted = list.insertionSortList(head);
        while(sorted != null){
            System.out.print(sorted.val+" ");
            sorted = sorted.next;
        }
    }
}