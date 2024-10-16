/*
GFG: Flatten BST to sorted list

You are given a Binary Search Tree (BST) with n nodes, each node has a distinct value assigned to it. The goal is to flatten the tree such that, the left child of each element points to nothing (NULL), and the right child points to the next element in the sorted list of elements of the BST.

Note: If your BST does have a left child, then the system will print a -1 and will skip it, resulting in an incorrect solution.

Example 1:

Input:
          5
        /    \
       3      7
      /  \    /   \
     2   4  6     8
Output: 2 3 4 5 6 7 8
Explanation: 
After flattening, the tree looks
like this
    2
     \
      3
       \
        4
         \
          5
           \
            6
             \
              7
               \
                8
Here, left of each node points
to NULL and right contains the
next node.
Example 2:

Input:
       5
        \
         8
       /   \
      7     9  
Output: 5 7 8 9
Explanation:
After flattening, the tree looks like this:
   5
    \
     7
      \
       8
        \
         9
Constraints:
1 <= Number of nodes <= 103
1 <= Data of a node <= 105 
*/

// import java.util.ArrayList;
// import java.util.List;

public class FlattenBSTtoSortedLL {
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

    // 1st Approach: Recreating BST from inorder
    // Time Complexity: O(N)
    // Space Complexity: O(N)

    // public static void inorder(Node root,List<Node> list){
    //     if(root == null){
    //         return;
    //     }
    //     inorder(root.left, list);
    //     list.add(root);
    //     inorder(root.right, list);
    // }
    // public static Node flattenBSTtoLL(Node root){
    //     if(root == null){
    //         return null;
    //     }
    //     List<Node> list = new ArrayList<>();
    //     inorder(root,list);
    //     Node newRoot = list.get(0);
    //     Node curr = newRoot;
    //     for(int i= 0;i<list.size();i++){
    //         curr.left = null;
    //         curr.right = list.get(i);
    //         curr = curr.right;
    //     }
    //     // Ensuring the last node pointers are null
    //     curr.left = null;
    //     curr.right = null;
    //     return newRoot;
    // }

    // 2nd Approach:  
    // Time Complexity: O(N)
    // Space Complexity: O(H)

    public static Node inorder(Node root,Node prev){
        if(root == null){
            return prev;
        }
        // flatten the left subtree and update prev
        prev = inorder(root.left,prev);
        prev.left = null;
        prev.right = root;
        prev = root;
        // flatten the right subtree and update prev
        return inorder(root.right,prev);
    }
    public static Node flattenBSTtoLL(Node root){
        Node dummyNode = new Node(-1);
        Node prev = dummyNode;
        prev = inorder(root,prev);
        // Ensuring the last node pointers are null
        prev.left = prev.right = null;
        return dummyNode.right;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.right;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        Node head = flattenBSTtoLL(root);
        System.out.print("Sorted Linked List form BST: ");
        printLL(head);

    }
}