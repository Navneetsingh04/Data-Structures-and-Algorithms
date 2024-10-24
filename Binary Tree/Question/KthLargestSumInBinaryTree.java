/*
L.C: 2583. Kth Largest Sum in a Binary Tree
Solved
Medium
Topics
Companies
Hint
You are given the root of a binary tree and a positive integer k.

The level sum in the tree is the sum of the values of the nodes that are on the same level.
Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.
Note that two nodes are on the same level if they have the same distance from the root.

Example 1:
Input: root = [5,8,9,2,1,3,7,4,6], k = 2
Output: 13
Explanation: The level sums are the following:
- Level 1: 5.
- Level 2: 8 + 9 = 17.
- Level 3: 2 + 1 + 3 + 7 = 13.
- Level 4: 4 + 6 = 10.
The 2nd largest level sum is 13.
Example 2:


Input: root = [1,2,null,3], k = 1
Output: 3
Explanation: The largest level sum is 3.
 
Constraints:
The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= 106
1 <= k <= n 
*/
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
public class KthLargestSumInBinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val; 
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            pq.add(sum);
            if (pq.size() > k) {
                pq.poll(); 
            }
        }
        if (pq.size() < k) {
            return -1;
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);

        KthLargestSumInBinaryTree sol = new KthLargestSumInBinaryTree();
        int k = 2;
        System.out.println("Kth largest level sum: " + sol.kthLargestLevelSum(root, k));
    }
}
