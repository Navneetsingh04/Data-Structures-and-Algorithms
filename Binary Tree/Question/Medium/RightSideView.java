/*
L.C: 199. Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,null,3]
Output: [1,3]

Example 3:
Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100 
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
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

    // Approch 1: Using DFS 

    public static void rightViewDFS(Node root,List<Integer> ans,int currDepth){
        if(root == null) return;
        if(currDepth == ans.size()){
            ans.add(root.data);
        }
        rightViewDFS(root.right,ans,currDepth+1);
        rightViewDFS(root.left,ans,currDepth+1);
    }
    public static List<Integer> rightViewDFS(Node root){
        List<Integer> ans = new ArrayList<>();
        rightViewDFS(root,ans,0);
        return ans;
    }

    // Approch 2: Using BFS

    public static void rightViewBFS(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                Node curr = queue.poll();
                if(i == size-1){
                    list.add(curr.data);
                }
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        System.out.println(list);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> ans = rightViewDFS(root);
        System.out.println("Right side View DFS: "+ans);
        System.out.print("Right side View BFS: ");rightViewBFS(root);   
    }
}
 