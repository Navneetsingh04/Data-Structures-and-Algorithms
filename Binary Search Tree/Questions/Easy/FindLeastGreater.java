/*
GFG: Replace every element with the least greater element on its right

Given an array arr[] of N integers and replace every element with the least greater element on its right side in the array. If there are no greater elements on the right side, replace it with -1. 

Example 1:

Input:
arr[] = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28}
Output: {18, 63, 80, 25, 32, 43, 80, 93, 80, 25, 93, -1, 28, -1, -1}
Explanation: 
The least next greater element of 8 is 18.
The least next greater element of 58 is 63 and so on.

Example 2:

Input:
arr[] = {2, 6, 9, 1, 3, 2}
Output: {3, 9, -1, 2, -1, -1}
Explanation: 
The least next greater element of 2 is 3. 
The least next greater element of 6 is 9.
least next greater element for 9 does not
exist and so on.

Constraints:
1 <= N <= 105
1 <= A[i] <= 105 
*/

import java.util.ArrayList;
import java.util.Collections;

public class FindLeastGreater {
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
    public static Node insertIntoBST(Node root,int val,int succ[]){
        if(root == null){
            return new Node(val);
        }
        if(val >= root.data){
            root.right = insertIntoBST(root.right, val, succ);
        }
        else{
            succ[0] = root.data;
            root.left = insertIntoBST(root.left, val, succ);
        }
        return root;
    }
    public static ArrayList<Integer> findLeastGreater(int[] arr,int n) {
        ArrayList<Integer> list = new ArrayList<>(n);
        Node root = null;
        for(int i = n-1;i>=0;i--){
            int succ[] = new int[1];
            succ[0] = -1;
            root = insertIntoBST(root,arr[i],succ);
            list.add(succ[0]);
        }
        Collections.reverse(list);
        return list;
    }
    public static void main(String[] args) {
        int arr[] = {8,58,71,18,31,32,63,92,43,3,91,93,25,80,28};
        int n = arr.length;
        ArrayList<Integer> ans = findLeastGreater(arr,n);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }
}
