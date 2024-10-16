/*
L.C: 1008. Construct Binary Search Tree from Preorder 

Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases. 

Example 1:
Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Example 2:
Input: preorder = [1,3]
Output: [1,null,3]
 
Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 1000
All the values of preorder are unique.
*/

public class ConstructBSTfromPreorder {
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
    static int i = 0;
    public static Node build(int min,int max,int preorder[]){
        if(i >= preorder.length){
            return null;
        }
        Node root = null;
        if(preorder[i] > min && preorder[i] < max){
            root = new Node(preorder[i++]);
            root.left = build(min,root.data,preorder);
            root.right = build(root.data,max,preorder);
        }
        return root;
    }
    public static Node bstFromPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return build(min,max,preorder);
    }
    public static void printTree(Node root){
        if(root == null) return;
        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }
    public static void main(String[] args) {
        int preorder[] = {8,5,1,7,10,12};
        Node root = bstFromPreorder(preorder);
        System.out.print("Inorder Traversal for BST is: ");
        printTree(root);
    }
}
