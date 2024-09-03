import java.util.Queue;
import java.util.LinkedList;

public class BSTFromInorder {
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
    public static Node createBSTFromInorder(int inorder[],int start,int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        int element = inorder[mid];
        Node root = new Node(element);

        root.left = createBSTFromInorder(inorder,start,mid-1);
        root.right = createBSTFromInorder(inorder,mid+1,end);

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
        int inorder[] = {10,20,30,40,50,60,70};
        int start = 0;
        int end = inorder.length-1;
        Node root = createBSTFromInorder(inorder, start, end);
        System.out.print("Level Order Travresal of Created BST: ");
        printLevelOrder(root);
    }    
}