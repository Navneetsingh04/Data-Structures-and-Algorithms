/*
L.C: 113. Path Sum II

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: []

Example 3:
Input: root = [1,2], targetSum = 0
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
*/

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
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
    public static void solve(Node root,int targetSum,List<List<Integer>> ans,List<Integer> temp,int sum){
        if(root == null){
            return;
        }
        sum += root.data;
        temp.add(root.data);
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                ans.add(new ArrayList<>(temp));
            }
        }
        else{
            solve(root.left, targetSum, ans, temp, sum);
            solve(root.right, targetSum, ans, temp, sum);
        }
        temp.remove(temp.size()-1);

    }
    public static List<List<Integer>> pathSum(Node root,int targetSum){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        solve(root,targetSum,ans,temp,sum);
        return ans;
    }
    public static void main(String[] args) {
        int targetSum = 24;
        Node root = new Node(2);
        root.left = new Node(4);
        root.right = new Node(16);
        root.left.left = new Node(8);
        root.left.right = new Node(6);
        root.left.left.left = new Node(10);
        root.left.right.left = new Node(1);
        root.left.right.left.left = new Node(12);
        root.right.left = new Node(3);
        root.right.right = new Node(1);
        root.right.left.right = new Node(3);
        root.right.right.right = new Node(2);
        root.right.right.right.right = new Node(3);
        List<List<Integer>> ans = pathSum(root, targetSum);
        System.out.println(ans);
    }
}
