/*
L.C: 1019. Next Greater Node In Linked List

You are given the head of a linked list with n nodes.
For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.

Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.

Example 1:
Input: head = [2,1,5]
Output: [5,5,0]

Example 2:
Input: head = [2,7,4,3,5]
Output: [7,0,5,5,0]
 
Constraints:
The number of nodes in the list is n.
1 <= n <= 104
1 <= Node.val <= 109
*/

import java.util.ArrayList;
import java.util.Stack;
class Node{
    int data;
    Node next;

    Node(int data,Node next){
        this.next = next;
        this.data = data;
    }
    Node(int data){
        this.next = null;
        this.data = data;
    }
}
public class NextGreaterNode {
    public static Node push(Node head,int data){
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }
    public static int[] nextGreater(Node head){
        ArrayList<Integer> ll = new ArrayList<>();
        while(head != null){
            ll.add(head.data);
            head = head.next;
        }
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[ll.size()];
        for(int i = 0;i<ll.size();i++){
            while(!st.isEmpty() && ll.get(i)> ll.get(st.peek())){
                // Means,ith index is the next greater element index
                int k = st.peek();
                st.pop();
                ans[k] = ll.get(i);
            }
            st.push(i);
        }
        return ans;
    }
    public static void main(String args[]){
        Node head = null;
        head = push(head, 5);
        head = push(head, 3);
        head = push(head, 4);
        head = push(head, 7);
        head = push(head, 2);
        // while(head != null){
        //     System.out.print(head.data+" ");
        //     head = head.next;
        // }
        int result[] = nextGreater(head);
        System.out.print("Next Graeter elemnt is: ");
        for(int value: result){
            System.out.print(value+" ");
        }
    }
}
