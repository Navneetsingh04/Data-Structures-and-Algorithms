import java.util.ArrayList;

public class PreorderTraversal {
    static class Node{
        int data;
        ArrayList<Node> children;

        Node(int data){
            this.data = data;
            children = new ArrayList<>();
        }
    }
    static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        for(Node child : root.children){
            preorder(child);
        }
    }
    public static void main(String[] args) {
        /*
          1
        / | \
       /  |  \
      2   3   4
     / \ /|\
    5  6 7 8 9 
        */
        Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
        root.children.get(1).children.add(new Node(7));
        root.children.get(1).children.add(new Node(8));
        root.children.get(1).children.add(new Node(9));

        preorder(root);
    }
}
