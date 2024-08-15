/*
L.C: 101. Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false
 
Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 */
public class SymmetricTree {
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
    public static boolean isSymmetricHelpher(Node left,Node right){
        if(left == null || right == null){
            return left == right;
        } 
        if(left.data != right.data){
            return false;
        }
        return isSymmetricHelpher(left.left, right.right) && isSymmetricHelpher(left.right, right.left);

    }
    public static boolean isSymmetric(Node root){
        return root == null || isSymmetricHelpher(root.left,root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println("isSymmetric: "+isSymmetric(root));
    
    }
}
