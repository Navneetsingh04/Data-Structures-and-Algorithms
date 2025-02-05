/*
L.C: 297. Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Example 1:
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:
Input: root = []
Output: []
 
Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000 
*/

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBT {
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
    
    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        if(root == null){
            return "";
        }
        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp == null){
                res.append("# ");
                continue;
            }
            res.append(temp.data+" ");
            q.add(temp.left);
            q.add(temp.right);
        }
        return res.toString();
    }

    // Decodes encoded data to tree.
    public static Node deserialize(String data) {
        if(data == "") return null;
        Queue<Node> q = new LinkedList<>();
        String values[] = data.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);
        for(int i = 1;i<values.length;i++){
            Node parent = q.poll();
            if(!values[i].equals("#")){
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            i++;
            if(i < values.length && !values[i].equals("#")){
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
    public static void printLevelOrder(Node root){
        if(root == null) return;
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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        String serial = serialize(root);
        Node deseral = deserialize(serial);

        System.out.println("Serialize String: "+serial);
        System.out.print("Level order traversal for deserialize Binary tree: ");
        printLevelOrder(deseral);
    }
}
