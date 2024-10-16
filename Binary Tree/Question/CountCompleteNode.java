/*
L.C: 222. Count Complete Tree Nodes

Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

Example 1:

Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1

Constraints:

The number of nodes in the tree is in the range [0, 5 * 104].
0 <= Node.val <= 5 * 104
The tree is guaranteed to be complete.
*/
public class CountCompleteNode {
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
    // public static int  countNodes(Node root){
    //     if(root == null){
    //         return 0;
    //     }
    //     return countNodes(root.left)+countNodes(root.right)+1;
    // }
    public static int countNodes(Node root) {
        if(root == null){
            return 0;
        }
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        if(left == right){
            return ((2<<(left))-1);
        }
        else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }
    public static int getLeftHeight(Node root){
        int count = 0;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }
    public static int getRightHeight(Node root){
        int count = 0;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println("Number of node in tree is "+countNodes(root));
    }
}
