/*
L.C: 1382. Balance a Binary Search Tree

Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

Example 1:
Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.

Example 2:
Input: root = [2,1,3]
Output: [2,1,3]
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 105 
*/

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void inorder(Node root,List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
    }
    public static Node buildTree(List<Integer> list,int start,int end){
        if(start > end) return null;
        int mid = (start+end)/2;
        Node root = new Node(list.get(mid));
        root.left = buildTree(list,start,mid-1);
        root.right = buildTree(list,mid+1,end);
        return root;
    }
    public static Node balanceBST(Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        // build balance BST using inorder Traversal
        return buildTree(list,0,list.size()-1);
    }
    public static void printTree(Node root){
        if(root == null) return;
        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);
        root.right.right.right = new Node(4);

        Node ans = balanceBST(root);
        System.out.println("Inorder Traversal for BST is: ");
        printTree(ans);
    }
}
