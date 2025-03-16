/*
L.C: 235. Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).

Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [2,1], p = 2, q = 1
Output: 2

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST. 
*/
public class LCAofBST {
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
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null) return null;

        // case 1: when p and q comes in left subtree
        if(p.data < root.data && q.data < root.data){
            Node leftAns = lowestCommonAncestor(root.left,p,q);
            return leftAns;
        }
        // case 2: when p and q comes in right subtree
        if(p.data > root.data && q.data > root.data){
            Node rightAns = lowestCommonAncestor(root.right,p,q);
            return rightAns;
        }
        // // case 3: when p is in left subtree and q in right subtree
        // if(p.data < root.data && q.data > root.data){
        //     return root;
        // }
        // // case 5: when p is in right subtree and q in left subtree
        // if(p.data > root.data && q.data < root.data){
        //     return root;
        // }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(50);
        root.right = new Node(200);
        root.left.left = new Node(30);
        root.left.right = new Node(70);
        root.right.left = new Node(120);
        root.right.right = new Node(300);
        Node p = new Node(30);
        Node q = new Node(70);
        Node ans = lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common ancestor of "+p.data+" and "+q.data +" is "+ans.data);

    }
}
