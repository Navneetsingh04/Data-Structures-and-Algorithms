/*
L.C: 2487. Remove Nodes From Linked List

You are given the head of a linked list.
Remove every node which has a node with a greater value anywhere to the right side of it.
Return the head of the modified linked list.

Example 1:
Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.
Example 2:

Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.
 
Constraints:
The number of the nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
*/
public class RemoveNodeFromLL {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    } 
    public static Node convertToLL(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev= curr;
            curr = temp;
        }
        return prev;
    }
    public static Node removeNodes(Node head) {
        if(head == null){
            return head;
        }
        // reverse linked list
        Node reverseHead = reverse(head);
        // remove the nodes that have a greater value of their left
        int max = reverseHead.data;
        Node prev = reverseHead;
        Node curr = reverseHead.next;
        while(curr != null){
            if(curr.data >= max){
                max = curr.data;
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = null; //Terminate the list
        return reverse(reverseHead);
    }
    public static void main(String[] args) {
        int arr[] = {5,2,13,3,8};
        Node head = convertToLL(arr);
        printLL(head);
        Node reslutingLL = removeNodes(head);
        printLL(reslutingLL);
    }
    
}
