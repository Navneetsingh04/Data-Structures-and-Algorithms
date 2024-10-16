/*
Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

          20
         / \
        8   22
      /  \    \
     5    3   25
        / \      
       10  14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

        20
        / \
       8   22
      / \  / \
     5   3 4  25
        / \      
      10   14

For the above tree the output should be 5 10 4 14 25. 
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
    static class Node {
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
        int row;

        Pair(Node node,int row){
            this.node = node;
            this.row = row;
        }
    }
    public static List<Integer> bottomView(Node root){
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        if(root == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair it = q.remove();
            int hd = it.row;
            Node temp = it.node;
            map.put(hd, temp.data);
            if(temp.left != null){
                q.add(new Pair(temp.left, hd-1));
            }
            if(temp.right != null){
                q.add(new Pair(temp.right, hd+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(4);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.left = new Node(4);
        root.right.right = new Node(25);

        List<Integer> ans = bottomView(root);
        System.out.println(ans);
    }
}
