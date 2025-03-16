/*
L.C: 109. Convert Sorted List to Binary Search Tree

Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
height-balanced binary search tree.

Example 1:
Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

Example 2:
Input: head = []
Output: []

Constraints:

The number of nodes in head is in the range [0, 2 * 104].
-105 <= Node.val <= 105
 */
import java.util.LinkedList;
import java.util.Queue;

public class ConvertSortedListToBST {
    static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static TreeNode convertListToBST(ListNode start,ListNode end){
        if(start == end){
            return null;
        }
        ListNode slow = start;
        ListNode fast = start;
        while(fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.data);
        root.left = convertListToBST(start, slow);
        root.right = convertListToBST(slow.next, end);
        return root;
    }
    public static TreeNode sortedListToBST(ListNode head){
        if(head == null){
            return null;
        }
        return convertListToBST(head, null);
    }
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            System.out.print(temp.data+" ");
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBST(head);
        levelOrderTraversal(root);

    }
}