/*
L.C: 889. Construct Binary Tree from Preorder and Postorder Traversal

Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

If there exist multiple answers, you can return any of them.

Example 1:
Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]

Example 2:
Input: preorder = [1], postorder = [1]
Output: [1]
 
Constraints:
1 <= preorder.length <= 30
1 <= preorder[i] <= preorder.length
All the values of preorder are unique.
postorder.length == preorder.length
1 <= postorder[i] <= postorder.length
All the values of postorder are unique.
It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree. 
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ConstructBTFromPreAndPostOrder{
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
    public static Node constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(postorder[i],i);
        }
        return solve(0,0,n-1,preorder,postorder,map);
    }
    public static Node solve(int preStart,int postStart,int preEnd,int preorder[],
    int postorder[], Map<Integer,Integer> map){
        if(preStart> preEnd){
            return null;
        }
        Node root = new Node(preorder[preStart]);
        if(preStart == preEnd){
            return root;
        }
        int nextNode = preorder[preStart+1];
        int j = map.get(nextNode);
        int num = j-postStart+1;
        root.left = solve(preStart+1,postStart,preStart+num,preorder,postorder,map);
        root.right = solve(preStart+num+1,j+1,preEnd,preorder,postorder,map);
        return root;
    }
    public static void main(String[] args) {
        int preorder[] = {1,2,4,5,3,6,7};
        int postorder[] = {4,5,2,6,7,3,1};
        Node root = constructFromPrePost(preorder, postorder);
        printLevelOrder(root);
    }
}
