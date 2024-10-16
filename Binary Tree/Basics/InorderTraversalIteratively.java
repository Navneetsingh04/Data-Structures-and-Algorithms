/*
L.C: 94. Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversalIteratively {
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
    public static List<Integer> inorderTravesal(Node root){
        List<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node temp = root;
        while(true){
            if(temp != null){
                st.push(temp);
                temp = temp.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                temp = st.pop();
                list.add(temp.data);
                temp = temp.right;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> inorder = inorderTravesal(root);
        System.out.println(inorder);
    }
}
