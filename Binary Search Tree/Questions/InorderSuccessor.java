/*
Inorder Successor in BST

Given a BST, and a reference to a Node x in the BST. Find the Inorder Successor of the given node in the BST.
 
Example 1:
Input:
      2
    /   \
   1     3
K(data of x) = 2
Output: 3 
Explanation: 
Inorder traversal : 1 2 3 
Hence, inorder successor of 2 is 3.

Example 2:
Input:
             20
            /   \
           8     22
          / \
         4   12
            /  \
           10   14
K(data of x) = 8
Output: 10
Explanation:
Inorder traversal: 4 8 10 12 14 20 22
Hence, successor of 8 is 10. 
*/
// Time Complexity: O(H)
// space Complexity: O(1)

public class InorderSuccessor {
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
    public static Node inorderSuccessor(Node root,Node x){
        Node succ = null;
        Node curr = root;
        while(curr != null){
            if(curr.data > x.data){
                succ = curr;
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        return succ;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1);
        root.right.left = new Node(6);
        root.right.right = new Node(9);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(10);

        Node x = new Node(4);

        Node ans = inorderSuccessor(root, x);
        System.out.println("Successor of "+x.data+" is: "+ans.data);
    }
}
