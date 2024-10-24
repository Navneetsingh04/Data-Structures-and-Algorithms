import java.util.Scanner;
public class ImplementBinaryTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // it return root node of created Tree
    Node createTree(Scanner s){
        System.out.print("Enter the value for Node : ");
        int data = s.nextInt();
        if(data == -1){
            return null;
        }
        // create node
        Node root = new Node(data);
        // create left subtree
        System.out.println("Enter left child of "+data);
        root.left = createTree(s);
        // create right subtree
        System.out.println("Enter right child of "+data);
        root.right = createTree(s);
        return root;  
    }
    public static void main(String[] args) {
        ImplementBinaryTree tree = new ImplementBinaryTree();
        Scanner s = new Scanner(System.in);
        Node root = tree.createTree(s);
        if(root != null){
            System.out.println("Root node value: " +root.data);
        }
        else{
            System.out.println("The tree is empty");
        }
        s.close();   
    }
}
//       10
//       /\
//     20  30
//     /\  /\
//   40 50 x 60
//   /\  /\   /\
//  x  x x x  x x