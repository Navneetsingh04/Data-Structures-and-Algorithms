/*
L.C: 653. Two Sum IV - Input is a BST

Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

Example 1:
Input: root = [5,3,6,2,4,null,7], k = 9
Output: true

Example 2:
Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105 
*/

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
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
    // The `storeInorder` method is used to perform an inorder traversal of the binary search tree and
    // store the elements in a list in sorted order. This method recursively traverses the tree in the
    // order of left subtree, root, and then right subtree.
    public static void storeInorder(Node root,List<Integer> inorder){
        if(root == null) return;
        storeInorder(root.left,inorder);
        inorder.add(root.data);
        storeInorder(root.right,inorder);
    }
    public static boolean findTarget(Node root, int k) {
        List<Integer> inorder = new ArrayList<>();
        storeInorder(root,inorder);
        int start = 0;
        int end = inorder.size()-1;
        while(start < end){
            int sum = inorder.get(start)+inorder.get(end);
            if(sum == k){
                return true;
            }
            else if(sum > k){
                end--;
            }
            else{
                start++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);
        int k = 5;
        Boolean ans = findTarget(root, k);
        System.out.println(ans);
    }
}
