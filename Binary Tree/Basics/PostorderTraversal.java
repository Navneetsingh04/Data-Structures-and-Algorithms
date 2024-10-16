import java.util.Scanner;
public class PostorderTraversal {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static Node createTree(Scanner s){
        System.out.print("Enter the value for node: ");
        int data = s.nextInt();
        if(data == -1){
            return null;
        }
        Node root = new Node(data);
        root.left = createTree(s);
        root.right = createTree(s);
        return root;
    }
    public static void postorderTraversal(Node root){
        if(root == null){
            return;
        }
       postorderTraversal(root.left);
       postorderTraversal(root.right);
       System.out.print(root.data+"->");
    }
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        Node root = createTree(s);
        System.out.print("Postorder Traversal: ");
        postorderTraversal(root);
        s.close();   
    }
}