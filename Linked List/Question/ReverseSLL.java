/*
L.C: 206. Reverse Linked List
Given the head of a singly linked list, reverse the list, and return the reversed list.
Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000 
*/

import java.util.Stack;

class Node{
    Node next;
    int data;
    Node(int data,Node next){
        this.next = next;
        this.data = data;
    }
    Node(int data){
        this.next = null;
        this.data = data;
    }
}
public class ReverseSLL {
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
    // public static Node reverseSLL(Node head){
    //     if(head == null || head.next == null){
    //         return head;
    //     }
    //     Node prev = null;
    //     Node current = head;
    //     Node next = null;
    //     while(current != null){
    //         // storing next node
    //         next = current.next;
    //         // reverse current node 
    //         current.next = prev;
    //         // move pointer
    //         prev = current;
    //         current = next;
    //     }
    //     return prev;
    // }
    public static void reverseSLL(Node head,Stack<Integer> st){
        Node temp = head;
        while(temp != null){
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            temp.data = st.peek();
            st.pop();
            temp = temp.next;
        }
    }
    
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4,5};
        Node head = convertToLL(arr);
        Stack<Integer> st = new Stack<>();
        System.out.print("Linked list Before Revesal: ");
        printLL(head);
        // head = reverseSLL(head);
        reverseSLL(head, st);
        System.out.print("Linked list After Revesal: ");
        printLL(head);
        
    }
}
