/*
L.C: 98. validate Binary Search Tree

Given the root of a binary tree, determine if it is a dataid binary search tree (BST).

A dataid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's dataue is 5 but its right child's dataue is 4.
 
Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.data <= 231 - 1 
*/

public class ValidateBST {
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
    // public static boolean solve(Node root,long lowerBound,long upperBound){
    //     if(root == null){
    //         return true;
    //     }
    //     boolean cond1 = (root.data>lowerBound);
    //     boolean cond2 = (root.data<upperBound);
    //     boolean leftAns = solve(root.left,lowerBound,root.data);
    //     boolean rightAns = solve(root.right,root.data,upperBound);

    //     if(cond1 && cond2 && leftAns && rightAns){
    //         return true;
    //     }
    //     else{
    //         return false;
    //     }
    // }
    // public static boolean isValidBST(Node root) {
    //     long lowerBound = Long.MIN_VALUE;
    //     long upperBound = Long.MAX_VALUE;
    //     boolean ans = solve(root,lowerBound,upperBound);
    //     return ans;
    // }
    
    public static boolean isValidBST(Node root) {
        return checkBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean checkBST(Node root,long min,long max){
        if(root == null ) return true;
        if(root.data <= min || root.data >= max){
            return false;
        }
        return checkBST(root.left,min,root.data) && checkBST(root.right,root.data,max);
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(4);
        root.right.left = new Node(3);
        root.right.right = new Node(6);

        boolean ans = isValidBST(root);
        if(ans){
            System.out.println("It is valid BST");
        }
        else{
            System.out.println("It is not Valid BST");
        }
    }
}