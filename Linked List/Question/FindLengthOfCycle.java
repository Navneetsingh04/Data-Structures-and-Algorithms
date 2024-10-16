/*
Problem statement
You’re given a linked list. The last node might point to null, or it might point to a node in the list, thus forming a cycle.
Find out whether the linked list has a cycle or not, and the length of the cycle if it does.
If there is no cycle, return 0, otherwise return the length of the cycle.

Example:
Input: Linked List: 4 -> 10 -> 3 -> 5 -> 10(at position 2)
Output: Length of cycle = 3
Explanation: The cycle is 10, 3, 5.
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
public class FindLengthOfCycle {
    public static int findLen(Node slow,Node fast){
        int count = 1;
        fast = fast.next;
        while(slow != fast){
            count++;
            fast = fast.next;
        }
        return count;
    }
    public static int lengthOfCycle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return findLen(slow,fast);
            }
        }
        return 0;
    }
    static Node newNode(int data){
        Node temp = new Node(data);
        return temp;
    }
 
    public static void main(String args[]){
        Node head = newNode(4);
        head.next = newNode(10);
        head.next.next = newNode(3);
        head.next.next.next = newNode(5);
        head.next.next.next.next = newNode(10);
 
        head.next.next.next.next.next = head.next;
        System.out.println("Length of the Cycle is: "+lengthOfCycle(head));
    }
}
