/*
GFG: Brothers From Different Roots

Given two BSTs containing N1 and N2 distinct nodes respectively and given a value x,that returns the count of all pairs of (a, b), where a belongs to one BST and b belongs to another BST, such that a + b = x.

Example 1:

Input:
BST1:
       5
     /   \
    3     7
   / \   / \
  2   4 6   8
BST2:
       10
     /    \
    6      15
   / \    /  \
  3   8  11   18
x = 16
Output:
3
Explanation:
The pairs are: (5, 11), (6, 10) and (8, 8)

Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 106 1000000
1 ≤ X ≤ 2*106 
*/

// Time Complexity: O(N1+N2)
// Space Complexity: O(N1+N2)

import java.util.ArrayList;
import java.util.List;

public class BrothersFromDifferentRoots {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // Inorder traversal to get elements in ascending order
    public static void inorder(Node root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    // Reverse inorder traversal to get elements in descending order
    public static void reverseInorder(Node root, List<Integer> list) {
        if (root == null) return;
        reverseInorder(root.right, list); 
        list.add(root.data);
        reverseInorder(root.left, list);  
    }

    public static List<int[]> brotherRoots(Node root1, Node root2, int x) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<int[]> result = new ArrayList<>();

        inorder(root1, list1);
        reverseInorder(root2, list2);

        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            int sum = list1.get(i) + list2.get(j);
            if (sum == x) {
                result.add(new int[]{list1.get(i), list2.get(j)});
                i++;
                j++;
            }
            else if (sum < x) {
                i++;
            }
            else {
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        int x = 16;
        List<int[]> ans = brotherRoots(root1, root2, x);
        for (int[] pair : ans) {
            System.out.print("("+pair[0]+ "," +pair[1]+")");
        }
    }
}