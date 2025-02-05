/*
L.C: 100. Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false
 
Constraints:
The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
*/
public class SameTee {
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
    public static boolean isSameTree(Node p,Node q){
        if(p == null || q == null){
            return (p==q);
        }
        return (p.data == q.data) && isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String args[]){
        Node p = new Node(1);
        p.left = new Node(2);
        p.right = new Node(3);
        p.right.left = new Node(4);
        p.right.right = new Node(5);

        Node q = new Node(1);
        q.left = new Node(2);
        q.right = new Node(3);
        q.right.left = new Node(4);
        q.right.right = new Node(5);

        System.out.println(isSameTree(p, q));
        
    }
}
