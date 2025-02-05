
import java.util.ArrayList;
public class BoundaryTraversal {
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

    public static boolean isLeaf(Node root){
        return (root.left == null && root.right == null);
    }

    public static void addLeftBoundary(Node root, ArrayList<Integer> res){
        Node curr = root.left;
        while(curr != null){
            if(!isLeaf(curr)){
                res.add(curr.data);
            }
            if(curr.left != null){
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public static void addRightBoundary(Node root, ArrayList<Integer> res){
        ArrayList<Integer> temp = new ArrayList<>();
        Node curr = root.right;
        while(curr != null){
            if(!isLeaf(curr)){
                temp.add(curr.data);
            }
            if(curr.right != null){
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        // Add the right boundary nodes in reverse order
        for(int i = temp.size() - 1; i >= 0; i--){
            res.add(temp.get(i));
        }
    }

    public static void addLeaves(Node root, ArrayList<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left != null){
            addLeaves(root.left, res);
        }
        if(root.right != null){
            addLeaves(root.right, res);
        }
    }

    public static ArrayList<Integer> printBoundary(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        if(!isLeaf(root)){
            ans.add(root.data);
        }
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        ArrayList<Integer> ans = printBoundary(root);
        System.out.println(ans);
    }
}
