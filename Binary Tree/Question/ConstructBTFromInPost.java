/*
L.C:  106. Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
public class ConstructBTFromInPost {
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
    public static Node buildTreePostIn(int inorder[],int instart,int inend,
    int postorder[],int poststart,int postend,HashMap<Integer,Integer> map){
        if(poststart>postend || instart>inend){
            return null;
        }
        Node root = new Node(postorder[postend]);
        int inRoot = map.get(postorder[postend]);
        int numsLeft = inRoot-instart;
        root.left = buildTreePostIn(inorder, instart, inRoot-1, postorder,
        poststart, poststart+numsLeft-1, map);
        root.right = buildTreePostIn(inorder, inRoot+1, inend, postorder,
        numsLeft+poststart, postend-1, map);
        return root;
    }
    public static Node buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }
    public static void printLevelOrder(Node root){
        if(root == null) return;
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
        int inorder[] = {40,20,50,10,60,30};
        int postorder[] = {40,50,20,60,30,10};

        Node root = buildTree(inorder, postorder);
        System.out.println("Level order traversal of the constructed tree:");
        printLevelOrder(root);
    }
}
