/*

L.C: 23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:

Input: lists = []
Output: []
Example 3:
Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 */

import java.util.PriorityQueue;

class Node{
    Node next;
    int data;
    Node(Node next,int data){
        this.data = data;
        this.next = next;
    }

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class MergKsortedLL {
    public static Node mergeKLists(Node[] lists) {
        // Priority Queue to hold the nodes, sorted by their value
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Add the head of each list to the priority queue
        for (Node node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        Node dummy = new Node(-1);
        Node temp = dummy;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            temp.next = node;
            temp = temp.next;

            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummy.next;
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
    public static void main(String args[]){
        int arr[] = {2,4,6};
        int arr1[] = {1,5};
        int arr2[] = {1,1,3,7};
        
        Node list1 = convertToLL(arr);
        Node list2 = convertToLL(arr1);
        Node list3 = convertToLL(arr2);

        Node[] lists = new Node[]{list1,list2,list3};
        Node result = mergeKLists(lists);
        System.out.print("Linked list after Mergiing K lists: ");
        printLL(result);
    }
}
