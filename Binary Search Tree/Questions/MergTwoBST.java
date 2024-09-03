/*
GFG: Merge two BST 's

Given two BSTs, return elements of merged BSTs in sorted form.

Examples :

Input:
BST1:
       5
     /   \
    3     6
   / \
  2   4  
BST2:
        2
      /   \
     1     3
            \
             7
            /
           6
Output: 1 2 2 3 3 4 5 6 6 7
Explanation: After merging and sorting the two BST we get 1 2 2 3 3 4 5 6 6 7.
Input:
BST1:
       12
     /   
    9
   / \    
  6   11
BST2:
      8
    /  \
   5    10
  /
 2
Output: 2 5 6 8 9 10 11 12
Explanation: After merging and sorting the two BST we get 2 5 6 8 9 10 11 12.

Constraints:
1 ≤ Number of Nodes ≤ 105 
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergTwoBST {
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
    public static List<Integer> mergTwoBST(Node root1,Node root2){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> sa = new Stack<>();
        Stack<Node> sb = new Stack<>();
        Node a = root1;
        Node b = root2;
        while(a != null || b != null || !sa.isEmpty() ||!sb.isEmpty()){
            // push left childern of root1 to sa
            while(a != null){
                sa.push(a);
                a = a.left;
            }
            // Push left children of root2 to sb
            while(b != null){
                sb.push(b);
                b = b.left;
            }
            if(sb.isEmpty() || (!sa.isEmpty()) && sa.peek().data <= sb.peek().data){
                Node atop = sa.pop();
                ans.add(atop.data);
                a = atop.right;
            }
            else{
                Node btop = sb.pop();
                ans.add(btop.data);
                b = btop.right;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(6);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);

        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(3);
        root2.right.right = new Node(7);
        root2.right.right.left = new Node(6);

        List<Integer> ans = mergTwoBST(root1, root2);
        System.out.print("After merging the two BST: ");
        for(int i: ans){
            System.out.print(i+" ");
        }
    }
}