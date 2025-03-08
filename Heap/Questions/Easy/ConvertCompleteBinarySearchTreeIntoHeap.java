import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConvertCompleteBinarySearchTreeIntoHeap {
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
    public static void inorder(Node root,List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    static int index = 0;
    public static void repalceUsingPostOrder(Node root,List<Integer> list){
        if(root == null) return;
        repalceUsingPostOrder(root.left, list);
        repalceUsingPostOrder(root.right, list);
        root.data = list.get(index);
        index++;
    }
    public static Node convertIntoMaxHeap(Node root){
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        // repalcing the Node value with sorted inorder values using postorder traversal
        repalceUsingPostOrder(root,list);
        return root;
    }
    public static void printLevelOrder(Node root){
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
        Node root = new Node(100);
        root.left = new Node(50);
        root.right = new Node(150);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right.left = new Node(110);
        root.right.right = new Node(200);
        root.left.left.left = new Node(20);
        System.out.print("Tree Before Converting to Heap: ");
        printLevelOrder(root);
        root = convertIntoMaxHeap(root);
        System.out.print("\nPrinting Heap: ");
        printLevelOrder(root);
    }
}
