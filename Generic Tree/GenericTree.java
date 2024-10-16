import java.util.ArrayList;
import java.util.Scanner;
public class GenericTree {
    static class Node {
        int data;
        ArrayList<Node> children;
        Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
    // Method to create a tree
    static Node createTree() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the value for the root node: ");
        int data = s.nextInt();
        Node root = new Node(data);
        createTreeHelper(root, s);
        return root;
    }
    // Helper method to recursively create the tree
    static void createTreeHelper(Node node, Scanner s) {
        System.out.print("Enter the number of children for node " + node.data + ": ");
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the value for child " + (i + 1) + " of node " + node.data + ": ");
            int childData = s.nextInt();
            Node child = new Node(childData);
            node.children.add(child);
            createTreeHelper(child, s);
        }
    }
    // Method to display the tree
    static void displayTree(Node node) {
        if (node == null) return;
        // Display current node and its children
        System.out.print(node.data + " -> ");
        for(Node child : node.children) {
            System.out.print(child.data + " ");
        }
        System.out.println();
        for(Node child : node.children) {
            displayTree(child);
        }
    }
    public static void main(String[] args) {
        Node root = createTree();
        System.out.println("Displaying the tree:");
        displayTree(root);
    }
}

//      1
//     /|\
//    2 3 4
//   /|   |\
//  5 6   7 8
