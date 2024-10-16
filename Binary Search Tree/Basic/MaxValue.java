public class MaxValue {
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
        // if it is not first node
        if(data > root.data){
            root.right = insertIntoBST(root.right, data);
        }
        else{
            root.left = insertIntoBST(root.left, data);
        }
        return root;
    }
    public static int maximumValue(Node root){
        if(root == null){
            return 0;
        }
        Node temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp.data;
    }
    public static void main(String[] args) {
        Node root = null;
        root = insertIntoBST(root, 50);
        root = insertIntoBST(root, 30);
        root = insertIntoBST(root, 90);
        root = insertIntoBST(root, 40);
        root = insertIntoBST(root, 70);
        root = insertIntoBST(root, 60);
        root = insertIntoBST(root, 80);
        int ans = maximumValue(root);
        System.out.println("Maximum Node value in the BST is: "+ans);

    }
}