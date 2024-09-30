/*
L.C: 1367. Linked List in Binary Tree

Given a binary tree root and a linked list with head as the first node. 
Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
In this context downward path means a path that starts at some node and goes downwards.

Example 1:
Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Explanation: Nodes in blue form a subpath in the binary Tree.  

Example 2:
Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true

Example 3:
Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: false
Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.
 
Constraints:
The number of nodes in the tree will be in the range [1, 2500].
The number of nodes in the list will be in the range [1, 100].
1 <= Node.val <= 100 for each node in the linked list and binary tree. 
*/
public class LLInBinaryTree {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            next = null;
        }
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            right = null;
            left = null;
        }
    }
    public static ListNode createListNode(int arr[]){
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for(int i = 1;i<arr.length;i++){
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    public static boolean dfs(ListNode head,TreeNode root){
        if(head == null){
            return true;
        }
        if(root == null || head.val != root.val){
            return false;
        }
        return dfs(head.next,root.left) || dfs(head.next,root.right);
    }
    public static boolean isSubPath(ListNode head,TreeNode root){
        if(root == null){
            return false;
        }
        return dfs(head,root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    public static void main(String[] args){
        int arr[] = {4,2,8};
        ListNode head = createListNode(arr);
        // ListNode head = new ListNode(4);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(8);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);

        System.out.println(isSubPath(head, root));
        
    }
}
