/*
L.C: 445. Add Two Numbers II

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.


Example 1:

Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros. 
*/

// Time complexity: O(L1)+O(L2);
// Space Complexity : O(L1)+O(L2)
import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoNumber {
    public static ListNode convertArrToLL(int arr[]){
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for(int i = 1;i<arr.length;i++){
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    public static class ListNode{
        ListNode next;
        int val;
        ListNode(){
            next = null;
        }
        ListNode(int val){
            this.val = val;
            next = null;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        Deque<Integer> st1 = new ArrayDeque<>();
        Deque<Integer> st2 = new ArrayDeque<>();

        while(l1 != null){
            st1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            st2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummyNode = new ListNode();
        int carry = 0;
        while(!st1.isEmpty() || !st2.isEmpty() || carry != 0){
            int num1 = 0;
            int num2 = 0;
            if(!st1.isEmpty()){
                num1 = st1.pop();
            }
            if(!st2.isEmpty()){
                num2 = st2.pop();
            }
            int sum = num1+num2+carry;
            ListNode newNode = new ListNode(sum%10);
            newNode.next = dummyNode.next;
            dummyNode.next = newNode;

            carry = sum/10;
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {
        int arr1[] = {7,2,4,3};
        int arr2[] = {5,6,4};
        ListNode l1 = convertArrToLL(arr1);
        ListNode l2 = convertArrToLL(arr2);
        ListNode ans = addTwoNumbers(l1, l2);
        while(ans != null) {
            System.out.print(ans.val+" ");
            ans = ans.next;
        }
    }
}
