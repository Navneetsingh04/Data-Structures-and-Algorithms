class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
public class MirrorTree{
    Node root;
    public void mirror(Node root){
        if(root == null) return;

        mirror(root.left);
        mirror(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public void inorder(Node root){
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Original Tree (Inorder Traversal):");
        tree.inorder(tree.root);
        
        tree.mirror(tree.root);

        System.out.println("\nMirrored Tree (Inorder Traversal):");
        tree.inorder(tree.root);
    }
}