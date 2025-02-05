
/*
L.C: 543. Diameter of Binary Tree

Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1
*/

public class DiameterOfBinaryTree {
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
    // Brute force
    // T.C: O(N)^2

    // public static int height(Node root) {
    //     if(root == null){
    //         return 0;
    //     }
    //     int leftHeight = height(root.left);
    //     int rightHeight = height(root.right);
    //     int maxheight = Math.max(leftHeight,rightHeight)+1;
    //     return maxheight;
    // }
    // public static int diameterOfBinaryTree(Node root) {
    //     if(root == null){
    //         return 0;
    //     }
    //     int option1 = diameterOfBinaryTree(root.left);
    //     int option2 = diameterOfBinaryTree(root.right);
    //     int option3 = height(root.left)+height(root.right);
    //     int diameter = Math.max(option1,Math.max(option2,option3));
    //     return diameter;
    // }

    // optimal Approach
    // T.C : O(N);

    public static int height(Node root,int diameter[]) {
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left,diameter);
        int rightHeight = height(root.right,diameter);
        diameter[0] = Math.max(diameter[0],leftHeight+rightHeight);
        return 1+Math.max(leftHeight,rightHeight);
    }
    public static int diameterOfBinaryTree(Node root) {
       int diameter[] = new int[1];
       height(root, diameter);
        return diameter[0];
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);                                                                
        root.right = new Node(3);
        root.left.left = new Node(4);  
        root.left.right = new Node(5);    
        
        System.out.println("Diamtere of Binary tree is: "+diameterOfBinaryTree(root));
    }
}