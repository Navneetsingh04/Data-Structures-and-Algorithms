/*
L.C: 993. Cousins in Binary Tree

Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
Two nodes of a binary tree are cousins if they have the same depth with different parents.
Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 
Constraints:
The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.
*/
public class CousinsInBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    Node parentX = null;
    Node parentY = null;
    int levelX = -1, levelY = -1;

    // DFS Soluion 
    // T.C: O(n)
    // T.C: O(h)

    public boolean isCousinsDFS(Node root, int x, int y) {
        if (root == null) return false;
        findParentLevel(root, null, x, y, 0);
        return (parentX != parentY && levelX == levelY);
    }
    public void findParentLevel(Node root, Node parent, int x, int y, int level) {
        if (root == null)
            return;
        if (root.data == x) {
            parentX = parent;
            levelX = level;
        }
        if (root.data == y) {
            parentY = parent;
            levelY = level;
        }
        findParentLevel(root.left, root, x, y, level + 1);
        findParentLevel(root.right, root, x, y, level + 1);
    }
    public static void main(String[] args) {
        CousinsInBinaryTree obj = new CousinsInBinaryTree();
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(2);
        root.left.right = new Node(40);
        root.right.right = new Node(4);
        root.left.right.left = new Node(7);
        root.right.right.left = new Node(5);
        int x = 40, y = 4;
        System.out.println(obj.isCousinsDFS(root, x, y));
    }
}