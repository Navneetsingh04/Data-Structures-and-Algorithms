/*
L.C: 105. Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 
Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree. 
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructBTFromPreIn {
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
    public static Node buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        Node root = buildTreePreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public static Node buildTreePreIn(int preorder[], int preStart, int preEnd, int inorder[], int inStart, int inEnd, HashMap<Integer,Integer> map){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        Node root = new Node(preorder[preStart]);
        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = buildTreePreIn(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);
        root.right = buildTreePreIn(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);

        return root;
    }
    public static void printLevelOrder(Node root){
        if(root == null){
            return;
        }
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
        int preorder[] = {3,9,20,15,7};
        int inorder[] = {9,3,15,20,7};

        Node root = buildTree(preorder,inorder);
        System.out.print("Level order traversal of the constructed tree: ");
        printLevelOrder(root);
    }
}
