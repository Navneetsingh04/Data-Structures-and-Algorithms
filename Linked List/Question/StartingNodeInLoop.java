/*
L.C: 142. Linked List Cycle II

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 */

// import java.util.HashMap;
class Node{
    Node next;
    int data;
    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class StartingNodeInLoop {
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
            System.out.print(head.data);
            head = head.next;
        }
        System.out.println();
    }
    // public static Node startingNode(Node head){
    //     HashMap<Node,Integer> map = new HashMap<>();
    //     Node temp = head;
    //     while(temp != null){
    //         if(map.containsKey(temp)){
    //             return temp;
    //         }
    //         map.put(temp, 1);
    //         temp = temp.next;
    //     }
    //     return null;
    // }
    public static Node startingNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                slow = head;
                while(fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,15,4,13,6,7,8,9};
        Node head = convertToLL(arr);
        head.next.next.next.next.next.next.next = head.next.next.next;
        Node startOfCycle = startingNode(head);
        if(startOfCycle != null) {
            System.out.println("Cycle starts at node with value: " + startOfCycle.data);
        } 
        else {
            System.out.println("No cycle found.");
        }
    }
}
