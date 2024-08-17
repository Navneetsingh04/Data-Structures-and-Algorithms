/*
Print Root to Node Path in a Binary Tree

Problem Statement: Given a Binary Tree and a reference to a root belonging to it. Return the path from the root node to the given leaf node.

No two nodes in the tree have the same data value.
It is assured that the given node is present and a path always exists.
Examples

Example 1:
Input:Binary Tree: 1 2 3 4 5 -1 -1 -1 -1, Node: 7
Output:[1, 2, 5, 7]

 
*/

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
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
    public static boolean getPath(Node root,List<Integer> ans,int t){
        if(root == null){
            return false;
        }
        ans.add(root.data);
        if(root.data == t){
            return true;
        }
        // Recursively search for the target value
        // t in the left and right subtrees
        if(getPath(root.left, ans, t) || getPath(root.right, ans, t)){
            return true;
        }
        // If the target value t is not found
        // in the current path, backtrack
        ans.remove(ans.size()-1);
        return false;
    }
    public static List<Integer> nodePath(Node root,int t){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        getPath(root,ans,t);
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);

        int targetleaf = 7;
        List<Integer> ans = nodePath(root, targetleaf);
        System.out.print("Path from root Node to "+targetleaf+" : ");

        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i));
            if(i<ans.size()-1){
                System.out.print(" -> ");
            }
        }
    }
}
