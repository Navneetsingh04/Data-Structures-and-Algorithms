import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderUsingSingleStack {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static List<Integer> postorderTraversal(Node root) {
        Stack<Node> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Node curr = root;

        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } 
            else {
                Node temp = st.peek().right;
                if (temp == null) {
                    temp = st.pop();
                    list.add(temp.data);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        list.add(temp.data);
                    }
                }
                else {
                    curr = temp; 
                }
            }
        }
        return list;
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);
        root.right.left.right.right = new Node(8);

        List<Integer> ans = postorderTraversal(root);
        System.out.println("Postorder Traversal: " + ans);
    }
}
