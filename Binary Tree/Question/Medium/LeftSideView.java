
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeftSideView {
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
    // Using DFS
    public static void leftView(Node root,List<Integer> ans,int currDepth){
        if(root == null) return;
        if(currDepth == ans.size()){
            ans.add(root.data);
        }
        leftView(root.left,ans,currDepth+1);
        leftView(root.right,ans,currDepth+1);
    }
    public static List<Integer> leftView(Node root){
        List<Integer> ans = new ArrayList<>();
        leftView(root,ans,0);
        return ans;
    }
    // Using BFS 
    public static List<Integer> leftViewBFS(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i= 0;i<size;i++){
                Node curr = queue.poll();
                if(i == 0){
                    list.add(curr.data);
                }
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> ans = leftView(root);
        System.out.println("Left side View DFS: "+ans);
        System.out.println("Left side View BFS: "+leftViewBFS(root));
    }
}

