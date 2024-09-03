/*
You are provided with a Binary Search Tree (BST), all you have to do is to convert it into the sorted doubly linked list
*/
// Time complexity: O(N);
// Space complexity: O(N);

public class ConvertBSTIntoDLL {
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
    static Node prev = null;
    public static Node convertBSTtoDLL(Node root){
        if(root == null){
            return null;
        }
        Node head = convertBSTtoDLL(root.left);
        if(prev == null){
            head = root;
        }
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertBSTtoDLL(root.right);
        return head;
    }
    public static void printLinkedList(Node head){
        Node temp = head;
        System.out.print("Printing Linked List: ");
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.right;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        Node head = convertBSTtoDLL(root);
        printLinkedList(head);
    }
}
