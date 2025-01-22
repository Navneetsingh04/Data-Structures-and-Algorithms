/*
GFG: Linked List Group Reverse

Given the head a linked list, the task is to reverse every k node in the linked list. If the number of nodes is not a multiple of k then the left-out nodes in the end, should be considered as a group and must be reversed.

Examples:
Input: head = 1 -> 2 -> 2 -> 4 -> 5 -> 6 -> 7 -> 8, k = 4
Output: 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5

Explanation: The first 4 elements 1, 2, 2, 4 are reversed first and then the next 4 elements 5, 6, 7, 8. Hence, the resultant linked list is 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5.
Input: head = 1 -> 2 -> 3 -> 4 -> 5, k = 3
Output: 3 -> 2 -> 1 -> 5 -> 4

Explanation: The first 3 elements 1, 2, 3 are reversed first and then left out elements 4, 5 are reversed. Hence, the resultant linked list is 3 -> 2 -> 1 -> 5 -> 4.

Constraints:
1 <= size of linked list <= 105
1 <= data of nodes <= 106
1 <= k <= size of linked list 
*/

public class LLGroupReverse {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static Node reverseKGroup(Node head,int k){
        if(head == null || k<=1){
            return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node prevGroupEnd = dummy;
        Node curr = head;

        while(curr != null){
            Node groupStart = curr;
            int count = 0;
            while(curr != null && count<k){
                curr = curr.next;
                count++;
            }
            if(count == k){
                Node prev = null;
                Node next = null;
                Node groupEnd = groupStart;
                while(count>0){
                    next = groupStart.next;
                    groupStart.next = prev;
                    prev = groupStart;
                    groupStart = next;
                    count--;
                }
                prevGroupEnd.next  = prev;
                groupEnd.next = curr;
                prevGroupEnd = groupEnd;
            }
            else{
                Node prev = null;
                while(groupStart != null){
                    Node next = groupStart.next;
                    groupStart.next = prev;
                    prev = groupStart;
                    groupStart = next;
                }
                prevGroupEnd.next = prev;
                break;
            }
        }
        return dummy.next;
    }
    public static Node LinkedList(int arr[]){
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
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {1,2,2,4,5,6,7,8};
        int k = 3;
        Node head = LinkedList(arr);
        Node ans = reverseKGroup(head, k);
        printLL(ans);
    }
}
