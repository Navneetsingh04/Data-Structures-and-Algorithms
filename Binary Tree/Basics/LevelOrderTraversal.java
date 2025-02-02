import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.List;

public class LevelOrderTraversal {
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
    public static List<List<Integer>> levelOrderTraversal(Node root){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0;i<size;i++){
                Node front = q.poll();
                currLevel.add(front.data);
                if(front.left != null){
                    q.add(front.left);
                }
                if(front.right != null){
                    q.add(front.right);
                }
            }
            list.add(currLevel);
        }
        return list;
    }
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        Node root = createTree(s);
        System.out.print("Level Order Traversal: ");
        List<List<Integer>> list = levelOrderTraversal(root);
        levelOrderTraversal(root);
        System.out.println(list);
        s.close();   
    }
}
// 10 20 50 65 -1 -1 90 -1 -1 70 -1 -1 30 60 -1 -1 100 -1 -1