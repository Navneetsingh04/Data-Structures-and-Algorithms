/*
L.C: 230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 
Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
*/


public class KthSmallestElement {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    static int k;
    static int result;
    public static int kthSmallest(Node root, int k) {
        KthSmallestElement.k = k;
        inorder(root);
        return result;
    }
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        k--;
        if(k == 0){
            result = root.data;
            return;
        }
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(50);
        root.right = new Node(200);
        root.left.left = new Node(30);
        root.left.right = new Node(70);
        root.right.left = new Node(120);
        root.right.right = new Node(300);
        int k = 3;
        int ans = kthSmallest(root, k);
        System.out.println(k+" smallest element in BST is: "+ans);
    }
}
