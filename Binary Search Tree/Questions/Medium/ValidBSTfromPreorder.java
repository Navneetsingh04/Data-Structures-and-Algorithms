/*
Valid BST from Preorder

You are given a preorder traversal A, of a Binary Search Tree.
Find if it is a valid preorder traversal of a BST.

Note: Binary Search Tree by definition has distinct keys and duplicates in binary search tree are not allowed.

Problem Constraints
1 <= A[i] <= 106
1 <= |A| <= 105

Input Format
First and only argument is an integer array A denoting the pre-order traversal.

Output Format
Return an integer:
0 : Impossible preorder traversal of a BST
1 : Possible preorder traversal of a BST

Example Input
Input 1:
A = [7, 7, 10, 10, 9, 5, 2, 8]

Example Output
Output 1: 0
*/
public class ValidBSTfromPreorder {
    static int i = 0; 
    public static void build(int min, int max, int[] preorder) {
        if (i >= preorder.length) return;
        if (preorder[i] > min && preorder[i] < max) {
            int rootData = preorder[i++];
            // left subtree
            build(min, rootData, preorder);
            // right subtree
            build(rootData, max, preorder);
        }
    }
    public static int isValidBST(int[] preorder) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        // Reset index before starting
        i = 0;  
        build(min, max, preorder);
        if (i == preorder.length) {
            return 1;  
        }
        return 0;  
    }
    public static void main(String[] args) {
        int[] preorder = {10,8,7,9,20,21,15 };
        int ans = isValidBST(preorder);
        if(ans == 1){
            System.out.println("It is a valid BST from preorder");
        }
        else{
            System.out.println("It is not a valid BST from preorder");
        }
    }
}
