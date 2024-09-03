public class MinValue {
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
    public static Node insertIntoBST(Node root,int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data > root.data){
            root.right = insertIntoBST(root.right, data);
        }
        else{
            root.left = insertIntoBST(root.left, data);
        }
        return root;
    }
    public static int minimumValue(Node root){
        if(root == null){
            return 0;
        }
        Node temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp.data;
    }
    public static void main(String[] args) {
        Node root = null;
        root = insertIntoBST(root, 50);
        root = insertIntoBST(root, 10);
        root = insertIntoBST(root, 90);
        root = insertIntoBST(root, 40);
        root = insertIntoBST(root, 70);
        root = insertIntoBST(root, 60);
        root = insertIntoBST(root, 80);
        int ans = minimumValue(root);
        System.out.println("Minimum Node value in the BST is: "+ans);

    }
}