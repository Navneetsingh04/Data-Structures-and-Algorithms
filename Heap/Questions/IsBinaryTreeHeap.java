/*
GFG: Is Binary root Heap

Given a binary root. The task is to check whether the given root follows the max heap property or not.
Note: Properties of a root to be a max heap - Completeness and Value of node greater than or equal to its child.

Example 1:

Input:
      5
    /  \
   2    3
Output: 1
Explanation: The given root follows max-heap property since 5,
is root and it is greater than both its children.

Example 2:

Input:
       10
     /   \
    20   30 
  /   \
 40   60
Output: 0

Constraints:
1 ≤ Number of nodes ≤ 100
1 ≤ Data of a node ≤ 1000 
*/
public class IsBinaryTreeHeap {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static int nodeCount(Node root){
        if(root == null) return 0;
        return 1+nodeCount(root.left)+nodeCount(root.right);
    }
    public static boolean isCBT(Node root,int i,int n){
        if(root == null) return true;
        if(i>n){
            return false;
        }
        return isCBT(root.left,2*i,n) && isCBT(root.right,2*i+1,n);
        
    }
    public static boolean isMaxOrder(Node root){
        if(root == null) return true;
        boolean left = isMaxOrder(root.left);
        boolean right = isMaxOrder(root.right);;
        boolean ans = false;
        if(root.left == null  && root.right == null){
            ans = true;
        }
        else if(root.left != null && root.right == null){
            ans = root.data > root.left.data;
        }
        else{
            ans = root.data > root.left.data && root.data > root.right.data;
        }
        return ans && left && right;
    }
    public static boolean isHeap(Node root){
        int n = nodeCount(root);
        int i = 1;
        return isCBT(root,i,n) && isMaxOrder(root);
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(40);
        root.right = new Node(45);
        root.left.left = new Node(30);
        root.left.right = new Node(35);

        Boolean ans = isHeap(root);
        if(ans){
            System.out.println("Given Binary tree is Heap");
        }
        else{
            System.out.println("Given Binary tree is not a heap");
        }
    }
}
