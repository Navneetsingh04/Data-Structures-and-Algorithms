public class SearchInBST {
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
    public static Node insertIntoBST(Node root,int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data > root.data){
            root.right = insertIntoBST(root.right, data);
        }
        else{
            root.left = insertIntoBST(root.left, data);
        }
        return root;
    }
    public static boolean searchInBST(Node root,int target){
        if(root == null) return false;
        if(root.data == target){
            return true;
        }
        boolean leftAns = false;
        boolean rightAns = false;
        if(target > root.data){
            rightAns = searchInBST(root.right, target);
        } 
        else{
            leftAns = searchInBST(root.left, target);
        } 
        return leftAns || rightAns;
    }
    public static void main(String[] args) {
        Node root = null;
        root = insertIntoBST(root, 50);
        root = insertIntoBST(root, 10);
        root = insertIntoBST(root, 90);
        root = insertIntoBST(root, 40);
        root = insertIntoBST(root, 70);
        root = insertIntoBST(root, 60);
        root = insertIntoBST(root, 80);
        int target = 60;
        boolean ans = searchInBST(root, target);
        if(ans){
            System.out.println("Target "+target+" is Found");
        }
        else{
            System.out.println("Target "+target+" is not Found");
        }
    }
}
