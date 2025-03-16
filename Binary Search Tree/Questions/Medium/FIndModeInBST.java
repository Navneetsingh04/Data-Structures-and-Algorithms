/*
L.C: 501. Find Mode in Binary Search Tree

Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 
Example 1:
Input: root = [1,null,2,2]
Output: [2]
Example 2:

Input: root = [0]
Output: [0]
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FIndModeInBST {
    static class TreeNode{
        int val;
        TreeNode left ,right;
        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }
    // Approach 1: Using hashMap 
    // T.C: O(n)
    // S.C: O(n)
    public static int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        traverse(root,map);

        int maxFreq = Collections.max(map.values());
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if (e.getValue() == maxFreq) {
                list.add(e.getKey());
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    public static void traverse(TreeNode root,Map<Integer,Integer> map){
        if(root == null) return;
        traverse(root.left,map);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        traverse(root.right,map);

    }

    // Approach 2: Morris traversal 
    // T.C: O(n)
    // S.C: O(1)


    // public static int[] findMode(TreeNode root) {
    //     int maxStreak = 0;
    //     int currStreak = 0;
    //     int currNum = 0;
    //     List<Integer> list = new ArrayList<>();

    //     TreeNode curr = root;
    //     while(curr != null){
    //         if(curr.left != null){
    //             TreeNode temp = curr.left;
    //         while(temp.right != null){
    //             temp = temp.right;
    //         }
    //         temp.right = curr;

    //         TreeNode left = curr.left;
    //         curr.left = null;
    //         curr = left;
    //         }
    //         else{
    //             if(curr.val == currNum){
    //                 currStreak++;
    //             }
    //             else{
    //                 currStreak = 1;
    //                 currNum = curr.val;
    //             }
    //             if(currStreak > maxStreak){
    //                 list = new ArrayList();
    //                 maxStreak = currStreak;
    //             }
    //             if(currStreak == maxStreak){
    //                 list.add(curr.val);
    //             }
    //             curr = curr.right;
    //         }
    //     }
    //     int ans[] = new int[list.size()];
    //     for(int i = 0;i<list.size();i++){
    //         ans[i] = list.get(i);
    //     }
    //     return ans;
    // }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(findMode(root)));
    }
}
