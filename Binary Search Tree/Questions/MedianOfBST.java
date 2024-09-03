/*
GFG: Median of BST
Given a Binary Search Tree of size N, find the Median of its Node values.

Example 1:

Input:
       6
     /   \
   3      8   
 /  \    /  \
1    4  7    9
Output: 6
Explanation: Inorder of Given BST will be:
1, 3, 4, 6, 7, 8, 9. So, here median will 6.

Example 2:

Input:
       6
     /   \
   3      8   
 /   \    /   
1    4   7   
Output: 5
Explanation:Inorder of Given BST will be:
1, 3, 4, 6, 7, 8. So, here median will
(4 + 6)/2 = 10/2 = 5.
 
Median of the BST is:

If number of nodes are even: then median = (N/2 th node + (N/2)+1 th node)/2
If number of nodes are odd : then median = (N+1)/2th node.

Constraints: 
1<=N<=10000
 */

// Using Recurssion and list to store the nodes
// Time Compexity: O(n)
// Space Compexity: O(n)
import java.util.ArrayList;
import java.util.List;

public class MedianOfBST {
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
    public static void inorder(Node root,List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);

    }
    public static int medianOfBST(Node root){
        int median = 0;
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int size = list.size();
        if((size&1) == 1){
            median = list.get(size/2);
        }
        else{
            int mid1 = list.get(size/2-1);
            int mid2 = list.get(size/2);
            median = (mid1+mid2)/2;
        }
        return median;
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        // root.right.right = new Node(9);
        int ans = medianOfBST(root);
        System.out.println("Median of the BST is: "+ans);
    }
}
