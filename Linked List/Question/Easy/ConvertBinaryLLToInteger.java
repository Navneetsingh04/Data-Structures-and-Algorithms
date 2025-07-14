/*
L.C: 1290. Convert Binary Number in a Linked List to Integer

Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list.
The most significant bit is at the head of the linked list.

Example 1:

Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10

Example 2:
Input: head = [0]
Output: 0

Constraints:
The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1. 
*/
// Time Complexity : O(n)
// space Complexity : O(n)
public class ConvertBinaryLLToInteger {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int val) {
            this.next = null;
            this.val = val;
        }
    }

    public static int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();

        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.val);
            temp = temp.next;
        }
        int n = sb.length();
        int num = 0;
        int pow2 = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (sb.charAt(i) == '1') {
                num += pow2;
            }
            pow2 *= 2;
        }
        return num;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(getDecimalValue(head));
    }
}
