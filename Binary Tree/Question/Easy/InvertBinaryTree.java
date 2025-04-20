class Node{
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}
public class InvertBinaryTree {
    public Node invertTree(Node root) {
        if(root == null) return root;
        Node temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public static void printTree(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }
    public static void main(String[] args) {
        InvertBinaryTree tree = new InvertBinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.print("Original Binary Tree: ");
        printTree(root);
        System.out.println();
        System.out.print("Inverted Binary Tree: ");
        tree.invertTree(root);
        printTree(root);
    }
}
