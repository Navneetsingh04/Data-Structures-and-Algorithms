/*
L.C: 958. Check Completeness of a Binary Tree

Given the root of a binary tree, determine if it is a complete binary tree.

In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example 1:

Input: root = [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.

Example 2:
Input: root = [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.
 
Constraints:

The number of nodes in the tree is in the range [1, 100].
1 <= Node.val <= 1000
 */

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBinaryTree {
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

    // public static int countNode(Node root){
    //     if(root == null) return 0;
    //     return 1+countNode(root.left)+countNode(root.right);
    // }
    // public static int levelOrderTraversal(Node root){
    //     if(root == null) return -1;
    //     Queue<Node> q = new LinkedList<>();
    //     q.add(root);
    //     int lastNode = 0;
    //     boolean end = false;
    //     while(!q.isEmpty()){
    //         Node temp = q.poll();
    //         lastNode++;
    //         if(temp.left != null){
    //             if(end) return lastNode;
    //             q.add(temp.left);
    //         }
    //         else{
    //             end = true;
    //         }
    //         if(temp.right != null){
    //             if(end) return lastNode;
    //             q.add(temp.right);
    //         }
    //         else{
    //             end = true;
    //         }
    //     }
    //     return lastNode;
    // }
    // public static boolean isCompleteTree(Node root) {
    //     int totalNode = countNode(root);
    //     int lastNode = levelOrderTraversal(root);
    //     return totalNode == lastNode;
    // }

    public static  boolean levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean nullFound = false;
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp == null){
                nullFound = true;
            }
            else{
                if(nullFound) return false;
                q.add(temp.left);
                q.add(temp.right);
            }
        }
        return true;
    }
    public static boolean isCompleteTree(Node root) {
        return levelOrderTraversal(root);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        if(isCompleteTree(root)){
            System.out.println("Complete Binary Tree");
        }
        else{
            System.out.println("Not a Valid Complete Binary Tree");
        }
    }
}