/*
L.C: 450. Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 

Example 1:
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:
Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.

Example 3:
Input: root = [], key = 0
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105
*/

// Time Complexity: O(H)

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNodeFromBST {
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
    public static Node insertIntoBST(Node root,int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data > root.data){
            root.right = insertIntoBST(root.right, data);
        }
        else{
            root.left = insertIntoBST(root.left, data);
        }
        return root;
    }
    public static Node maxValue(Node root){
        if(root == null) return null;
        Node temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }
    public static Node deleteNode(Node root,int target){
        if(root == null) return null;
        if(root.data == target){
            // case 1
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2
            else if(root.left != null && root.right == null){
                return root.left;
            }
            // case 3
            else if(root.left == null && root.right != null){
                return root.right;
            }
            // case 4 : root.left != null && root.right != null
            else{
                // Maximum value from left Subtree
                Node maxi = maxValue(root.left);
                // replacement
                root.data = maxi.data;
                // delete actual maximum Node
                root.left = deleteNode(root.left, maxi.data);
                return root;
            }
        }
        else if(root.data > target){
            // Search in the left subtree
           root.left =  deleteNode(root.left, target);
        }
        else{
            // Search in the right subtree
            root.right = deleteNode(root.right, target);
        }
        return root;
    }
    public static void printLevelOrder(Node root){
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
        Node root  = new Node(100);
        root.left = new Node(50);
        root.right = new Node(200);
        root.left.left = new Node(30);
        root.left.right = new Node(90);
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(95);
        root.right.right = new Node(300);
        root.right.right.right = new Node(400);
        int target = 50;

        System.out.print("Tree Before Deletion: ");
        printLevelOrder(root);
        Node ans = deleteNode(root, target);
        System.out.println();
        System.out.print("Tree After Deletion of Node "+target+" is: ");
        printLevelOrder(ans);
    }
}
