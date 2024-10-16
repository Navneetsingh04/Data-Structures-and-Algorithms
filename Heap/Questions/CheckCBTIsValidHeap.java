/*
Check if a given Binary Tree is a Heap

Given a binary tree, check if it has heap property or not, Binary tree needs to fulfill the following two conditions for being a heap – 

It should be a complete tree (i.e. all levels except the last should be full).
Every node’s value should be greater than or equal to its child node (considering max-heap).
*/

public class CheckCBTIsValidHeap {
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
    // static class Pair{
    //     int maxValue;
    //     boolean isValid;

    //     Pair(int maxValue,boolean isValid){
    //         this.maxValue = maxValue;
    //         this.isValid = isValid;
    //     }
    // } 
    // public static Pair checkMaxHeap(Node root){
    //     if(root == null){          
    //         return new Pair(Integer.MIN_VALUE, true);
    //     }
    //     if(root.left == null && root.right == null){
    //         return new Pair(root.data, true);
    //     }
    //     Pair leftAns = checkMaxHeap(root.left);
    //     Pair rightAns = checkMaxHeap(root.right);

    //     if(root.data > leftAns.maxValue && root.data > rightAns.maxValue && leftAns.isValid && rightAns.isValid){
    //         return new Pair(root.data, true);
    //     }
    //     else{
    //         return new Pair(Math.max(leftAns.maxValue,rightAns.maxValue), false);
    //     }
    // }

    public static int countNode(Node root){
        if(root == null) return 0;
        return 1+ countNode(root.left)+countNode(root.right);
    }
    public static boolean isHeap(Node root,int index,int nodeCount){
        if(root == null) return true;

        if(index >= nodeCount) return false;
        if((root.left != null && root.data < root.left.data) || (root.right != null && root.data < root.right.data)){
            return false;
        }
        // check the left and right subtrees
        boolean leftSubtree = isHeap(root.left, 2*index+1, nodeCount);
        boolean rightSubtree = isHeap(root.right, 2*index+2, nodeCount);
        return leftSubtree && rightSubtree;
    }
    public static void main(String[] args) {
        
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(1);

        // Pair result  = checkMaxHeap(root);
        // if (result.isValid) {
        //     System.out.println("The binary tree is a valid max-heap");
        // } else {
        //     System.out.println("The binary tree is not a valid max-heap");
        // }

        int nodeCount = countNode(root);
        int index = 0;
        if(isHeap(root, index, nodeCount)){
            System.out.println("The binary tree is a valid max-heap");
        }
        else{
            System.out.println("The binary tree is not a valid max-heap");
        }
    }
}
