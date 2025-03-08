/*
L.C: 129. Sum Root to Leaf Numbers

You are given the root of a binary tree containing digits from 0 to 9 only.
Each root-to-leaf path in the tree represents a number.
For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.
Example 1:
Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:
Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 
Constraints:
The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 9
The depth of the tree will not exceed 10. 
*/
import java.util.ArrayDeque;
import java.util.Queue;

public class SumRootToLeafNumbers  {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    // Approach 1: Recursive Approach
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    static int sum = 0;
    public static void leafSum(TreeNode root,int currSum){
        if(root == null) return;
        currSum = currSum*10+root.data;
        if(root.left == null && root.right == null){
            sum += currSum;
        }
        leafSum(root.left,currSum);
        leafSum(root.right,currSum);
    }
    // Approach 1: Itrative using bfs
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static void bfs(TreeNode root){
        int sum = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> currSum = new ArrayDeque<>();
        queue.add(root);
        currSum.add(root.data);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int currentSum = currSum.poll();
            if(curr.left == null && curr.right == null){
                sum = sum+currentSum;
            }
            if(curr.left != null){
                queue.add(curr.left);
                currSum.add(currentSum*10+curr.left.data);
            }
            if(curr.right != null){
                queue.add(curr.right);
                currSum.add(currentSum*10+curr.right.data);
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        leafSum(root, 0);
        System.out.println(sum);
        bfs(root);
    }
}
