/*
L.C: 938. Range Sum of BST

Given the root node of a binary search tree and two integers low and high, return the sum of dataues of all nodes with a dataue in the inclusive range [low, high].

Example 1:
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

Example 2:

Input:root = [10,5,15,3,7,13,18,1,null,6],low = 6,high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

Constraints:

The number of nodes in the tree is in the range [1, 2 * 104].
1 <= Node.data <= 105
1 <= low <= high <= 105
All Node.data are unique.
 */


public class RangeSum {
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
    public static int rangeSumBST(Node root, int low, int high) {
        if(root == null) return 0;
        int sum = 0;
        if(root.data >= low && root.data <= high){
            sum += root.data;
        }
        if(root.data > low){
            sum += rangeSumBST(root.left,low,high);
        }
        if(root.data < high){
            sum += rangeSumBST(root.right,low,high);
        }
        return sum;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(18);
        int low = 7;
        int high = 15;
        int ans = rangeSumBST(root, low, high);
        System.out.println("The Range Sum is: "+ans);
    }
}
