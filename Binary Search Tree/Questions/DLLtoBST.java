import java.util.LinkedList;
import java.util.Queue;
public class DLLtoBST {
    public static class Node{
        int data;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static Node head;
    public static Node convertDLLtoBST(int n){
        if(n <= 0){
            return null;
        }
        Node leftSubtree = convertDLLtoBST(n/2);
        Node root = head;
        root.left = leftSubtree;
        // Moving head to next Node
        head = head.right;
        root.right = convertDLLtoBST(n-n/2-1);
        return root;
    }
    public static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(temp.data+" ");
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
    }
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        first.right = second;
        second.left = first;
        second.right = third;
        third.left = second;

        head = first;
        Node root = convertDLLtoBST(3); 
        System.out.print("BST after coverting from DLL: ");
        levelOrderTraversal(root);
    }
}