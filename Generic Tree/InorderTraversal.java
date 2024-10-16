public class InorderTraversal {
    static class Node{
        int data;
        Node children[];

        Node(int n,int data){
            children = new Node[n];
            this.data = data;
        }
    }
    static void inorder(Node root){
        if(root == null){
            return;
        }
        // total number children 
        int total = root.children.length;
        // all children except the last
        for(int i = 0;i<total-1;i++){
            inorder(root.children[i]);
        }
        // Printing the current node data
        System.out.print(root.data+" ");
        // printing the last child
        inorder(root.children[total-1]);
    }
    public static void main(String[] args) {
        /*
                  1
                / | \
               2  3  4
             / | \
            5  6  7 
        */
        int n = 3;
        Node root = new Node(n, 1);
        root.children[0] = new Node(n, 2);
        root.children[1] = new Node(n, 3);
        root.children[2] = new Node(n, 4);
        root.children[0].children[0] = new Node(n, 5);
        root.children[0].children[1] = new Node(n, 6);
        root.children[0].children[2] = new Node(n, 7);
        System.out.print("Inorder Traversal of N- array Tree is: ");
        inorder(root);
    }
}
