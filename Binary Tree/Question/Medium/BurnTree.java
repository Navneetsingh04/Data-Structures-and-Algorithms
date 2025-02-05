/*
L.C 2385: You have a binary tree of 'N' unique nodes and a Start node from where the tree will start to burn. Given that the Start node will always exist in the tree, your task is to print the time (in minutes) that it will take to burn the whole tree.

It is given that it takes 1 minute for the fire to travel from the burning node to its adjacent node and burn down the adjacent node.

For Example :
binary tree: [1, 2, 3, -1, -1, 4, 5, -1, -1, -1, -1]
Start Node: 3

    1
   / \
  2   3
     / \
    4   5

Output: 2

Explanation :
In the zeroth minute, Node 3 will start to burn.

After one minute, Nodes (1, 4, 5) that are adjacent to 3 will burn completely.

After two minutes, the only remaining Node 2 will be burnt and there will be no nodes remaining in the binary tree. 

So, the whole tree will burn in 2 minutes.
Input Format :
The first line contains elements of the tree in the level order form. The line consists of values of nodes separated by a single space. In case a node is null, we take -1 in its place.

The second line of input contains the value of the start node.

For example, the input for the tree depicted in the above image would be :

1
2 3
4 -1 5 6
-1 7 -1 -1 -1 -1
-1 -1
Explanation :
Level 1 :
The root node of the tree is 1

Level 2 :
Left child of 1 = 2
Right child of 1 = 3

Level 3 :
Left child of 2 = 4
Right child of 2 = null (-1)
Left child of 3 = 5
Right child of 3 = 6

Level 4 :
Left child of 4 = null (-1)
Right child of 4 = 7
Left child of 5 = null (-1)
Right child of 5 = null (-1)
Left child of 6 = null (-1)
Right child of 6 = null (-1)

Level 5 :
Left child of 7 = null (-1)
Right child of 7 = null (-1)
Note :
The above format was just to provide clarity on how the input is formed for a given tree. 
The sequence will be put together in a single line separated by a single space. Hence, for the above-depicted tree, the input will be given as:

1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
Output Format
Print a single integer denoting the time in minutes that will be taken to burn the whole tree.
 */

import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
public class BurnTree {
    public static int findMaxDistance(Map<Node, Node> parentMap, Node target) {
        Queue<Node> q = new LinkedList<>();
        q.add(target);
        Map<Node, Boolean> visited = new HashMap<>();
        visited.put(target, true);
        int maxDistance = 0;
 
        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;
 
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if(node.left != null && !visited.containsKey(node.left)) {
                    flag = true;
                    visited.put(node.left, true);
                    q.add(node.left);
                }
                if(node.right != null && !visited.containsKey(node.right)) {
                    flag = true;
                    visited.put(node.right, true);
                    q.add(node.right);
                }
                if(parentMap.get(node) != null && !visited.containsKey(parentMap.get(node))) {
                    flag = true;
                    visited.put(parentMap.get(node), true);
                    q.add(parentMap.get(node));
                }
            }
            if(flag)maxDistance++;
        }
        return maxDistance;
    }
 
    public static Node bfsToMapParents(Node root, Map<Node, Node> parentMap, int start) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node target = null;
 
        while (!q.isEmpty()) {
            Node node = q.poll();
            if(node.data == start) target = node;
            if(node.left != null) {
                parentMap.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null) {
                parentMap.put(node.right, node);
                q.add(node.right);
            }
        }
        return target;
    }
    public static int timeToBurnTree(Node root, int start) {
        Map<Node, Node> parentMap = new HashMap<>();
        Node target = bfsToMapParents(root, parentMap, start);
        return findMaxDistance(parentMap, target);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        int start = root.left.data;

        int ans = timeToBurnTree(root, start);
        System.out.println("Time to burn the Tree is: "+ans);
    }
}
 