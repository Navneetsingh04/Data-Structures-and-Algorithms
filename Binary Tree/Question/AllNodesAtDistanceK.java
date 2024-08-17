/*
L.C: 863. All Nodes Distance K in Binary Tree

Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

Example 2:
Input: root = [1], target = 1, k = 3
Output: []

Constraints:
The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000 
*/

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.ArrayList;

public class AllNodesAtDistanceK {
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
    public static void markParents(Node root,Map<Node,Node> parentTrack,Node target){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node current = q.poll();
            if(current.left != null){
                parentTrack.put(current.left,current);
                q.add(current.left);
            }
            if(current.right != null){
                parentTrack.put(current.right,current);
                q.add(current.right);
            }
        }
    }
    public static List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node ,Node> parentTrack = new HashMap<>();
        markParents(root,parentTrack,target);
        Map<Node,Boolean> visited = new HashMap<>();
        Queue<Node> queue  = new LinkedList<>();
        queue.add(target);
        visited.put(target,true);
        int currLevel = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            if(currLevel == k) break;
            currLevel++;
            for(int i = 0;i<size;i++){
                Node current = queue.poll();
                if(current.left != null && visited.get(current.left) == null){
                    queue.add(current.left);
                    visited.put(current.left,true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    queue.add(current.right);
                    visited.put(current.right,true);
                }
                if(parentTrack.get(current) != null && visited.get(parentTrack.get(current)) == null){
                    queue.add(parentTrack.get(current));
                    visited.put(parentTrack.get(current),true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            Node current = queue.poll();
            ans.add(current.data);
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        Node target = root.left;
        int k = 2;

        List<Integer> ans = distanceK(root, target, k);
        System.out.println(ans);
    }
}
