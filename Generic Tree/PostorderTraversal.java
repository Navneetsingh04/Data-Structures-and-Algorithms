/*
L.C: 590. N-ary Tree Postorder Traversal

Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]

Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 
Constraints:
The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The height of the n-ary tree is less than or equal to 1000. 
*/
public class PostorderTraversal {
    static class Node{
        int data;
        Node children[];

        Node(int n,int data){
            this.data = data;
            children = new Node[n];
        }
    }
    static void postorder(Node root){
        if(root == null) return;
        // Visiting the root node after all children
        for(Node child : root.children){
            postorder(child);
        }
        // Visiting  the root node after all children
        System.out.print(root.data+" ");
    }
    public static void main(String[] args) {
        int n = 3;
        Node root = new Node(n,1);
        root.children[0] = new Node(n,3);
        root.children[1] = new Node(n,2);
        root.children[2] = new Node(n,4);
        root.children[0].children[0] = new Node(n,5);
        root.children[0].children[1] = new Node(n,6);
       System.out.println("PostOrder Traversa; of N-array Tree: ");
        postorder(root);
    }
}
