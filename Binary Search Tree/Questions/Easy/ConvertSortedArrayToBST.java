/*
L.C:  108. Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
*/

import java.util.LinkedList;
import java.util.Queue;

public class ConvertSortedArrayToBST {
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
    public static Node createBST(int arr[],int start,int end){
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, start, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }
    public static Node sortedArrayToBST(int arr[]){
        if(arr.length == 0){
            return null;
        }
        return createBST(arr,0,arr.length-1);
    }
    public static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(temp.data+" ");
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {-10,-3,0,5,9};
        Node root = sortedArrayToBST(arr);
        System.out.print("Binary Tree After converting from Sorted Array: ");
        levelOrderTraversal(root);
    }
}
