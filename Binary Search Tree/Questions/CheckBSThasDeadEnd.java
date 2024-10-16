/*
GFG : Check whether BST contains Dead End

Given a Binary Search Tree that contains unique positive integer values greater than 0. The task is to complete the function isDeadEnd which returns true if the BST contains a dead end else returns false. Here Dead End means a leaf node, at which no other node can be inserted.

Example 1:

Input :   
               8
             /   \ 
           5      9
         /  \     
        2    7 
       /
      1     
          
Output : 
Yes
Explanation : 
Node 1 is a Dead End in the given BST.
Example 2:

Input :     
              8
            /   \ 
           7     10
         /      /   \
        2      9     13

Output : 
Yes
Explanation : 
Node 9 is a Dead End in the given BST.

Constraints:
1 <= N <= 1001
1 <= Value of Nodes <= 10001 
*/

import java.util.HashMap;
import java.util.Map;

public class CheckBSThasDeadEnd {
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
    public static void findAllNode(Node root,Map<Integer,Boolean> visited){
        if(root == null){
            return;
        }
        visited.put(root.data,true);
        findAllNode(root.left,visited);
        findAllNode(root.right,visited);
    }
    public static boolean checkDeadEnd(Node root,Map<Integer,Boolean> visited){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            int pre = root.data-1;
            int next = root.data+1;
            if(visited.containsKey(pre) && visited.containsKey(next)){
                return true;
            }
        }
        return checkDeadEnd(root.left, visited) || checkDeadEnd(root.right, visited);
    }
    public static boolean isDeadEnd(Node root){
        Map<Integer,Boolean> visited = new HashMap<>();
        // Adding 0 to handle where 1 is a node and only node
        visited.put(0,true);
        findAllNode(root, visited);
        return checkDeadEnd(root, visited);
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(9);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.left.left.left = new Node(1);

        boolean ans = isDeadEnd(root);
        System.out.println(ans?"yes":"No");
    }
}