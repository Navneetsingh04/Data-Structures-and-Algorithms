/*
Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
      / \
    2    3
   / \   / \
  4   5 6   7

Top view will be: 4 2 1 3 7 
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
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
        int row;
        Pair(Node node,int row){
            this.node = node;
            this.row = row;
        }
    }
    public static List<Integer> topView(Node root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair it = q.remove();
            int hd = it.row;
            Node temp = it.node;
            if(map.get(hd) == null) map.put(hd,temp.data);
            if(temp.left != null){
                q.add(new Pair(temp.left, hd-1));
            }
            if(temp.right != null){
                q.add(new Pair(temp.right, hd+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> ans = topView(root);
        System.out.println("Top View of Binary Tree is: "+ans);
    }
}
