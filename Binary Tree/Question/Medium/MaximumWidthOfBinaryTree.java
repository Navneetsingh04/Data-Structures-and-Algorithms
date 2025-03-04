/*
L.C: 662. Maximum Width of Binary Tree

Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

Example 1:
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

Example 2:
Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).

Example 3:
Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).
 
Constraints:
The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100 
*/
import java.util.LinkedList;
import java.util.Queue;
public class MaximumWidthOfBinaryTree {
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
    static class Pair{
        Node node;
        int num;
        Pair(Node node,int num){
            this.node = node;
            this.num = num;
        }
    }
    public static int widthOfBinaryTree(Node root){
        if(root == null) return 0;
         int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            // to make id starting from zero
            // int mmin = q.peek().num;
            int first = 0;
            int last = 0;
            for(int i = 0;i<size;i++){
                int curr_id = q.peek().num;
                Node node = q.peek().node;
                q.poll();
                if(i == 0){
                    first = curr_id;
                }
                if(i == size-1){
                    last = curr_id;
                }
                if(node.left != null){
                    q.add(new Pair(node.left,curr_id*2+1));
                }
                if(node.right != null){
                    q.add(new Pair(node.right,curr_id*2+2));
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.right.right = new Node(4);

        int ans = widthOfBinaryTree(root);
        System.out.println("Maximum width of the Binary tree is: "+ans);
    }
}