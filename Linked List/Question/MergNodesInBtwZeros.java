/*
L.C: 2181. Merge Nodes in Between Zeros

You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.
For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.

Return the head of the modified linked list.

Example 1:
Input: head = [0,3,1,0,4,5,2,0]
Output: [4,11]
Explanation: 
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 3 + 1 = 4.
- The sum of the nodes marked in red: 4 + 5 + 2 = 11.

Example 2:
Input: head = [0,1,0,3,0,2,2,0]
Output: [1,3,4]
Explanation: 
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 1 = 1.
- The sum of the nodes marked in red: 3 = 3.
- The sum of the nodes marked in yellow: 2 + 2 = 4.
 
Constraints:

The number of nodes in the list is in the range [3, 2 * 105].
0 <= Node.val <= 1000
There are no two consecutive nodes with Node.val == 0.
The beginning and end of the linked list have Node.val == 0.
 */
class Node{
    Node next;
    int data;
    Node(Node next,int data){
        this.next = next;
        this.data = data;
    }
    Node(int data){
        this.next = null;
        this.data = data;
    }
}
public class MergNodesInBtwZeros {
    public static Node convertToLL(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1;i<arr.length;i++){
            mover.next = new Node(arr[i]);
            mover = mover.next;
        }
        return head;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println("null");
    }
    public static Node mergeNodes(Node head) {
        if(head == null){
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        Node lastNode = null;
        int sum = 0;
        while(fast != null){
            if(fast.data != 0){
                sum += fast.data;
            }
            else{
                slow.data = sum;
                lastNode = slow;
                slow = slow.next;
                sum= 0;
            }
            fast  = fast.next;
        }
        lastNode.next = null;
        return head;
    }
    public static void main(String args[]){
        int arr[] = {0,1,5,8,0,5,4,2,0,4,3,0};
        Node head = convertToLL(arr);
        System.out.print("Linked list before merging: ");
        printLL(head);
        head = mergeNodes(head);
        System.out.print("Linked list After merging: ");
        printLL(head);
    }
}
