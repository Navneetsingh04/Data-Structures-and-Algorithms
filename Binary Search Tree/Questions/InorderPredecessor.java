public class InorderPredecessor {
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
    public static Node inorderPredecessor(Node root,Node x){
        Node prec = null;
        Node curr = root;
        while(curr != null){
            if(curr.data < x.data){
                prec = curr;
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        return prec;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1);
        root.right.left = new Node(6);
        root.right.right = new Node(9);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(10);

        Node x = new Node(4);
        Node ans = inorderPredecessor(root, x);
        System.out.println("Predecessor of "+x.data+" is: "+ans.data);
    }
}
