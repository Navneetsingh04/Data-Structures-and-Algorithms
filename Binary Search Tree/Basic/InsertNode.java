import java.util.LinkedList;
import java.util.Queue;
// import java.util.Scanner;

public class InsertNode {
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

    // function for userInput

    // public static Node createBST(Node root){
    //     System.out.print("Enter data: ");
    //     Scanner s = new Scanner(System.in);
    //     int data = s.nextInt();
    //     while(data != -1){
    //         System.out.print("Enter data: ");
    //         root = insertIntoBST(root,data);
    //         data = s.nextInt();
    //     }
    //     s.close();
    //     return root;
    // }
    public static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp == null){
                System.out.println();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            else{
                System.out.print(temp.data+" ");
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            } 
        }
    }
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = null;
        // root = createBST(root);

        // Creating the following BST
        //      50
        //     /  \
        //    30   70
        //   / \   / \
        //  20 40 60 80

        root = insertIntoBST(root, 50);
        root = insertIntoBST(root, 30);
        root = insertIntoBST(root, 20);
        root = insertIntoBST(root, 40);
        root = insertIntoBST(root, 70);
        root = insertIntoBST(root, 60);
        root = insertIntoBST(root, 80);
        System.out.println("Level order Travresal of BST: ");
        levelOrderTraversal(root);
        System.out.print("Inorder Travresal of BST: ");
        inorder(root);
    }
}