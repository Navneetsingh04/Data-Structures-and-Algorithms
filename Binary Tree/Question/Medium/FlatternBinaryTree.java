/*
114. Flatten Binary Tree to Linked List

Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 
Example 1:
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [0]
Output: [0]
 
Constraints:
The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 */

// import java.util.Stack;

public class FlatternBinaryTree {
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
    /* 
    1st Appraoch: Itrative
    Time complexity : O(N);
    Space complexity : O(N);
    */

    // public static void flatten(Node root){
    //     if(root == null) return;
    //     Stack<Node> st = new Stack<>();
    //     st.push(root);
    //     while(!st.isEmpty()){
    //         Node curr = st.pop();
    //         if(curr.right != null){
    //             st.push(curr.right);
    //         }
    //         if(curr.left != null){
    //             st.push(curr.left);
    //         }
    //         if(!st.isEmpty()){
    //             curr.right = st.peek();
    //         }
    //         curr.left = null;
    //     }
    // }

    /* 
    2nd Appraoch: Recurrsive
    Time complexity : O(N);
    Space complexity : O(N);
    */

    // static Node prev = null;
    // public static void flatten(Node root){
    //     if(root == null) return;
    //     flatten(root.right);
    //     flatten(root.left);
    //     root.right = prev;
    //     root.left = null;
    //     prev = root;
    // }

    /* 
    3rd Appraoch: Using Morris Traversal
    Time complexity : O(N);
    Space complexity : O(1);
    */

    public static void flatten(Node root){
        Node curr = root;
        while(curr != null){
            if(curr.left != null){
                Node prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left; 
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        flatten(root);

        System.out.print("Root after flattening: ");
        while(root != null){
            System.out.print(root.data+" ");
            root = root.right;
        }
    }
}