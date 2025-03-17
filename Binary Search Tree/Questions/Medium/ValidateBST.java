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
import java.util.ArrayList;
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
    // Approach 1: Inorder Traversal (Store in List)

    public static void inOrder(Node root,ArrayList<Integer> list){
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }
    public static boolean isBST(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for(int i = 1;i<list.size();i++){
            if(list.get(i) <= list.get(i-1)){
                return false;
            }
        }
        return true;
    }

    // Approach 2: Inorder Traversal Without Extra Space

    static Node prev = null;
    public static boolean checkBST(Node root){
        if(root == null) return true;
        if(!checkBST(root.left)) return false;
        if(prev != null && root.data <= prev.data){
            return false;
        }
        prev = root;
        return checkBST(root.right);
    }
    
    // Approach 3: Min-Max Approach

    static boolean isValid;
    public static void checkBSTI(Node root,long min,long max){
        if(root == null ) return;
        if(root.data <= min || root.data >= max){
            isValid = false;
            return;
        }
        checkBSTI(root.left,min,root.data);
        checkBSTI(root.right,root.data,max);
    }
    public static boolean isBSTUsingMinMax(Node root) {
        isValid = true;
        checkBSTI(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return isValid;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(4);
        root.right.left = new Node(3);
        root.right.right = new Node(6);
        System.out.println(checkBST(root));
        System.out.println(isBST(root));
        System.out.println(isBSTUsingMinMax(root));
    }
}