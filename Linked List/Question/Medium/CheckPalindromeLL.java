/*
234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindromeor false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 */

import java.util.Stack;

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
public class CheckPalindromeLL{
    public static Node convertToLL(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i =1;i<arr.length;i++){
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

    // Approch 1: using Stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public static boolean isPalindrome(Node head,Stack<Integer> st){
        Node temp = head;
        while(temp != null){
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(temp.data != st.peek()){
                return false;
            }
            temp = temp.next;
            st.pop();
        }
        return true;
    }

    // Approach 2: Using Slow and fast pointer
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node fast = head;
        Node slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        Node newNode = reverse(slow.next);
        Node first = head;
        Node second = newNode;
        while(second != null){
            if(first.data != second.data){
                reverse(newNode);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newNode);
        return true;
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,2,4,1};
        Stack<Integer> st = new Stack<>();
        Node head = convertToLL(arr);
        boolean ans = isPalindrome(head, st);
        // boolean ans = isPalindrome(head);
        if(ans){
            System.out.println("Linked list is palindrome");
        }
        else{
            System.out.println("Linked list is not palindrome");
        }
    }
}