// import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelwiseTraversal {
    static class Node{
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
    public static void levelOrderTraversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(q.size() > 1){
            Node front = q.peek();
            q.poll();
            if(front == null){
                System.out.println();
                q.add(null);
            }
            else{
                // valid case
                System.out.print(front.data+" ");
                if(front.left != null){
                    q.add(front.left);
                }
                if(front.right != null){
                    q.add(front.right);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        Node root = createTree(s);
        System.out.println("Level Order Traversal: ");
        levelOrderTraversal(root);
        s.close();   
    }
}
// Input: 10 20 50 65 -1 -1 90 -1 -1 70 -1 -1 30 60 -1 -1  100 -1 -1