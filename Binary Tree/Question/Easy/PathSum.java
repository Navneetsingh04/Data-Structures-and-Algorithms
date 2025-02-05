/*
L.C: 112. Path Sum

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.
Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
*/

public class PathSum {
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
    public static boolean solve(Node root,int targetSum,int sum){
        if(root == null){
            return false;
        }
        sum += root.data;
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                return true;
            }
            else{
                return false;
            }
        }
        boolean leftAns = solve(root.left, targetSum, sum);
        boolean rightAns = solve(root.right, targetSum, sum);
        return leftAns||rightAns;
    }
    public static boolean hasPathSum(Node root, int targetSum) {
        int sum = 0;
        boolean ans = solve(root,targetSum,sum);
        return ans;
    }
    public static void main(String[] args) {
        int targetSum = 22;
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.left = new Node(1);

        System.out.println(hasPathSum(root, targetSum));
    }
}
